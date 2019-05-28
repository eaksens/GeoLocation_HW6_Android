package com.example.geocalculatorapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class unitSettingActivity extends AppCompatActivity {

    //add default selection
    private String disUnit = "Kilometers";
    private String bearUnit = "Degrees";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_setting);

//        //toolbar
//        Toolbar toolbar = findViewById(R.id.settingToolBar);
//        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        //fab.setImageIcon(R.);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent that getting back from the unit selection
                Intent intent = new Intent();
                String[] units = {disUnit, bearUnit};
                intent.putExtra("units", units);
                setResult(MainActivity.UNITS_SELECTION, intent);
                finish();
            }
        });

        //Grab the spinner ID from the res layout define the spinner
        Spinner distanceSpinner = findViewById(R.id.distanceSpinner);
        Spinner bearingSpinner = findViewById(R.id.bearingSpinner);

        //Distance unit selection
        //populate array adapter using array string resource -Converting string resource to java string objects
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource( this, R.array.distanceUnits, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        distanceSpinner.setAdapter(adapter);
        distanceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            //setting selection when user selected option from spinner
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //get selection event from this code
                disUnit = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //bearing Unit selection
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource( this, R.array.bearingUnits, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        bearingSpinner.setAdapter(adapter1);
        bearingSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                bearUnit = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


    }

}
