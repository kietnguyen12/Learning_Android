package com.example.knguyen208.fragmentlist;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class FragmentDanhSach extends ListFragment {

    String[] arrayCity  = {"Hai Phong", "Bac Lieu", "Ninh Binh", "Ha Noi", "Tay Ninh", "Ben Tre"};
    ArrayAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, arrayCity);
        setListAdapter(adapter);

        return inflater.inflate(R.layout.fragment_danh_sach, container, false);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(getActivity(), arrayCity[position].toString(), Toast.LENGTH_LONG).show();
        super.onListItemClick(l, v, position, id);
    }
}
