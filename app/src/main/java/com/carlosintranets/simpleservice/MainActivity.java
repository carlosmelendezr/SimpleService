package com.carlosintranets.simpleservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ReceptorMensaje messRec = new ReceptorMensaje(new Mensaje());

        MensajeOne mess = new MensajeOne();

        Intent intento = new Intent(this,MensajeOne.class);
        intento.putExtra("maximo",20);
        intento.putExtra("mensaje",messRec);

        Log.v(Constants.APP_NAME,"Iniciando Servicio");
        startService(intento);

    }

    public class Mensaje {
        public void mostar(int resultCode, Bundle resultData) {
            String mensaje = resultData.getString("mensaje");
            Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();
        }
    }
}
