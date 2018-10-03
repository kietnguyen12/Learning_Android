package com.example.kietnguyen.globalapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtPTT;
    EditText txtName;
    EditText txtEmail;
    EditText txtPhone;
    Button btnClick;
    TextView txtThongTin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtName.getText().toString();
                String email = txtEmail.getText().toString();
                String phone = txtPhone.getText().toString();
                String text = name + "\n" + email + "\n" + phone;
                txtThongTin.setText(text);
            }
        });
    }

    private void AnhXa() {
        txtPTT = findViewById(R.id.txtPTT);
        txtName = findViewById(R.id.txtName);
        txtEmail = findViewById(R.id.txtEmail);
        txtPhone = findViewById(R.id.txtPhone);
        btnClick = findViewById(R.id.btnClick);
        txtThongTin = findViewById(R.id.txtThongTin);
    }
}
