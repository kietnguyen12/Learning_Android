package com.example.kietnguyen.intentdataresult;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnClick;
    TextView txtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClick = findViewById(R.id.btnClick);
        txtContent = findViewById(R.id.txtContent);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, 123);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 123 && resultCode == RESULT_OK &&  data != null){
            String new_name = data.getStringExtra("new_name");
            txtContent.setText(new_name);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
