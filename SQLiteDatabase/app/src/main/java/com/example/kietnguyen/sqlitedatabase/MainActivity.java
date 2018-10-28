package com.example.kietnguyen.sqlitedatabase;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tao database ghichu
        database = new Database(this, "ghichu.sqlite", null, 1);

        //tao bang CongViec
        database.QueryData("CREATE TABLE IF NOT EXISTS CongViec(Id INTEGER PRIMARY KEY AUTOINCREMENT, TenCV VARCHAR(200))");

        // insert data
//        database.QueryData("INSERT INTO CongViec VALUES(null, 'di hoc')");

        //select data
        Cursor dataCongViec = database.GetData("SELECT * FROM CongViec");
        while(dataCongViec.moveToNext()){
            String ten = dataCongViec.getString(1);
            Toast.makeText(this, ten, Toast.LENGTH_LONG).show();
        }
    }
}
