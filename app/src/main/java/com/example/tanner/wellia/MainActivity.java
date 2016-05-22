package com.example.tanner.wellia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Array adapter using type string_array-
        Spinner serviceTypeSpinner = (Spinner) findViewById(R.id.type);
        Button submit = (Button) findViewById(R.id.submit);
        ArrayAdapter<CharSequence> serviceTypeAdapter = ArrayAdapter.createFromResource(
                this, R.array.service_type, android.R.layout.simple_spinner_item);
        serviceTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Apply adapter to spinner
        serviceTypeSpinner.setAdapter(serviceTypeAdapter);


        //Array adapter using distance string_array
        Spinner distanceSpinner = (Spinner) findViewById(R.id.distance);
        ArrayAdapter<CharSequence> distanceAdapter = ArrayAdapter.createFromResource(
                this, R.array.distance, android.R.layout.simple_spinner_item);
        serviceTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Apply adapter to spinner
        distanceSpinner.setAdapter(distanceAdapter);

        final EditText zip = (EditText) findViewById(R.id.zip_code);

        ToggleButton locToggle = (ToggleButton) findViewById(R.id.use_loc);
        if (locToggle != null) {
            locToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        zip.setVisibility(View.VISIBLE);
                    }
                    else {
                        zip.setVisibility(View.INVISIBLE);
                    }
                }
            });
        }

        if (submit != null) {
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    setContentView(R.layout.activity_maps);

                    Class mapsActivityClass = null;
                    try {
                        mapsActivityClass = Class.forName("com.example.tanner.wellia.MapsActivity");
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    Intent myIntent = new Intent(MainActivity.this,mapsActivityClass);
                    startActivity(myIntent);


                }
            });
        }


    }

}
