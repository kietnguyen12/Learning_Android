package com.example.kietnguyen.danhsachcauthu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listviewcauthu;
    ArrayList<CauThu> cauThuArrayList;
    CauThuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();

        adapter = new CauThuAdapter(this, R.layout.layout_cau_thu, cauThuArrayList);
        listviewcauthu.setAdapter(adapter);
    }

    private void AnhXa() {
        listviewcauthu = (ListView) findViewById(R.id.listviewCauThu);
        cauThuArrayList = new ArrayList<>();
//        add data for arraylist
        cauThuArrayList.add(new CauThu("Bale", "RB", 1985, R.drawable.bale, R.drawable.spain));
        cauThuArrayList.add(new CauThu("Nani", "LB", 1987, R.drawable.nani, R.drawable.canada));
        cauThuArrayList.add(new CauThu("Van der sar", "GK", 1990, R.drawable.vandersar, R.drawable.uk));
        cauThuArrayList.add(new CauThu("Gerrald", "TV", 1985, R.drawable.gerrard, R.drawable.japan));
        cauThuArrayList.add(new CauThu("Carrick", "CB", 1985, R.drawable.carrick, R.drawable.canada));
        cauThuArrayList.add(new CauThu("Zidean", "ST", 1980, R.drawable.zidean, R.drawable.canada));
        cauThuArrayList.add(new CauThu("Messi", "TV", 1985, R.drawable.messi, R.drawable.uk));
        cauThuArrayList.add(new CauThu("Ronaldo", "ST", 1985, R.drawable.ronaldo, R.drawable.canada));
        cauThuArrayList.add(new CauThu("Beckham", "TV", 1985, R.drawable.beckham, R.drawable.spain));
        cauThuArrayList.add(new CauThu("Ramos", "RB", 1985, R.drawable.ramos, R.drawable.japan));
        cauThuArrayList.add(new CauThu("Ozil", "TVB", 1985, R.drawable.ozil, R.drawable.spain));
    }
}
