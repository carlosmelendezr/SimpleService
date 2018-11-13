package com.carlosintranets.simpleservice;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Log;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Carlos M on 07/11/2018.
 */

public class MensajeOne extends IntentService {
    private int counter;
    private int maximo;
    private Timer tm;
    private ResultReceiver Rs;

    private TimerTask task = new TimerTask() {
            public void run() {
                Log.v(Constants.APP_NAME,"counter = "+counter);
                counter ++;
                if (counter > maximo)
                {
                    Bundle bun = new Bundle();
                    bun.putString("mensaje","Fin del conteo !!!!");
                    Rs.send(1234,bun);

                    Log.v(Constants.APP_NAME,"Deteniendo Servicio = "+counter);
                    this.cancel();
                    stopSelf();
                }
            }
    };

    public MensajeOne() {
        super("SimpleService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        counter = 0;
        tm = new Timer();
        tm.schedule(task,3000,1000);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

    }

    

    @Override
    protected void onHandleIntent(Intent intent) {
        maximo = intent.getIntExtra("maximo",20);
        Rs = intent.getParcelableExtra("mensaje");

    }
}
