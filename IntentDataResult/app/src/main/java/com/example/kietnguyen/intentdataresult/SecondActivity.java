package com.example.kietnguyen.intentdataresult;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView txtEdit;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtEdit = findViewById(R.id.txtEdit);
        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String new_content = txtEdit.getText().toString();
                intent.putExtra("new_name", new_content);
                setResult(RESULT_OK, intent);

                // close the current activity
                finish();
            }
        });

    }


}
