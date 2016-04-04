package com.main.henna.kayttoliittyma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ControlHouseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_house);

        Bundle extras = getIntent().getExtras();
        String tunnus;
        EditText tunnusField = (EditText)findViewById(R.id.HouseName);
        if (extras != null) {
            tunnus = extras.getString("TUNNUS");
            tunnusField.setText(tunnus);
            //EXTRALLA voitaisiin hakea esim. kannasta haluttu data ja hakea sillä kaikki halutut tiedot

        }
        final Button Tallenna = (Button)findViewById(R.id.SaveBtn);

        Tallenna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final Button Poista = (Button)findViewById(R.id.Remove);

        Poista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
