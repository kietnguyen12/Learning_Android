package com.example.knguyen208.diaglogfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class FragmentHopThoai extends DialogFragment {

    DeleteData deleteData;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        deleteData = (DeleteData) getActivity();

        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setTitle("Xac Nhan");
        dialog.setMessage("Ban co chac muon xoa?");
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "btnYes is clicked", Toast.LENGTH_LONG).show();
                deleteData.GiaTriXoa(true);
            }
        });

        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "btnNo is clicked", Toast.LENGTH_SHORT).show();
                deleteData.GiaTriXoa(false);
            }
        });

        Dialog hopthoai = dialog.create();

        return hopthoai;
    }

}
