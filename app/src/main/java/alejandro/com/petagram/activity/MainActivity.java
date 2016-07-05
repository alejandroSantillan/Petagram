package alejandro.com.petagram.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.google.firebase.iid.FirebaseInstanceId;

import java.util.ArrayList;
import java.util.List;

import alejandro.com.petagram.R;
import alejandro.com.petagram.adapter.PageAdapter;
import alejandro.com.petagram.fragment.InfoMascotaFragment;
import alejandro.com.petagram.restApi.EndPointApi;
import alejandro.com.petagram.restApi.JsonKeys;
import alejandro.com.petagram.restApi.adapter.RestApiAdapter;
import alejandro.com.petagram.restApi.model.UsuarioResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewGroup view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = (ViewGroup) findViewById(R.id.layoutPrincipal);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        generarToolbar();
        setupViewPager();


    }

    private void generarToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setLogo(R.drawable.footprint);
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.mFavorito:
                Intent intent = new Intent(MainActivity.this, FavoritoActivity.class);
                startActivity(intent);
                break;
            case R.id.mAbout:
                Intent about = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(about);
                break;
            case R.id.mContact:
                Intent contact = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(contact);
                break;
            case R.id.mConfigurarCuenta:
                Intent configurar = new Intent(MainActivity.this, ConfigurarCuentaActivity.class);
                startActivity(configurar);
                break;
            case R.id.mNotificaciones:

                recibirNotificaciones();


        }
        return true;
    }

    private void recibirNotificaciones() {

        final SharedPreferences preps = getSharedPreferences("datosPersonales", Context.MODE_PRIVATE);


        String idDispositivo = FirebaseInstanceId.getInstance().getToken();
        String fullName = preps.getString(JsonKeys.USER_FULL_NAME, "");
        String idUsuario = preps.getString(JsonKeys.USER_ID, "");

        if(!idUsuario.equals("")){


        RestApiAdapter api = new RestApiAdapter();
        EndPointApi ep = api.establecerConexionRestApiFireBase();
        Call<UsuarioResponse> usuarioResponseCall = ep.registrarDispositivo(idDispositivo, fullName, idUsuario);

        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {

                UsuarioResponse usuario = response.body();
                Snackbar.make(view,"Registro completado con el id: "+usuario.getId(),Snackbar.LENGTH_LONG).show();
                Log.i(TAG,"registro creado: "+usuario.getId());
                SharedPreferences.Editor edit = preps.edit();
                edit.putString("idRegistro",usuario.getId());
                edit.commit();
            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {
                Snackbar.make(view, "Error al conectar con el servdor.", Snackbar.LENGTH_LONG).show();
                Log.i(TAG, "no se pudo conectar al servidor");
            }
        });

        }else{
            Snackbar.make(view,"Debes asociar un usuario de Instagram para recibir notificaciones.",Snackbar.LENGTH_LONG).show();
        }

    }


    private List<Fragment> agregarFragments() {
        List<Fragment> fragments = new ArrayList<>();
        //fragments.add(new MascotasFragment());
        fragments.add(new InfoMascotaFragment());

        return fragments;
    }

    private void setupViewPager() {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        //tabLayout.getTabAt(1).setIcon(R.drawable.ic_cat);
    }
}
