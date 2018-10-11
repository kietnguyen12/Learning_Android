package com.example.kietnguyen.intentbaitap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<String> arrayName;
    ImageView imgGoc, imgNhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgGoc = findViewById(R.id.imgGoc);
        imgNhan = findViewById(R.id.imgNhan);

        // get the string-array of list chim in resource
        String[] mang_chim = getResources().getStringArray(R.array.list_name);
        // assign value of mang_chim to arraylist
        // The different of ArrayList and Array:
        // Array: fixed length, cannot edit, just include basic object: int, String...
        // ArrayList: flexible, can edit, just include complexity object
        arrayName = new ArrayList<>(Arrays.asList(mang_chim));
        // Mix the array to turn out the random value
        Collections.shuffle(arrayName);
        // Get id value of drawable component
        int idHinh = getResources().getIdentifier(arrayName.get(6), "drawable", getPackageName());
        Log.d("AAA", String.valueOf(idHinh));
        // set the image based on the idHinh
        imgGoc.setImageResource(idHinh);

        //Set event listener for imgNhan
        imgNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });


    }
}
