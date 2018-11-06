package com.example.kietnguyen.fragmentremove;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();

    }

    public void AddA(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameContent, new FragmentA(), "fragA");
        fragmentTransaction.addToBackStack("viewA");
        fragmentTransaction.commit();
    }

    public void AddB(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameContent, new FragmentB(), "fragB");
        fragmentTransaction.addToBackStack("viewB");
        fragmentTransaction.commit();
    }

    public void AddC(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameContent, new FragmentC(), "fragC");
        fragmentTransaction.addToBackStack("viewC");
        fragmentTransaction.commit();
    }

    public void Back(View view) {
        getSupportFragmentManager().popBackStack();
    }

    public void RemoveA(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = (FragmentA) getSupportFragmentManager().findFragmentByTag("fragA");
        if (fragmentA != null){
            fragmentTransaction.remove(fragmentA);
            fragmentTransaction.commit();
        }
    }

    public void RemoveB(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = (FragmentB) getSupportFragmentManager().findFragmentByTag("fragB");
        if (fragmentB != null){
            fragmentTransaction.remove(fragmentB);
            fragmentTransaction.commit();
        }
    }

    public void RemoveC(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentC fragmentC = (FragmentC) getSupportFragmentManager().findFragmentByTag("fragC");
        if (fragmentC != null){
            fragmentTransaction.remove(fragmentC);
            fragmentTransaction.commit();
        }
    }

    public void PopA(View view) {
        getSupportFragmentManager().popBackStack("viewA", 0);
    }

    //set su kien back cho phim back


    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount() > 0){
            getSupportFragmentManager().popBackStack();
        }else{
            super.onBackPressed();
        }
        
    }
}
