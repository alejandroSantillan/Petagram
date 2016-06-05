package alejandro.com.petagram.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import alejandro.com.petagram.adapter.MascotaAdapter;
import alejandro.com.petagram.R;
import alejandro.com.petagram.pojo.Mascota;

public class FavoritoActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private List<Mascota> mascotas;
    private RecyclerView vista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorito);
        generarToolbar();
        generarMascotas();
        vista = (RecyclerView) findViewById(R.id.rvMascotas);
        inicarAdaptador();
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        vista.setLayoutManager(llm);

    }


    private void generarMascotas() {
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.leon, "León", 5, true));
        mascotas.add(new Mascota(R.drawable.cabra, "Cabra", 3, true));
        mascotas.add(new Mascota(R.drawable.gusano, "Gusano", 2, true));
        mascotas.add(new Mascota(R.drawable.tortuga, "Tortuga", 4, true));
        mascotas.add(new Mascota(R.drawable.tucan, "Tucán", 7, true));

    }

    private void inicarAdaptador() {
        MascotaAdapter ma = new MascotaAdapter(mascotas);
        vista.setAdapter(ma);
    }

    private void generarToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}
