package com.example.knguyen208.androidwebservice;

import android.Manifest;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listViewSV;
    SinhVienAdapter sinhVienAdapter;
    ArrayList<SinhVien> sinhVienArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listViewSV = findViewById(R.id.listviewSinhVien);
        sinhVienArrayList = new ArrayList<>();
        GetDataSV();
        sinhVienAdapter = new SinhVienAdapter(this, R.layout.dong_sinh_vien, sinhVienArrayList );
        listViewSV.setAdapter(sinhVienAdapter);


    }

    private void GetDataSV() {
        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = "http://20.203.135.161:1122/androidwebservice/getdata.php";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for(int i = 0; i < response.length(); i++){
                                JSONObject sinhvien = response.getJSONObject(i);
//                                Log.d("AAAA", String.valueOf(sinhvien));
                                sinhVienArrayList.add(new SinhVien(sinhvien.getInt("Id"), sinhvien.getString("HoTen"), sinhvien.getInt("NamSinh"), sinhvien.getString("DiaChi")));
                                //Toast.makeText(MainActivity.this, dataSV.get("HoTen").toString(), Toast.LENGTH_LONG).show();
                                Log.d("AAA", sinhvien.getInt("Id") + " " + sinhvien.getString("HoTen") + " " + sinhvien.getInt("NamSinh") + " " + sinhvien.getString("DiaChi"));
                            }
                            Log.d("AAAA", String.valueOf(sinhVienArrayList.size()));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "error", Toast.LENGTH_LONG).show();
                        Log.d("AAAA", error.toString());
                    }
                }
        );

        requestQueue.add(jsonArrayRequest);
    }
}
