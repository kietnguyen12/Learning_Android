package com.example.knguyen208.fragmentchangeorientation;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<SinhVien> listSinhVien;

    public StudentAdapter(Context context, int layout, List<SinhVien> listSinhVien) {
        this.context = context;
        this.layout = layout;
        this.listSinhVien = listSinhVien;
    }

    @Override
    public int getCount() {
        return listSinhVien.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class ViewHolder{
        TextView txtTenSV;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.txtTenSV = convertView.findViewById(R.id.txtTenSV);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        SinhVien sinhVien = listSinhVien.get(position);
        holder.txtTenSV.setText(sinhVien.getHoTen());

        return convertView;
    }
}
