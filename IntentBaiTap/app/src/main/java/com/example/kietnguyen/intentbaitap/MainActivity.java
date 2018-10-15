package com.example.kietnguyen.intentbaitap;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<String> arrayName;
    ImageView imgGoc, imgNhan;
    int REQUEST_CODE = 123;
    String original_image_name;

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
        original_image_name = arrayName.get(6);
        // Get id value of drawable component
        int idHinh = getResources().getIdentifier(original_image_name, "drawable", getPackageName());
        Log.d("AAA", String.valueOf(idHinh));
        // set the image based on the idHinh
        imgGoc.setImageResource(idHinh);

        //Set event listener for imgNhan
        imgNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, SecondActivity.class), REQUEST_CODE);
//                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null){
            String returned_data = data.getStringExtra("choosed_chim");
//            Toast.makeText(MainActivity.this, returned_data, Toast.LENGTH_LONG).show();
//            Log.d("AAAA", returned_data);
            int idHinh  = getResources().getIdentifier(returned_data, "drawable", getPackageName());
            imgNhan.setImageResource(idHinh);
            Log.d("AAAA", returned_data);
            Log.d("AAAA", original_image_name);
            if(returned_data.equals(original_image_name)){
                Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                //Auto change the original image after 2s
                new CountDownTimer(2000, 100) {

                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        // Mix the array to turn out the random value
                        Collections.shuffle(arrayName);
                        original_image_name = arrayName.get(6);
                        // Get id value of drawable component
                        int idHinh = getResources().getIdentifier(original_image_name, "drawable", getPackageName());
                        Log.d("AAA", String.valueOf(idHinh));
                        // set the image based on the idHinh
                        imgGoc.setImageResource(idHinh);
                    }
                }.start();
            }else {
                Toast.makeText(MainActivity.this, "Incorrect", Toast.LENGTH_LONG).show();
            }

        }

        if(requestCode == REQUEST_CODE && resultCode == RESULT_CANCELED){
            Toast.makeText(MainActivity.this, "Ban chua chon hinh", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.reload, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menuReload){
            // Mix the array to turn out the random value
            Collections.shuffle(arrayName);
            original_image_name = arrayName.get(6);
            // Get id value of drawable component
            int idHinh = getResources().getIdentifier(original_image_name, "drawable", getPackageName());
            Log.d("AAA", String.valueOf(idHinh));
            // set the image based on the idHinh
            imgGoc.setImageResource(idHinh);
        }
        return super.onOptionsItemSelected(item);
    }
}
