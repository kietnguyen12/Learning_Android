package com.example.kietnguyen.sqlitedatabase;

import android.app.Dialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Database database;
    ListView listViewCV;

    ArrayList<CongViec> congViecArrayList;

    CongViecAdapter congViecAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tao database ghichu
        database = new Database(this, "ghichu.sqlite", null, 1);
        listViewCV = findViewById(R.id.listviewCV);
        congViecArrayList = new ArrayList<>();
        congViecAdapter = new CongViecAdapter(this, R.layout.dong_cong_viec, congViecArrayList);
        listViewCV.setAdapter(congViecAdapter);

        //tao bang CongViec
        database.QueryData("CREATE TABLE IF NOT EXISTS CongViec(Id INTEGER PRIMARY KEY AUTOINCREMENT, TenCV VARCHAR(200))");

        getDataCV();
    }

    private void getDataCV() {
        //select data
        Cursor dataCongViec = database.GetData("SELECT * FROM CongViec");
        congViecArrayList.clear();
        while(dataCongViec.moveToNext()){
            int idcv = dataCongViec.getInt(0);
            String ten = dataCongViec.getString(1);
            Log.d("AAAA", ten);
            congViecArrayList.add(new CongViec(idcv, ten));
        }
        congViecAdapter.notifyDataSetChanged();
    }

    private void themCV(String tencv){
        // insert data
        database.QueryData("INSERT INTO CongViec VALUES(null, '"+ tencv +"')");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_congviec, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.menuAdd){
            DialogThem();
        }

        return super.onOptionsItemSelected(item);
    }

    private void DialogThem(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_them_cong_viec);

        // Anh Xa cac thanh phan trong Dialog
        final EditText edtTenCV = dialog.findViewById(R.id.edtTenCV);
        Button btnAdd = dialog.findViewById(R.id.btnAdd);
        Button btnCancel = dialog.findViewById(R.id.btnCancel);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTask = edtTenCV.getText().toString();
                if(!newTask.equals("")){
                    themCV(newTask);
                    Toast.makeText(MainActivity.this, "Them thanh cong", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    getDataCV();
                }else{
                    Toast.makeText(MainActivity.this, "Invalid value", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
