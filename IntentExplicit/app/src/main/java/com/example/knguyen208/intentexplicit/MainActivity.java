package com.example.knguyen208.intentexplicit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
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
                Bundle bundle = new Bundle();
                //integer
                bundle.putInt("number", 69);
                //string
                bundle.putString("string", "This is my string");
                //array
                String[] city = {"HCM", "HN", "Nha Trang"};
                bundle.putStringArray("array_city", city);
                //object
                HocSinh hs = new HocSinh("Nguyen Tuan Kiet", 1999);
                bundle.putSerializable("object", hs);

                intent.putExtra("dulieu", bundle);

                startActivity(intent);

            }
        });
    }
}
