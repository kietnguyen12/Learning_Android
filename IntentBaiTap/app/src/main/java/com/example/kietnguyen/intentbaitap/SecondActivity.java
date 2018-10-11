package com.example.kietnguyen.intentbaitap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

public class SecondActivity extends AppCompatActivity {
    TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tableLayout = findViewById(R.id.tablelayout);
        int socot = 3;
        int sodong = 3;

        for(int i = 0; i < sodong; i++){
            TableRow tablerow = new TableRow(this);
            for(int j = 0; j < socot; j++){
                ImageView imageview = new ImageView(this);
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(100, 100);
                imageview.setLayoutParams(layoutParams);
                int idHinh = getResources().getIdentifier(MainActivity.arrayName.get(0), "drawable", getPackageName());
                imageview.setImageResource(idHinh);
                tablerow.addView(imageview);
            }
            tableLayout.addView(tablerow);
        }


    }
}
