package com.example.retopmdruleta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class FinDePartidaActivity extends AppCompatActivity {

    private Button b;
    private TextView tv;

    private boolean winner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin_de_partida);

        tv = (TextView) findViewById(R.id.textView);
        b = (Button) findViewById(R.id.button);
        b.setText(R.string.instrucciones);

        if (winner)
            tv.setText(R.string.ganado);
        else
            tv.setText(R.string.perdido);


    }


    public void a() {

    }
}