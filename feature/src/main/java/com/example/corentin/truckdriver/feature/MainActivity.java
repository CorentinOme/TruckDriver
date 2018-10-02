package com.example.corentin.truckdriver.feature;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.ExecutorService;

public class MainActivity extends AppCompatActivity {


    private ExecutorService pool;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.textView = findViewById(R.id.textView1);
        //this.pool = Executors.newSingleThreadExecutor();
        this.button = findViewById(R.id.button1);

        final MainActivity act = this;

        //button.setOnClickListener(view -> pool.submit(() -> act.timer()));
        button.setOnClickListener(v -> act.timer());
    }


    public void timer() {
        final MainActivity act = this;
        new CountDownTimer(3000, 1000) {

            public void onTick(long millisUntilFinished) {
                act.textView.setText("Temps restant (en secondes) " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                act.textView.setText("Fini !");
                //Notification noti = new Notification.Builder(act.getBaseContext())
                //        .setContentTitle("Pause nécessaire")
                //        .setContentText("Le chauffeur doit prendre une p'tite pause")
                //        .setSmallIcon(R.drawable.notif)
                //        .build();
                //NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                //manager.notify(0, noti);
            }
        }.start();

    }
}
