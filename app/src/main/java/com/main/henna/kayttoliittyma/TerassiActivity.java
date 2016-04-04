package com.main.henna.kayttoliittyma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;

import org.json.JSONException;

import java.io.IOException;

public class TerassiActivity extends AppCompatActivity {
    final HomeStatus homestatus = new HomeStatus();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terassi);

        try {
            //alusta data
            homestatus.jsonToStringFromAssetFolder("HouseData.json",getApplicationContext());
            //jos tiedosto ei löydy
        } catch (IOException e) {
            e.printStackTrace();
            //jos JSONia ei löydy
        } catch (JSONException e) {
            e.printStackTrace();
        }

        final Switch lightswitch = (Switch) findViewById(R.id.LightSwitch);
        final TextView temp = (TextView) findViewById(R.id.Temp);

        temp.setText(String.valueOf(homestatus.GetTerassiTemp()) + " c");

        if(homestatus.GetTerassiLight()){
            lightswitch.setChecked(true);
        }else{
            lightswitch.setChecked(false);
        }

    }
}
