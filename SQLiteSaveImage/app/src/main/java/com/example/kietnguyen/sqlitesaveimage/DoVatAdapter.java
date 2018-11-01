package com.example.kietnguyen.sqlitesaveimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DoVatAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    ArrayList<DoVat> doVatArrayList;

    public DoVatAdapter(Context context, int layout, ArrayList<DoVat> doVatArrayList) {
        this.context = context;
        this.layout = layout;
        this.doVatArrayList = doVatArrayList;
    }

    @Override
    public int getCount() {
        return doVatArrayList.size();
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
        ImageView imgDoVat;
        TextView txtTenDoVat;
        TextView motaDoVat;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);

            holder.imgDoVat = convertView.findViewById(R.id.imgDoVat);
            holder.txtTenDoVat = convertView.findViewById(R.id.txtTieuDeDoVat);
            holder.motaDoVat = convertView.findViewById(R.id.txtMoTaCV);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        DoVat doVat = doVatArrayList.get(position);

        holder.txtTenDoVat.setText(doVat.getTenDoVat());
        holder.motaDoVat.setText(doVat.getMoTaDoVat());

        //conver from byte[] to bitmap
        byte[] hinhanh = doVat.getHinh();
        Bitmap bitmap = BitmapFactory.decodeByteArray(hinhanh, 0, hinhanh.length);

        holder.imgDoVat.setImageBitmap(bitmap);

        return convertView;
    }
}
