package com.example.knguyen208.androidwebservice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SinhVienAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<SinhVien> sinhVienArrayList;

    public SinhVienAdapter(Context context, int layout, ArrayList<SinhVien> sinhVienArrayList) {
        this.context = context;
        this.layout = layout;
        this.sinhVienArrayList = sinhVienArrayList;
    }

    @Override
    public int getCount() {
        return sinhVienArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        TextView txtTenSV;
        TextView txtNamSinhSV;
        TextView txtDiaChiSV;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);

            holder.txtTenSV = convertView.findViewById(R.id.txtTenSV);
            holder.txtNamSinhSV = convertView.findViewById(R.id.txtNSSV);
            holder.txtDiaChiSV = convertView.findViewById(R.id.txtDiaChiSV);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        SinhVien sinhVien = sinhVienArrayList.get(position);

        holder.txtTenSV.setText(sinhVien.getHoten());
        holder.txtNamSinhSV.setText(sinhVien.getNamsinh() + "");
        holder.txtDiaChiSV.setText(sinhVien.getDiachi());


        return convertView;
    }
}
