package com.example.kietnguyen.fragmentcommunication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnMain;
    TextView txtMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMain = findViewById(R.id.btnMain);
        txtMain = findViewById(R.id.txtMain);

        final FragmentA fragmentA = (FragmentA) getSupportFragmentManager().findFragmentById(R.id.fragmentA);
        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentA.GanNoiDung("Changed by Main");
            }
        });
    }
}
