package com.main.henna.kayttoliittyma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginbtn = (Button)findViewById(R.id.Login_btn);
        final EditText tunnus = (EditText) findViewById(R.id.Tunnus);
        final EditText Passwd = (EditText) findViewById(R.id.Passwd);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Tunnus:",tunnus.getText().toString());
                Log.d("Salis:",Passwd.getText().toString());
                // oikeassa ohjelmassa haettaisiin tietokannasta roolitustiedot annetuille tunnuksille ja tarkistettaisiin jos rooli = admin puolelle, ja jos rooli = user niin user puolelle
                if(tunnus.getText().toString().equals("admin") && Passwd.getText().toString().equals("admin")) {
                    // admin puoli
                    Intent myIntent = new Intent(LoginActivity.this, WhatToDoActivity.class);
                    LoginActivity.this.startActivity(myIntent);

                }
                else{
                    // kauttajan näkymä
                    Intent myIntent = new Intent(LoginActivity.this, MainActivity.class);
                    LoginActivity.this.startActivity(myIntent);
                }
            }
        });

    }
}
