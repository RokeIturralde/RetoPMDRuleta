package com.example.retopmdruleta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button botonPropiedades = null;
    ArrayList<String> jugadores = new ArrayList<>();
    private TextView textView = null;
    public static final int secondary_activity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonPropiedades = (Button) findViewById(R.id.button3);
        textView = (TextView) findViewById(R.id.textView3);
        botonPropiedades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Return numero de Jugadores
                Intent intent = new Intent(MainActivity.this, PantallaConfiguracion.class);
                // onActivityResult(1, 1, intent);
                startActivityForResult(intent, secondary_activity);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case (secondary_activity): {
                if (resultCode == PantallaConfiguracion.RESULT_OK) {
                    String returnValue = data.getStringExtra("numeroJugadores");
                    jugadores = data.getStringArrayListExtra("jugadores");
                    textView.setText(returnValue);
                    textView.setText(textView.getText() + " " + jugadores.get(0));
                }
                break;
            }
        }
    }
}