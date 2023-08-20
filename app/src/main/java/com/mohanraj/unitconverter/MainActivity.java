package com.mohanraj.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner,spinner2;
    EditText inputnum;
    Button buttoncal;
    TextView resulttext;
    String[] input1 = {"Centimeter(cm)","Meter(m)","Gram(g)","Kilogram(kg)","Second(s)","Minute(m)"};
    String[] input2 = {"Centimeter(cm)","Meter(m)","Gram(g)","Kilogram(kg)","Second(s)","Minute(m)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.input_1_spinner);
        inputnum = findViewById(R.id.input_edit_text);
        spinner2 = findViewById(R.id.output_2_spinner);
        resulttext =findViewById(R.id.result_text);
        buttoncal = findViewById(R.id.button_covert);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,input1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,input2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);



        buttoncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(inputnum.getText().toString())){

                    Toast.makeText(MainActivity.this, "Please fill the all fields", Toast.LENGTH_SHORT).show();

                }else{

                    String result = null;
                    Double inputnumber = Double.parseDouble(inputnum.getText().toString());

                    if(spinner.getSelectedItem().toString() == "Centimeter(cm)" && spinner2.getSelectedItem().toString() == "Meter(m)"){

                        result = String.valueOf(inputnumber/100);
                        resulttext.setText(result+" m");


                    } else if (spinner.getSelectedItem().toString() == "Meter(m)" && spinner2.getSelectedItem().toString() == "Centimeter(cm)") {

                        result =String.valueOf(inputnumber*100);
                        resulttext.setText(result+" cm");

                    }else if (spinner.getSelectedItem().toString() == "Gram(g)" && spinner2.getSelectedItem().toString() == "Kilogram(kg)") {

                        result =String.valueOf(inputnumber/1000);
                        resulttext.setText(result+"kg");
                    }else if (spinner.getSelectedItem().toString() == "Kilogram(kg)" && spinner2.getSelectedItem().toString() == "Gram(g)") {

                        result =String.valueOf(inputnumber*1000);
                        resulttext.setText(result+" g");
                    }else if (spinner.getSelectedItem().toString() == "Second(s)" && spinner2.getSelectedItem().toString() == "Minute(m)") {

                        result =String.valueOf(inputnumber/60);
                        resulttext.setText(result+" m");
                    }else if (spinner.getSelectedItem().toString() == "Minute(m)" && spinner2.getSelectedItem().toString() == "Second(s)") {

                        result =String.valueOf(inputnumber*60);
                        resulttext.setText(result+" s");
                    }else{
                        Toast.makeText(MainActivity.this, "Invalid output type", Toast.LENGTH_SHORT).show();
                    }


                }



            }
        });






    }

}