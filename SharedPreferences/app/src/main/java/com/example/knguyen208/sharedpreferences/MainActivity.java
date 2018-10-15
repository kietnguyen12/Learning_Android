
package com.example.knguyen208.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtUsername;
    EditText txtPassword;
    CheckBox chkbRemember;
    Button btnLogin;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        chkbRemember = findViewById(R.id.chkbRemember);
        btnLogin = findViewById(R.id.btnLogin);
        sharedPreferences = getSharedPreferences("data_login", MODE_PRIVATE);

        txtUsername.setText(sharedPreferences.getString("username", ""));
        txtPassword.setText(sharedPreferences.getString("password", ""));
        chkbRemember.setChecked(sharedPreferences.getBoolean("checkbox", false));

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txtUsername.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();

                if(username.equals("admin") && password.equals("admin")){
                    Toast.makeText(MainActivity.this, "Log in successfully", Toast.LENGTH_LONG).show();
                    if(chkbRemember.isChecked()){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username", username);
                        editor.putString("password", password);
                        editor.putBoolean("checkbox", true);
                        editor.commit();
                    }else {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("username");
                        editor.remove("password");
                        editor.remove("checkbox");
                        editor.commit();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Log in error", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
