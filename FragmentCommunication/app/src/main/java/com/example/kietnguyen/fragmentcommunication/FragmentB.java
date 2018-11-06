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

import org.w3c.dom.Text;

import java.util.zip.Inflater;

public class FragmentB extends Fragment {
    
    TextView txtB;
    EditText edtB;
    Button btnB;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        
        txtB = view.findViewById(R.id.txtB);
        edtB = view.findViewById(R.id.edtB);
        btnB = view.findViewById(R.id.btnB);
        
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "btnB is clicked", Toast.LENGTH_SHORT).show();
                TextView txtMain = getActivity().findViewById(R.id.txtMain);
                txtMain.setText(txtB.getText().toString().trim());
            }
        });
        
        return view;
    }

    public void GanNoiDung(String noidung){
        txtB.setText(noidung);
    }
}
