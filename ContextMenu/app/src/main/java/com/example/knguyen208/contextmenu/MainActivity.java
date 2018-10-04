package com.example.knguyen208.contextmenu;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnChoose;
    ConstraintLayout manHinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChoose = findViewById(R.id.btnChoose);
        manHinh = findViewById(R.id.manhinh);
        //register for context menu know which view it belongs
        registerForContextMenu(btnChoose);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.contextmenu, menu);
        menu.setHeaderTitle("Choose color");
        menu.setHeaderIcon(R.mipmap.ic_launcher_round);
        menu.setHeaderIcon(R.mipmap.ic_launcher);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menuDo:
                Toast.makeText(this, "Ban chon mau do", Toast.LENGTH_LONG).show();
                manHinh.setBackgroundColor(Color.RED);
                break;
            case R.id.menuVang:
                Toast.makeText(this, "Ban chon mau vang", Toast.LENGTH_LONG).show();
                manHinh.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.menuXanh:
                Toast.makeText(this, "Ban chon mau xanh", Toast.LENGTH_LONG).show();
                manHinh.setBackgroundColor(Color.GREEN);
                break;
        }
        return super.onContextItemSelected(item);
    }
}
