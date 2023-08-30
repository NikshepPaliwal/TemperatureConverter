package com.niks.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MaterialTextView con_temp;
    MaterialButton button;
    EditText edit_text;
    String converter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_text=findViewById(R.id.edit_text);
        button=findViewById(R.id.button);
        con_temp= findViewById(R.id.con_temp);
        Spinner spinner=findViewById(R.id.class_name);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
             converter= adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, ""+converter, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

// array list for data on spinner
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("select class");
        arrayList.add("C to F");
        arrayList.add("F to C");




        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrayList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String operator = converter.toString();
                if (operator.equals("C to F")) {
                    double cTemp= Double.valueOf(edit_text.getText().toString());
                    double fTemp= (cTemp*9/5)+32;
                    con_temp.setText(String.valueOf(String.format("%.2f",fTemp))+" °F");
                }
               else if (operator.equals("F to C")) {
                    double cTemp= Double.valueOf(edit_text.getText().toString());
                    double fTemp= (cTemp-32)*5/9;
                    con_temp.setText(String.valueOf(String.format("%.2f",fTemp))+" °C");
                }
               else{
                    Toast.makeText(MainActivity.this, "Please select the Operator", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}