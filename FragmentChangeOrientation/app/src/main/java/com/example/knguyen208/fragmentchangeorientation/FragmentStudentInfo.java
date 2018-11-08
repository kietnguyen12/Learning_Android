package com.example.knguyen208.fragmentchangeorientation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FragmentStudentInfo extends Fragment {

    TextView txtHoTen;
    TextView txtNamSinh;
    TextView txtDiaChi;
    TextView txtEmail;
    View view;

    GetDataSVClicked getDataSVClicked;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_student_info, container, false);

        txtHoTen = view.findViewById(R.id.txtHoTenSV);
        txtDiaChi = view.findViewById(R.id.txtDiaChiSV);
        txtNamSinh = view.findViewById(R.id.txtNamSinhSV);
        txtEmail = view.findViewById(R.id.txtEmailSV);



        return view;
    }

    public void setInfo(SinhVien sv){
        txtHoTen.setText(sv.getHoTen());
        txtNamSinh.setText("Nam sinh: " + sv.getNamSinh());
        txtDiaChi.setText("Dia chi: " + sv.getDiaChi());
        txtEmail.setText("Email: " + sv.getEmail());
    }
}
