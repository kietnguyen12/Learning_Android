package com.example.kietnguyen.gridviewgallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gvhinh;
    ArrayList<HinhAnh> listHinhAnh;
    HinhAnhAdapter hinhanhadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gvhinh = (GridView) findViewById(R.id.gvHinhAnh);

        listHinhAnh = new ArrayList<>();
        listHinhAnh.add(new HinhAnh("Hinh so 1", R.drawable.ad1));
        listHinhAnh.add(new HinhAnh("Hinh so 2", R.drawable.ad2));
        listHinhAnh.add(new HinhAnh("Hinh so 3", R.drawable.ad4));
        listHinhAnh.add(new HinhAnh("Hinh so 4", R.drawable.ad5));
        listHinhAnh.add(new HinhAnh("Hinh so 5", R.drawable.ad6));
        listHinhAnh.add(new HinhAnh("Hinh so 6", R.drawable.ad7));

        hinhanhadapter = new HinhAnhAdapter(this, R.layout.dong_hinh_anh, listHinhAnh);

        gvhinh.setAdapter(hinhanhadapter);
    }
}
