package com.example.retopmdruleta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class PantallaConfiguracion extends AppCompatActivity implements  RadioGroup.OnCheckedChangeListener  {


    RadioButton radioButton = null;
    RadioButton radioButton2 = null;
    RadioButton radioButton3 = null;
    RadioButton radioButton4 = null;
    RadioButton radioButton5 = null;
    RadioButton radioButton6 = null;
    RadioGroup radioGroup = null;
    Button botonCancelar = null;
    Button botonJugar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_configuracion2);
        radioButton = (RadioButton) findViewById(R.id.radioButton);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton) findViewById(R.id.radioButton4);
        radioButton5 = (RadioButton) findViewById(R.id.radioButton5);
        radioButton6 = (RadioButton) findViewById(R.id.radioButton6);
        radioGroup = (RadioGroup) findViewById(R.id.radioG);
        radioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

    }
}