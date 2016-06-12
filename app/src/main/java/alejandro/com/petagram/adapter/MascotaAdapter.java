package alejandro.com.petagram.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import alejandro.com.petagram.R;
import alejandro.com.petagram.db.ConstructorMascota;
import alejandro.com.petagram.pojo.Mascota;

/**
 * Created by Alejandro on 28/05/2016.
 */
public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaHolder> {

    private List<Mascota> mascotas;
    private Context context;
    private static final String TAG = MascotaAdapter.class.getName();

    public MascotaAdapter(List<Mascota> mascotas, Context context) {
        this.mascotas = mascotas;
        this.context = context;
    }


    @Override
    public MascotaHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Log.i(TAG, "Creando view holder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaHolder(view);

    }

    @Override
    public void onBindViewHolder(final MascotaHolder holder, int position) {

        Log.i(TAG, "Llenando objeto");
        final Mascota mascota = mascotas.get(position);

        holder.imagen.setImageResource(mascota.getImagen());
        holder.nombre.setText(mascota.getNombre());
        holder.cantidad.setText(String.valueOf(mascota.getRating()));


        holder.huesoLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "haciendo like");
                ConstructorMascota cm = new ConstructorMascota(context);
                cm.darRatingMascota(mascota);
                holder.cantidad.setText(String.valueOf(cm.obtenerRatingMascota(mascota)));

            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaHolder extends RecyclerView.ViewHolder {

        private ImageView imagen;
        private TextView nombre;
        private TextView cantidad;
        private ImageButton huesoLike;
        private ImageButton huesoRating;

        public MascotaHolder(View view) {
            super(view);
            imagen = (ImageView) view.findViewById(R.id.imgFoto);
            nombre = (TextView) view.findViewById(R.id.nombreMascota);
            cantidad = (TextView) view.findViewById(R.id.cantidadRating);
            huesoLike = (ImageButton) view.findViewById(R.id.imgLike);
            huesoRating = (ImageButton) view.findViewById(R.id.imgRating);

        }
    }
}

