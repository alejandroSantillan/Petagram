package alejandro.com.petagram.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import alejandro.com.petagram.R;
import alejandro.com.petagram.pojo.FotoMascota;

/**
 * Created by Alejandro on 04/06/2016.
 */
public class FotoAdapter extends RecyclerView.Adapter<FotoAdapter.FotoHolder> {


    private List<FotoMascota> fotos;

    public FotoAdapter(List<FotoMascota> fotos) {
        this.fotos = fotos;
    }

    @Override
    public FotoHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.info_mascota,parent,false);

        return new FotoHolder(view);
    }

    @Override
    public void onBindViewHolder(FotoHolder holder, int position) {

        FotoMascota foto = fotos.get(position);

        holder.imagen.setImageResource(foto.getImagen());
        holder.cantidad.setText(foto.getCantidad());

    }

    @Override
    public int getItemCount() {
        return fotos.size();
    }

    public static class FotoHolder  extends RecyclerView.ViewHolder{

        private ImageView imagen;
        private TextView cantidad;

        public FotoHolder(View itemView) {
            super(itemView);
            imagen = (ImageView) itemView.findViewById(R.id.imagenFoto);
            cantidad = (TextView) itemView.findViewById(R.id.textoCantidad);
        }
    }
}
