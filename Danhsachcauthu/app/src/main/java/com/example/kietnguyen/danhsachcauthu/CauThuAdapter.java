package com.example.kietnguyen.danhsachcauthu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CauThuAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<CauThu> cauThuArrayList;

    public CauThuAdapter(Context context, int layout, ArrayList<CauThu> cauThuArrayList) {
        this.context = context;
        this.layout = layout;
        this.cauThuArrayList = cauThuArrayList;
    }

    @Override

    public int getCount() {
        return cauThuArrayList.size();
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

        ImageView avatar = (ImageView) view.findViewById(R.id.avatar);
        TextView txtname = (TextView) view.findViewById(R.id.name);
        TextView txtpostion = (TextView) view.findViewById(R.id.position);
        TextView txtyear = (TextView) view.findViewById(R.id.year);
        ImageView country = (ImageView) view.findViewById(R.id.country);

        CauThu cauthu = cauThuArrayList.get(i);

        txtname.setText(cauthu.getName());
        txtpostion.setText(cauthu.getPosition());
        txtyear.setText(String.valueOf(cauthu.getYear()));
        avatar.setImageResource(cauthu.getAvatar());
        country.setImageResource(cauthu.getCountry());

        return view;

    }
}
