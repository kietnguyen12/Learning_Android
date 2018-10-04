package com.example.knguyen208.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listViewMonHoc;
    ArrayList<String> listMonHoc;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewMonHoc = findViewById(R.id.listviewMonHoc);
        listMonHoc = new ArrayList<>();

        listMonHoc.add("PHP");
        listMonHoc.add("Nodejs");
        listMonHoc.add("HTML");
        listMonHoc.add("CSS");
        listMonHoc.add("JAVA");
        listMonHoc.add("MYSQL");
        listMonHoc.add("NOSQL");
        listMonHoc.add("UNITY");
        listMonHoc.add("COSMOSDB");
        listMonHoc.add("JS");

         adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listMonHoc);

        listViewMonHoc.setAdapter(adapter);

        //set event for listview
        listViewMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                XacNhanXoa(position);
                return false;
            }
        });

    }

    private void XacNhanXoa(final int position) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Thong bao");
        alertDialog.setIcon(R.mipmap.ic_launcher);
        alertDialog.setMessage("Ban co muon xoa mon hoc nay khong");
        alertDialog.setPositiveButton("Co", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listMonHoc.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
        alertDialog.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialog.show();
    }
}
