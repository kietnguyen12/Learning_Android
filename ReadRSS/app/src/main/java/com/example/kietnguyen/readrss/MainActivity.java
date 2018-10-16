package com.example.kietnguyen.readrss;

import android.content.Intent;
import android.os.AsyncTask;
import android.provider.DocumentsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> arrayTitle;
    ArrayList<String> arrayURL;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listviewRSS);
        arrayTitle = new ArrayList<>();
        arrayURL = new ArrayList<>();

        adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, arrayTitle);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, arrayURL.get(position), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, News.class);
                intent.putExtra("linkTinTuc", arrayURL.get(position));
                startActivity(intent);
            }
        });

        new ReadRSS().execute("https://vnexpress.net/rss/so-hoa.rss");
    }

    private class ReadRSS extends AsyncTask<String, Void, String> {
        StringBuilder stringBuilder = new StringBuilder();

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                URLConnection urlConnection = url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line + "\n");
                }
                bufferedReader.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return stringBuilder.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            XMLDOMParser parser = new XMLDOMParser();
            Document document = parser.getDocument(s);
            NodeList nodeList = document.getElementsByTagName("item");
//            String tieuDe = "";
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                String tieude = parser.getValue(element, "title");
                String url = parser.getValue(element, "link");
//                tieuDe += tieude + "\n";
                arrayTitle.add(tieude);
                arrayURL.add(url);
//            Toast.makeText(MainActivity.this, tieuDe, Toast.LENGTH_SHORT).show();
            }
            adapter.notifyDataSetChanged();
        }
    }
}
