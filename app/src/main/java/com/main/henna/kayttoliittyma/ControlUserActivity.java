package com.main.henna.kayttoliittyma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ControlUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_user);

        Bundle extras = getIntent().getExtras();
        String tunnus;
        EditText tunnusField = (EditText)findViewById(R.id.TunnusControl);
        if (extras != null) {
            tunnus = extras.getString("TUNNUS");
            //EXTRALLA voitaisiin hakea esim. kannasta haluttu data ja hakea sillä kaikki halutut tiedot
           tunnusField.setText(tunnus);
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
