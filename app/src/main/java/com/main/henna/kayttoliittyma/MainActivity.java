package com.main.henna.kayttoliittyma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity  {
    final HomeStatus homestatus = new HomeStatus();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView SaunaText = (TextView)findViewById(R.id.SaunaText);
        SaunaText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent myIntent = new Intent(MainActivity.this, SaunaActivity.class);
              MainActivity.this.startActivity(myIntent);}
      });

        final TextView Kellari = (TextView)findViewById(R.id.KellariText);
        Kellari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, KellarActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        final TextView Terassi = (TextView)findViewById(R.id.TerassiText);
        Terassi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                      Intent myIntent = new Intent(MainActivity.this, TerassiActivity.class);
                      MainActivity.this.startActivity(myIntent);
                  }
              });

    }
}

