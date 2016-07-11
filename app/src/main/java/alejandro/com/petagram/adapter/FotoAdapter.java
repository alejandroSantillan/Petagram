package alejandro.com.petagram.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

import alejandro.com.petagram.R;
import alejandro.com.petagram.pojo.Mascota;
import alejandro.com.petagram.restApi.ConstantesRestApi;
import alejandro.com.petagram.restApi.EndPointApi;
import alejandro.com.petagram.restApi.JsonKeys;
import alejandro.com.petagram.restApi.adapter.RestApiAdapter;
import alejandro.com.petagram.restApi.model.LikeResponse;
import alejandro.com.petagram.restApi.model.UsuarioResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Alejandro on 04/06/2016.
 */
public class FotoAdapter extends RecyclerView.Adapter<FotoAdapter.FotoHolder> {


    private static final String TAG = FotoAdapter.class.getName();
    private List<Mascota> fotos;
    private Context context;

    public FotoAdapter(List<Mascota> fotos, Context context) {
        this.fotos = fotos;
        this.context = context;
    }

    @Override
    public FotoHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Log.i(TAG, "Creando la vista");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.info_mascota, parent, false);

        return new FotoHolder(view);
    }

    @Override
    public void onBindViewHolder(FotoHolder holder, int position) {

        final Mascota foto = fotos.get(position);
        Log.i(TAG, "foto: " + foto.getImagen());
        Log.i(TAG, "likes: " + foto.getLikes());

        holder.cantidad.setText(String.valueOf(foto.getLikes()));
        Picasso.with(context)
                .load(foto.getImagen())
                .placeholder(R.drawable.footprint).into(holder.imagen);

        holder.imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "ID: " + foto.getIdMascota(), Toast.LENGTH_SHORT).show();

                enviandoLikeInstagram(foto);

            }


        });

    }

    private void notificarLike() {

        Log.i(TAG,"3");
        RestApiAdapter rest = new RestApiAdapter();
        EndPointApi api = api = rest.establecerConexionRestApiFireBase();
        SharedPreferences preps = context.getSharedPreferences("datosPersonales", Context.MODE_PRIVATE);
        String idRegistro = preps.getString("idRegistro", "");
        String nombre = preps.getString(JsonKeys.USER_FULL_NAME, "");

        Call<UsuarioResponse> usuarioResponseCall = api.notificacionLike(idRegistro, nombre);

        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                Log.i(TAG, "notificacion enviada :D");
            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {
                Log.i(TAG, "Notificacion no Enviada :'( ");
            }
        });


    }

    private void enviandoRegistroFireBase(Mascota foto) {

        Log.i(TAG,"2");
        RestApiAdapter rest = new RestApiAdapter();
        EndPointApi api = api = rest.establecerConexionRestApiFireBase();
        SharedPreferences preps = context.getSharedPreferences("datosPersonales", Context.MODE_PRIVATE);
        String idRegistro = preps.getString("idRegistro", "");
        String idImagen = foto.getIdMascota();
        String idUsuario = preps.getString(JsonKeys.USER_ID, "");


        Call<UsuarioResponse> responseCall = api.registrarMediaLike(idRegistro, idImagen, idUsuario);

        responseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {

                Log.i(TAG, "Registro guardado en Firebase");
                notificarLike();
            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {
                Log.i(TAG, "Registro NO guardado en Firebase");
            }
        });
    }

    private void enviandoLikeInstagram(final Mascota foto) {

        Log.i(TAG,"1");
        RestApiAdapter rest = new RestApiAdapter();
        final Gson like = rest.construyendoGsonDeserializadorLike();
        EndPointApi api = rest.establecerConexionRestApiInstagram(like);

        final Call<LikeResponse> likeResponseCall = api.postLike(foto.getIdMascota(), ConstantesRestApi.ACCESS_TOKEN);

        likeResponseCall.enqueue(new Callback<LikeResponse>() {
            @Override
            public void onResponse(Call<LikeResponse> call, Response<LikeResponse> response) {

                LikeResponse likeR = response.body();

                Log.i(TAG, "like: " + likeR);

                if (likeR != null && likeR.isSuccessfull()) {
                    Toast.makeText(context, "Like dado :D", Toast.LENGTH_SHORT).show();
                    enviandoRegistroFireBase(foto);

                } else {
                    Toast.makeText(context, "No Like dado :(", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<LikeResponse> call, Throwable t) {
                Toast.makeText(context, "Fallo hacer like :( ", Toast.LENGTH_SHORT).show();
                Log.i(TAG, "Error: " + t.toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return fotos.size();
    }

    public static class FotoHolder extends RecyclerView.ViewHolder {

        private ImageView imagen;
        private TextView cantidad;

        public FotoHolder(View itemView) {
            super(itemView);
            imagen = (ImageView) itemView.findViewById(R.id.imagenFoto);
            cantidad = (TextView) itemView.findViewById(R.id.textoCantidad);
        }
    }
}
