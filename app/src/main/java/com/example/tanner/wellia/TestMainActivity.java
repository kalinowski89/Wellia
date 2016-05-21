package com.example.tanner.wellia;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class TestMainActivity extends AppCompatActivity {
    TextView m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataProcessLayer t = new dataProcessLayer();
        m = (TextView) findViewById(R.id.json_dump);
        Button b = (Button) findViewById(R.id.b);
        Spinner s =(Spinner) findViewById(R.id.spinner);
        if (b != null) {
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        System.out.println("Click");
                        JSONObject obj = new JSONObject((new dataProcessLayer().get_data()));
                        System.out.println();
                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }



}