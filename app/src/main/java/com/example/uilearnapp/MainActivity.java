package com.example.uilearnapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextName;
    private TextView textViewWelcome;
    private Button greetButton;
    private CheckBox checkboxPsychologyInterest, checkboxComputerScienceInterest, checkboxLiteratureInterest;
    private RadioGroup rgGender;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        textViewWelcome = findViewById(R.id.textViewWelcome);
        greetButton= findViewById(R.id.greetButton);
        checkboxPsychologyInterest= findViewById(R.id.checkboxPsychologyInterest);
        checkboxComputerScienceInterest= findViewById(R.id.checkboxComputerScienceInterest);
        checkboxLiteratureInterest= findViewById(R.id.checkboxLiteratureInterest);
        rgGender= findViewById(R.id.rgGender);
        progressBar= findViewById(R.id.progressBar);

        greetButton.setOnClickListener(this);
        greetButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, "Long Button Press", Toast.LENGTH_LONG).show();
                return true;
            }
        });

        checkboxComputerScienceInterest.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "Thanks for selecting Computer Science", Toast.LENGTH_SHORT).show();
                }
            }
        });
        checkboxPsychologyInterest.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "Thanks for selecting Psychology", Toast.LENGTH_SHORT).show();
                }
            }
        });
        checkboxLiteratureInterest.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "Thanks for selecting Literature", Toast.LENGTH_SHORT).show();
                }
            }
        });

        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rbFemale:
                        Toast.makeText(MainActivity.this, "Female", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                        break;
                    case R.id.rbMale:
                        Toast.makeText(MainActivity.this, "Male", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rbOther:
                        Toast.makeText(MainActivity.this, "Other", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.greetButton:
                textViewWelcome.setText("WELCOME " + editTextName.getText().toString().toUpperCase() + "!");
                Toast.makeText(this, "Greetings to you!", Toast.LENGTH_SHORT).show();
        }
    }
}