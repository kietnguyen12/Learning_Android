package com.example.kietnguyen.sqlitesaveimage;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnAddTask;
    ListView listViewDoVat;

    public static Database database;
    DoVatAdapter doVatAdapter;
    ArrayList<DoVat> doVatArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddTask = findViewById(R.id.btnAddTask);
        listViewDoVat = findViewById(R.id.listViewDoVat);
        doVatArrayList = new ArrayList<>();


        database = new Database(this, "Quanly.sqlite", null, 1);

        //create table if not exist
        CreateTableIfNotExist();
        GetAllDoVat();
        doVatAdapter = new DoVatAdapter(this, R.layout.dong_do_vat, doVatArrayList);
        listViewDoVat.setAdapter(doVatAdapter);

        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Second.class);
                startActivity(intent);
            }
        });
    }

    private void CreateTableIfNotExist() {
        String sql = "CREATE TABLE IF NOT EXISTS DoVat(Id INTEGER PRIMARY KEY AUTOINCREMENT, Ten VARCHAR(30), MoTa VARCHAR(30), HinhAnh BLOB)";
        database.QueryData(sql);
    }

    private void GetAllDoVat(){
        //sql
        String sql = "SELECT * FROM DoVat";
        Cursor dataDoVat = database.GetData(sql);
        doVatArrayList.clear();
        while (dataDoVat.moveToNext()){
            String tenDoVat = dataDoVat.getString(1);
            String motaDoVat = dataDoVat.getString(2);
            byte[] hinhDoVat = dataDoVat.getBlob(3);
            Log.d("ListDoVat", tenDoVat + " " + motaDoVat + " " + hinhDoVat.toString());
            doVatArrayList.add(new DoVat(tenDoVat, motaDoVat, hinhDoVat));
        }
    }
}
