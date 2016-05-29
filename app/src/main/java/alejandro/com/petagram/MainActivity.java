package alejandro.com.petagram;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    private Toolbar toolbar;
    FloatingActionButton fabFavoritos;

    private List<Mascota> mascotas;
    private RecyclerView vista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generarToolbar();
        vista = (RecyclerView) findViewById(R.id.rvMascotas);

        Log.i(TAG, "Llenando lista de mascotas");
        generarMascotas();
        Log.i(TAG, "Iniciand adaptador");
        inicarAdaptador();


        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        vista.setLayoutManager(llm);

        fabFavoritos = (FloatingActionButton) findViewById(R.id.fabFavoritos);
        mostrarFavoritos();

    }

    private void inicarAdaptador() {
        MascotaAdapter ma = new MascotaAdapter(mascotas);
        vista.setAdapter(ma);
    }

    private void generarMascotas() {
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.leon, "León", 5, true));
        mascotas.add(new Mascota(R.drawable.cabra, "Cabra", 3, true));
        mascotas.add(new Mascota(R.drawable.gato, "Gato", 8, false));
        mascotas.add(new Mascota(R.drawable.gusano, "Gusano", 2, true));
        mascotas.add(new Mascota(R.drawable.perro, "Perro", 15, false));
        mascotas.add(new Mascota(R.drawable.tortuga, "Tortuga", 4, true));
        mascotas.add(new Mascota(R.drawable.tucan, "Tucán", 7, true));

    }

    private void generarToolbar() {
        toolbar = (Toolbar) findViewById(R.id.action_bar);
        toolbar.setLogo(R.drawable.footprint);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);


    }

    public void mostrarFavoritos() {

        fabFavoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "abriendo la otra actividad.");
                Intent intent = new Intent(MainActivity.this, FavoritoActivity.class);
                startActivity(intent);

            }
        });


    }
}
