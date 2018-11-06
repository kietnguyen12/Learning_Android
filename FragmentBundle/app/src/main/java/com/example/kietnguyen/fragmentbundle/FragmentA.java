package com.example.kietnguyen.fragmentbundle;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentA extends Fragment{

    TextView txtA;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        Bundle bundle = getArguments();


        txtA = view.findViewById(R.id.txtA);

        if (bundle != null){
            txtA.setText(bundle.getString("hovaten"));
        }else {
            Toast.makeText(getActivity(), "Khong co du lieu", Toast.LENGTH_SHORT).show();
        }

        return view;
    }
}
