package pt.esas.bibliadolinuxv2;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class SplashScreenActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            databaseReference = FirebaseDatabase.getInstance().getReference("loggedDevices");
            String id = databaseReference.push().getKey();
            String model = Build.MODEL;
            String aVersion = Build.VERSION.RELEASE;

            int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
            int minutes = Calendar.getInstance().get(Calendar.MINUTE);
            int seconds = Calendar.getInstance().get(Calendar.SECOND);
            String time = hour + ":" + minutes + ":" + seconds;

            Date today = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(today);

            DateFormat df = new SimpleDateFormat("dd/MM/yy");
            String date = df.format(new Date());

            Telemetry telemetry = new Telemetry(id, model, aVersion, time, date);
            databaseReference.child(id).setValue(telemetry);
        } catch (Exception e) {
            e.printStackTrace();
        }

        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
