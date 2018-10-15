package com.example.kietnguyen.intentbaitap;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.Collections;

public class SecondActivity extends Activity {
    TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tableLayout = findViewById(R.id.tablelayout);
        int socot = 3;
        int sodong = 3;
        Collections.shuffle(MainActivity.arrayName);

        for(int i = 1; i <= sodong; i++){
            TableRow tablerow = new TableRow(this);
            for(int j = 1; j <= socot; j++){
                ImageView imageview = new ImageView(this);
                //Convert dp to pixel
                Resources r = getResources();
                int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, r.getDisplayMetrics());

                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(px, px); // params: pixel
                imageview.setLayoutParams(layoutParams);
                final int vitri = socot * (i - 1) + j - 1;
                int idHinh = getResources().getIdentifier(MainActivity.arrayName.get(vitri), "drawable", getPackageName());
                imageview.setImageResource(idHinh);
                tablerow.addView(imageview);

                imageview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Toast.makeText(SecondActivity.this, MainActivity.arrayName.get(vitri), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.putExtra("choosed_chim", MainActivity.arrayName.get(vitri));
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                });
            }
            tableLayout.addView(tablerow);
        }




    }
}
