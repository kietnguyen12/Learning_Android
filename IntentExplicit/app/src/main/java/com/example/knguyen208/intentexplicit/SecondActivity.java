package com.example.knguyen208.intentexplicit;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity {
    Button btnSecond;
    TextView txtSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnSecond = findViewById(R.id.btnSecond);
        txtSecond = findViewById(R.id.txtSecond);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("dulieu");
        txtSecond.append(bundle.getString("string") + "\n");
        txtSecond.append(bundle.getInt("number") + "\n");
        String[] array_city = bundle.getStringArray("array_city");
        txtSecond.append(array_city[2] + "\n");
        HocSinh hocsinh = (HocSinh) bundle.getSerializable("object");
        txtSecond.append(hocsinh.getHoten());


        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Log.d("AAA", "onCreate Second works");    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("AAA", "onStart Second works");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("AAA", "onRestart Second works");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("AAA", "onResume Second works");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("AAA", "onPause Second works");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("AAA", "onStop Second works");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("AAA", "onDestroy Second works");
    }
}
