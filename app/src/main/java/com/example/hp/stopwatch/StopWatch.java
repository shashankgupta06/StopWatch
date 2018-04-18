package com.example.hp.stopwatch;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.Toast;

public class StopWatch extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Alarm...",Toast.LENGTH_LONG).show();
        Vibrator v = (Vibrator)context.getSystemService(context.VIBRATOR_SERVICE);
        v.vibrate(2000);
    }
}
