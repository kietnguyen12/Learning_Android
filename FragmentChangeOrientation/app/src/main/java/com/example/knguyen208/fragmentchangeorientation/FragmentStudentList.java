package com.example.knguyen208.fragmentchangeorientation;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FragmentStudentList extends ListFragment {

    ArrayList<SinhVien> sinhVienArrayList;
    StudentAdapter adapter;
    GetDataSVClicked getDataSVClicked;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        getDataSVClicked = (GetDataSVClicked) getActivity();

        sinhVienArrayList = new ArrayList<>();
        addArraySV();
        adapter = new StudentAdapter(getActivity(), R.layout.row_student, sinhVienArrayList);
        setListAdapter(adapter);


        return inflater.inflate(R.layout.fragment_student_list, container, false);
    }

    private void addArraySV() {
        sinhVienArrayList.add(new SinhVien("Nguyen Tuan Kiet", 1997, "Bac Lieu", "roynguyen147@gmail.com"));
        sinhVienArrayList.add(new SinhVien("Nguyen Van A", 1997, "Ca Mau", "roynguyen127@gmail.com"));
        sinhVienArrayList.add(new SinhVien("Nguyen Thi B", 1993, "Bac Kan", "hello@gmail.com"));
        sinhVienArrayList.add(new SinhVien("Nguyen Tuan Tu", 1997, "Bac Lieu", "roynguyen147@gmail.com"));
        sinhVienArrayList.add(new SinhVien("Nguyen Van C", 1997, "Ca Mau", "roynguyen127@gmail.com"));
        sinhVienArrayList.add(new SinhVien("Nguyen Thi D", 1993, "Bac Kan", "hello@gmail.com"));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
//        Toast.makeText(getActivity(), sinhVienArrayList.get(position).getHoTen(), Toast.LENGTH_SHORT).show();
        getDataSVClicked.GetDataSV(sinhVienArrayList.get(position));
    }
}
