package com.example.hp.stopwatch;

import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.CountDownTimer;


public class HomeActivity extends AppCompatActivity {

    private KeyListener listner;
    public Button btn;
    EditText edTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btn = (Button) findViewById(R.id.btn);
        edTime = (EditText) findViewById(R.id.edTime);
        listner = edTime.getKeyListener();
        btn.setEnabled(true);


        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String text = edTime.getText().toString();
                final int time = Integer.parseInt(edTime.getText().toString());

                if (text.equalsIgnoreCase("")) {

                    Toast.makeText(HomeActivity.this, "Please select a value", Toast.LENGTH_LONG).show();
                    return;
                }

                if (!text.equalsIgnoreCase("")) {
                    edTime.setKeyListener(null);
                    btn.setEnabled(false);

                    CountDownTimer countDownTimer = new CountDownTimer((time*1000), 1000) {

                        @Override
                        public void onTick(long millisUntilFinished) {

                            edTime.setText(String.valueOf((int)(millisUntilFinished/1000)));
                        }

                        @Override
                        public void onFinish() {
                            edTime.setText("");
                            edTime.setKeyListener(listner);
                            Toast.makeText(HomeActivity.this,"Alarm...",Toast.LENGTH_LONG).show();
                            Vibrator v = (Vibrator)HomeActivity.this.getSystemService(HomeActivity.this.VIBRATOR_SERVICE);
                            v.vibrate(2000);
                            btn.setEnabled(true);

                        }
                    }.start();

                }
            }

        });


    }

}






