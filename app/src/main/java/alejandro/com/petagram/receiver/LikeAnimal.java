package alejandro.com.petagram.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Alejandro on 20/07/2016.
 */
public class LikeAnimal extends BroadcastReceiver {

    private static final String TAG = LikeAnimal.class.getName();

    @Override
    public void onReceive(Context context, Intent intent) {

        String ACTION_KEY = "LIKE_ANIMAL";

        String accion = intent.getAction();

        Log.i(TAG, "Accion: " + accion);

        if (accion.equals(ACTION_KEY)) {
            Toast.makeText(context, "abriendo aplicacion :O", Toast.LENGTH_SHORT).show();
            Log.i(TAG, "Intentando abrir aplicacion desde el wear");
            abrirAplicacion(context);
        }


    }

    public void abrirAplicacion(Context context) {
        Intent intent = new Intent();

        intent.setClassName("alejandro.com.petagram", "alejandro.com.petagram.activity.MainActivity");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

    }
}
