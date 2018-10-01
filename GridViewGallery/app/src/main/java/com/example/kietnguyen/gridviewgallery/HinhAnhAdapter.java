package com.example.kietnguyen.gridviewgallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class HinhAnhAdapter extends BaseAdapter
{
    private Context context;
    private int layout;
    private ArrayList<HinhAnh> listHinhAnh;

    public HinhAnhAdapter(Context context, int layout, ArrayList<HinhAnh> listHinhAnh) {
        this.context = context;
        this.layout = layout;
        this.listHinhAnh = listHinhAnh;
    }

    @Override
    public int getCount() {
        return listHinhAnh.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);

        ImageView image = (ImageView) view.findViewById(R.id.hinh);

        HinhAnh hinhanh = listHinhAnh.get(i);

        image.setImageResource(hinhanh.getHinh());

        return view;
    }


}
