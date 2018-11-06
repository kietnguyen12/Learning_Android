package com.example.kietnguyen.fragmentcommunication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentA extends Fragment {

    TextView txtA;
    EditText edtA;
    Button btnA;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_a, container, false);
        txtA = view.findViewById(R.id.txtA);
        edtA = view.findViewById(R.id.edtA);
        btnA = view.findViewById(R.id.btnA);

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "BtnA is clicked", Toast.LENGTH_SHORT).show();
                TextView txtB = getActivity().findViewById(R.id.txtB);
                txtB.setText("Changed by Fragment A");
            }
        });

        return view;
    }

    public void GanNoiDung(String noidung){
        txtA.setText(noidung);
    }
}
