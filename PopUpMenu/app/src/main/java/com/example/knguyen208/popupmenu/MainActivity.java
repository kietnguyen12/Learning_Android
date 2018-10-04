package com.example.knguyen208.popupmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClick = findViewById(R.id.btnClick);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowMenu();
            }
        });
    }

    private void ShowMenu(){
        PopupMenu popupMenu = new PopupMenu(this, btnClick);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        //Assign click listener for this pop-up menu
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menuAdd:
                        btnClick.setText("Menu Add");
                        break;
                    case R.id.menuSetting:
                        btnClick.setText("Menu Setting");
                        break;
                    case R.id.menuContact:
                        btnClick.setText("Menu Contact");
                        break;

                }
                return false;
            }
        });
        popupMenu.show();
    }

}
