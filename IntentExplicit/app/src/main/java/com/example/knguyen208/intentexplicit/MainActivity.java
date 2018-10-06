package com.example.knguyen208.intentexplicit;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    Button btnMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMain = findViewById(R.id.btnMain);

        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        Log.d("AAA", "onCreate Main works");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("AAA", "onStart Main works");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("AAA", "onRestart Main works");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("AAA", "onResume Main works");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("AAA", "onPause Main works");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("AAA", "onStop Main works");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("AAA", "onDestroy Main works");
    }
}
