package com.example.knguyen208.fragmentchangeorientation;

import android.content.Intent;
import android.content.res.Configuration;
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
        // Neu man hinh dang nam doc(ko co fragment chi tiet ben phai) thi phai chuyen intent
        //Cach 1
//        Configuration configuration = getResources().getConfiguration();
//        if(fragmentStudentInfo != null && configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)
        //Cach2:
        if (fragmentStudentInfo != null && fragmentStudentInfo.isInLayout()){
            fragmentStudentInfo.setInfo(sinhVien);
        }else{
            Intent intent = new Intent(MainActivity.this, StudentInformation.class);
            intent.putExtra("thongtinSV", sinhVien);
            startActivity(intent);
        }
    }
}
