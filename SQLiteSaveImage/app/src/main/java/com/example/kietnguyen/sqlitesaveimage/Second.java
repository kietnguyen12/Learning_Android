package com.example.kietnguyen.sqlitesaveimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Second extends AppCompatActivity {
    EditText edtTaskName, edtTaskDescription;
    ImageView imgbtnCamera, imgbtnFolder, imgPreview;
    Button btnAddNewTask, btnCancelAddNewTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
}
