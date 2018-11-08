package com.example.knguyen208.diaglogfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements DeleteData{
    TextView txtMain;
    TextView txtreceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMain = findViewById(R.id.txtMain);
        txtreceiver = findViewById(R.id.txtReceiver);

        txtMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentHopThoai fragmentHopThoai = new FragmentHopThoai();
                fragmentHopThoai.show(getSupportFragmentManager(), "dialog");
            }
        });

    }

    @Override
    public void GiaTriXoa(boolean delete) {
        if (delete){
            txtreceiver.setText("Ban da dong y Xoa");
        }else{
            txtreceiver.setText("Ban da tu choi Xoa");
        }
    }
}
