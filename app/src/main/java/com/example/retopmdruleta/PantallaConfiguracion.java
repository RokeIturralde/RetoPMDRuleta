package com.example.retopmdruleta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class PantallaConfiguracion extends AppCompatActivity {


    private RadioButton radioButton2 = null;
    private RadioButton radioButton3 = null;
    private RadioButton radioButton4 = null;
    private RadioButton radioButton5 = null;
    private RadioButton radioButton6 = null;
    private RadioGroup radioGroup = null;
    private CheckBox checkBox = null;
    private Button botonCancelar = null;
    private Button botonJugar = null;
    private ArrayList<String> jugadores = new ArrayList<>();
    private GridLayout gL = null;
    private String numeroJugadores = null;
    private boolean checked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_configuracion2);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton) findViewById(R.id.radioButton4);
        radioButton5 = (RadioButton) findViewById(R.id.radioButton5);
        radioButton6 = (RadioButton) findViewById(R.id.radioButton6);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        botonJugar = (Button) findViewById(R.id.button);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        gL = findViewById(R.id.gridLayout);
        botonJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Return numero de jugadores y nombre de los jugadores
                EditText aux = null;
                for (int i = 0; i < Integer.parseInt(numeroJugadores); i++) {

                    aux = (EditText) gL.getChildAt(i);
                    jugadores.add(aux.getText().toString());
                }
                Intent returnIntent = new Intent(PantallaConfiguracion.this, MainActivity.class);
                returnIntent.putExtra("jugadores", jugadores);
                returnIntent.putExtra("isChecked", checked);
                setResult(Activity.RESULT_OK, returnIntent);
                finish();

            }
        });
        botonCancelar = (Button) findViewById(R.id.button2);
        botonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) findViewById(group.getCheckedRadioButtonId());
                gL.removeAllViews();
                if (rb.isChecked()) {
                    numeroJugadores = rb.getText().toString();
                    crearJugadores();
                }
            }
        });
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checked = true;
                } else {
                    checked = false;
                }
            }
        });
    }

    private void crearJugadores() {
        for (int i = 0; i < Integer.parseInt(numeroJugadores); i++) {
            EditText eT = new EditText(this);
            eT.setId(View.generateViewId());
            eT.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            eT.setWidth(400);
            eT.setHeight(150);
            gL.addView(eT);
        }
    }
}