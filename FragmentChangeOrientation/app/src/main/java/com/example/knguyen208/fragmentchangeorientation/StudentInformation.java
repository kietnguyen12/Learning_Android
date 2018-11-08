package com.example.knguyen208.fragmentchangeorientation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StudentInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_information);

        Intent intent = getIntent();

        FragmentStudentInfo fragmentStudentInfo = (FragmentStudentInfo) getSupportFragmentManager().findFragmentById(R.id.fragmentThongTinSV);

        SinhVien sinhVien = (SinhVien) intent.getSerializableExtra("thongtinSV");

        fragmentStudentInfo.setInfo(sinhVien);
    }
}
