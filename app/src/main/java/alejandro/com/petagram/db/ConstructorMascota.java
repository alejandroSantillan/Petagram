package alejandro.com.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import java.util.List;

import alejandro.com.petagram.R;
import alejandro.com.petagram.pojo.Mascota;

/**
 * Created by Alejandro on 12/06/2016.
 */
public class ConstructorMascota {

    private static final int LIKE = 1;
    private Context context;


    public ConstructorMascota(Context context) {
        this.context = context;
    }

    public List<Mascota> obtenerDatos(){
        BaseDatos bd = new BaseDatos(context);
        insertarMascotas(bd);
        return bd.obtenerMascotas();
    }

    public void insertarMascotas(BaseDatos bd){
        ContentValues cv = new ContentValues();
        cv.put(CBD.TABLE_MASCOTA_NOMBRE,"León");
        cv.put(CBD.TABLE_MASCOTA_IMAGEN, R.drawable.leon);
        bd.insertarMascota(cv);

        cv = new ContentValues();
        cv.put(CBD.TABLE_MASCOTA_NOMBRE,"Cabra");
        cv.put(CBD.TABLE_MASCOTA_IMAGEN, R.drawable.cabra);
        bd.insertarMascota(cv);
        cv = new ContentValues();
        cv.put(CBD.TABLE_MASCOTA_NOMBRE,"Gato");
        cv.put(CBD.TABLE_MASCOTA_IMAGEN, R.drawable.gato);
        bd.insertarMascota(cv);
        cv = new ContentValues();
        cv.put(CBD.TABLE_MASCOTA_NOMBRE,"Gusano");
        cv.put(CBD.TABLE_MASCOTA_IMAGEN, R.drawable.gusano);
        bd.insertarMascota(cv);
        cv = new ContentValues();
        cv.put(CBD.TABLE_MASCOTA_NOMBRE,"Perro");
        cv.put(CBD.TABLE_MASCOTA_IMAGEN, R.drawable.tortuga);
        bd.insertarMascota(cv);
        cv = new ContentValues();
        cv.put(CBD.TABLE_MASCOTA_NOMBRE,"Tucan");
        cv.put(CBD.TABLE_MASCOTA_IMAGEN, R.drawable.tucan);
        bd.insertarMascota(cv);


    }

    public void darRatingMascota(Mascota mascota){
        BaseDatos bd = new BaseDatos(context);
        ContentValues cv = new ContentValues();
        cv.put(CBD.TABLE_MASCOTA_RATING_ID_MASCOTA,mascota.getIdMascota());
        cv.put(CBD.TABLE_MASCOTA_RATING_RATING,LIKE);
        bd.insertarRatingMascota(cv);

    }

    public int obtenerRatingMascota(Mascota mascota){
        BaseDatos bd = new BaseDatos(context);
        return bd.obtenerRatingMascota(mascota);
    }

    public List<Mascota> obtenerCincoMejoresMascotas(){
        BaseDatos bd = new BaseDatos(context);
        return bd.obtenerCincoMejoresMascotas();
    }
}
