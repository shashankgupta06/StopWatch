package com.example.hp.stopwatch;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.sql.DriverManager.println;

public class HomeActivity extends AppCompatActivity {

    public Button btn;
    EditText edTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn = (Button) findViewById(R.id.btn);
        edTime = (EditText) findViewById(R.id.edTime);
        btn.setEnabled(true);


        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(edTime.getText().toString().matches("")){

                    Toast.makeText(HomeActivity.this, "Please select a value",Toast.LENGTH_LONG).show();
                    return;
                }

                btn.setEnabled(false);
                int time = Integer.parseInt(edTime.getText().toString());
                Intent i = new Intent(HomeActivity.this, StopWatch.class);
                PendingIntent pi = PendingIntent.getBroadcast(getApplicationContext(),0,i,0);
                AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
                am.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+time*1000,pi);

            }

        });
    }

}






