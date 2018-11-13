package com.carlosintranets.simpleservice;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

/**
 * Created by Carlos M on 12/11/2018.
 */

public class ReceptorMensaje extends ResultReceiver {
    private MainActivity.Mensaje Mess;

    public ReceptorMensaje(MainActivity.Mensaje Mensaje) {
        super(new Handler());
        this.Mess = Mensaje;
    }

    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        Mess.mostar( resultCode, resultData);
    }
}
