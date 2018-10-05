package com.example.knguyen208.calendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TextView txtTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTime = findViewById(R.id.txtTime);
        // Follow device time value
        Calendar calendar = Calendar.getInstance();
        txtTime.append("Current Time: " + calendar.getTime() + "\n");
//        txtTime.append("Current Minute: " + calendar.MINUTE + "\n");
//        txtTime.append("Current Second: " + calendar.SECOND + "\n");

        // Simple way to format the time value
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        txtTime.append("SimpleDateFormat : " + dateFormat.format(calendar.getTime()) + "\n ");

        //format time
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
        txtTime.append(timeFormat.format(calendar.getTime()));


        //More doc about simpledateformat => go to gg
    }
}
