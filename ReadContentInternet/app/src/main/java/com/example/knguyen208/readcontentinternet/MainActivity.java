package com.example.knguyen208.readcontentinternet;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("AAAA", "On create work");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         new ReadContentInternet().execute("https://www.google.com/");
    }

    private class ReadContentInternet extends AsyncTask<String, Void, String>{


        @Override
        protected String doInBackground(String... strings) {
            StringBuilder stringBuilder = new StringBuilder();
            try {
                URL url = new URL(strings[0]);
                Log.d("AAAA", "URL: " + url);
                URLConnection urlConnection = url.openConnection();
                Log.d("AAAA", "urlConnection: " + urlConnection);
                InputStream inputStream = urlConnection.getInputStream();
                Log.d("AAAA", "inputStream: " + inputStream);
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                Log.d("AAAA", "inputStreamReader: " + inputStreamReader);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                Log.d("AAAA", "bufferedReader: " + bufferedReader);
                String line = "";
                Log.d("AAAA", "before while");
                while((line = bufferedReader.readLine()) != null){
                    stringBuilder.append(line + "\n");
                }
                bufferedReader.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.d("AAAA", stringBuilder.toString());

            return stringBuilder.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("AAAA", s.toString());
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
        }
    }
}
