package com.example.knguyen208.fragmentchangeorientation;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements GetDataSVClicked{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void GetDataSV(SinhVien sinhVien) {
        FragmentStudentInfo fragmentStudentInfo = (FragmentStudentInfo) getSupportFragmentManager().findFragmentById(R.id.fragmentSVInfo);
        fragmentStudentInfo.setInfo(sinhVien);
    }
}
