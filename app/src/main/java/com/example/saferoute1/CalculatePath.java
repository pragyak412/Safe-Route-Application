package com.example.saferoute1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class CalculatePath extends AppCompatActivity {

    private Spinner spinner, spinner2;
    private Button btnSubmit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_path);

        addListenerOnButton();
        addListenerOnSpinnerItemSelection();
    }



    public void addListenerOnSpinnerItemSelection() {
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new CustomOnItemClickListener());
    }

    // get the selected dropdown list value
    public void addListenerOnButton() {

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(CalculatePath.this,
                        "Finding safest route : " +
                                "\nFrom: "+ String.valueOf(spinner.getSelectedItem()) +
                                "\nTo: "+ String.valueOf(spinner2.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();
                Intent i  =new Intent(CalculatePath.this , ShowPath.class);
                i.putExtra("from" , String.valueOf(spinner.getSelectedItem()));
                i.putExtra("to" , String.valueOf(spinner2.getSelectedItem()));
                startActivity(i);
            }

        });
    }


}
