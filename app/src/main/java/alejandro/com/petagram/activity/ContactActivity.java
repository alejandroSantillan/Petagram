package alejandro.com.petagram.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.util.concurrent.ExecutionException;

import alejandro.com.petagram.R;
import alejandro.com.petagram.async.EmailAsync;

public class ContactActivity extends AppCompatActivity {

    private static final String TAG = ContactActivity.class.getName();
    private Toolbar toolbar;
    private EditText nombre;
    private EditText correo;
    private EditText mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        generarToolbar();

        nombre = (EditText) findViewById(R.id.nombre);
        correo = (EditText) findViewById(R.id.email);
        mensaje = (EditText) findViewById(R.id.mensaje);

    }


    private void generarToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    public void enviarCorreo(View view) {

        EmailAsync emailAsync = new EmailAsync();

        emailAsync.execute(correo.getText().toString(), mensaje.getText().toString());

        try {
            Object ob = emailAsync.get();
            if (ob != null) {
                Snackbar.make(view,ob.toString(),Snackbar.LENGTH_LONG).show();
            }else{
                Snackbar.make(view,"Mensaje no enviado :(",Snackbar.LENGTH_LONG).show();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
