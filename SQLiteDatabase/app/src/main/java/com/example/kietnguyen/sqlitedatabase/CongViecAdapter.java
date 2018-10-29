package com.example.kietnguyen.sqlitedatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class CongViecAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<CongViec> congViecList;

    public CongViecAdapter(Context context, int layout, List<CongViec> congViecList) {
        this.context = context;
        this.layout = layout;
        this.congViecList = congViecList;
    }

    @Override
    public int getCount() {
        return congViecList.size();
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
        TextView txtTenCV;
        ImageView imgDelete, imgEdit;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.txtTenCV = convertView.findViewById(R.id.txtCV);
            holder.imgDelete = convertView.findViewById(R.id.btnDelete);
            holder.imgEdit = convertView.findViewById(R.id.btnEdit);
            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        CongViec congViec = congViecList.get(position);
        holder.txtTenCV.setText(congViec.getTenCV());

        return convertView;
    }
}
