package com.example.kietnguyen.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void AddFragment(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = null;
        switch(view.getId()){
            case R.id.btnShowA:
                fragment = new FragmentA();
                break;

            case R.id.btnShowB:
                fragment = new FragmentB();
                break;

        }
        fragmentTransaction.replace(R.id.frameContent, fragment);
        fragmentTransaction.commit();

    }
}