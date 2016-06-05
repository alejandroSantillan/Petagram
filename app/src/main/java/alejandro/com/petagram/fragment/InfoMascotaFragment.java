package alejandro.com.petagram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import alejandro.com.petagram.R;
import alejandro.com.petagram.adapter.FotoAdapter;
import alejandro.com.petagram.pojo.FotoMascota;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoMascotaFragment extends Fragment {

    private static final String TAG = InfoMascotaFragment.class.getName();
    private List<FotoMascota> fotos;
    private RecyclerView recyclerView;

    public InfoMascotaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info_mascota, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rvInfoMascota);
        generarImagenes();
        iniciarAdaptador();

        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        recyclerView.setLayoutManager(glm);

        return view;
    }

    private void iniciarAdaptador() {
        FotoAdapter fa = new FotoAdapter(fotos);
        recyclerView.setAdapter(fa);
        recyclerView.setHasFixedSize(true);

    }

    private void generarImagenes() {
        fotos = new ArrayList<>();
        fotos.add(new FotoMascota(R.drawable.gato,"1"));
        fotos.add(new FotoMascota(R.drawable.gato,"10"));
        fotos.add(new FotoMascota(R.drawable.gato,"3"));
        fotos.add(new FotoMascota(R.drawable.gato,"2"));
        fotos.add(new FotoMascota(R.drawable.gato,"6"));
        fotos.add(new FotoMascota(R.drawable.gato,"9"));
        fotos.add(new FotoMascota(R.drawable.gato,"5"));
        fotos.add(new FotoMascota(R.drawable.gato,"3"));
        fotos.add(new FotoMascota(R.drawable.gato,"6"));
    }

}
