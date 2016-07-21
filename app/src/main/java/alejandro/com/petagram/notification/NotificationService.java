package alejandro.com.petagram.notification;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;
import android.view.Gravity;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import alejandro.com.petagram.R;

/**
 * Created by Alejandro on 20/07/2016.
 */
public class NotificationService extends FirebaseMessagingService {

    private static final String TAG = NotificationService.class.getName();
    private static final int ID_NOTIFICATION = 001;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Log.i(TAG,"sirvió esta madre sin moverle nada :D");

        Log.i(TAG, "FROM: " + remoteMessage.getFrom());
        Log.i(TAG, "Notificacion mensaje cuerpo: " + remoteMessage.getNotification().getBody());

        Intent i = new Intent();
        i.setAction("LIKE_ANIMAL");

        //PendingIntent pi = PendingIntent.getActivity(this, 0, i, PendingIntent.FLAG_ONE_SHOT);
        PendingIntent pi = PendingIntent.getBroadcast(this, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);


        NotificationCompat.Action action = new NotificationCompat.Action.Builder(R.drawable.ic_full_love, getString(R.string.texto_accion_like), pi).build();

        NotificationCompat.WearableExtender wearableExtender =
                new NotificationCompat.WearableExtender()
                        .setHintHideIcon(true)
                        .setBackground(BitmapFactory.decodeResource(getResources(),
                                R.drawable.cat_back))
                        .setGravity(Gravity.CENTER_VERTICAL);


        Uri sonido = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);


        NotificationCompat.Builder notificacion = new NotificationCompat.Builder(this)
                .setSmallIcon(android.R.drawable.ic_notification_overlay)
                .setContentTitle("Han hecho like a una imagen tuya!")
                .setContentText(remoteMessage.getNotification().getBody())
                .setSound(sonido)
                .setAutoCancel(true)
                .setContentIntent(pi)
                .extend(wearableExtender.addAction(action));

        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(this);

        notificationManager.notify(ID_NOTIFICATION, notificacion.build());



    }
}
