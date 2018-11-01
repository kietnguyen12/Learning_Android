package com.example.kietnguyen.sqlitesaveimage;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Second extends AppCompatActivity {
    EditText edtTaskName, edtTaskDescription;
    ImageView imgbtnCamera, imgbtnFolder, imgPreview;
    Button btnAddNewTask, btnCancelAddNewTask;
    int REQUEST_CODE_CAMERA = 1122;
    int REQUEST_CODE_OPEN_FOLDER = 1133;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        edtTaskName = findViewById(R.id.edtTenCV);
        edtTaskDescription = findViewById(R.id.edtDescription);
        imgbtnCamera = findViewById(R.id.imgbtnCamera);
        imgbtnFolder = findViewById(R.id.imgbtnFolder);
        imgPreview = findViewById(R.id.imgpreview);
        btnAddNewTask = findViewById(R.id.btnAddNewTask);
        btnCancelAddNewTask = findViewById(R.id.btnCancelAddTask);

        imgbtnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                // declare start intent which will return data back
                startActivityForResult(intent, REQUEST_CODE_CAMERA);
            }
        });

        // Access storage and get image
        imgbtnFolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_OPEN_FOLDER);
            }
        });

        btnAddNewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) imgPreview.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();
                ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                // quality 100 : normal, cang nho cang dep cang ton dung luong
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArray);
                byte[] hinh = byteArray.toByteArray();

                MainActivity.database.INSERT_DOVAT(
                        edtTaskName.getText().toString().trim(),
                        edtTaskDescription.getText().toString().trim(),
                        hinh
                );
                Toast.makeText(Second.this, "Inserted", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Second.this, MainActivity.class));
            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE_CAMERA && resultCode == RESULT_OK && data != null){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imgPreview.setImageBitmap(bitmap);
        }
        if(requestCode == REQUEST_CODE_OPEN_FOLDER && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();
            InputStream inputStream = null;
            try {
                inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imgPreview.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
