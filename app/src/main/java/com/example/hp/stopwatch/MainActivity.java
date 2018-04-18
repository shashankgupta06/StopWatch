package com.example.hp.stopwatch;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {


    Button btn;
    EditText edTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        edTime = (EditText) findViewById(R.id.edTime);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            int time = Integer.parseInt(edTime.getText().toString());
            Intent i = new Intent(MainActivity.this, StopWatch.class);
            PendingIntent pi = PendingIntent.getBroadcast(getApplicationContext(),0,i,0);
            AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
            am.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+time*1000,pi);


            }
        });
    }
}
