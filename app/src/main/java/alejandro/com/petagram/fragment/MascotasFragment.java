package alejandro.com.petagram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import alejandro.com.petagram.adapter.MascotaAdapter;
import alejandro.com.petagram.R;
import alejandro.com.petagram.pojo.Mascota;


/**
 * A simple {@link Fragment} subclass.
 */
public class MascotasFragment extends Fragment {


    private static final String TAG = MascotasFragment.class.getName();
    private List<Mascota> mascotas;
    private RecyclerView vista;


    public MascotasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mascotas, container, false);
        vista = (RecyclerView) view.findViewById(R.id.rvMascotas);

        Log.i(TAG, "Llenando lista de mascotas");
        generarMascotas();
        Log.i(TAG, "Iniciand adaptador");
        inicarAdaptador();


        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        vista.setLayoutManager(llm);


        return view;
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
}
