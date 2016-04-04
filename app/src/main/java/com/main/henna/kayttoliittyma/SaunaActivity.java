package com.main.henna.kayttoliittyma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;

import org.json.JSONException;

import java.io.IOException;

public class SaunaActivity extends AppCompatActivity {
    final HomeStatus homestatus = new HomeStatus();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sauna);
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

        final Switch lightswitch = (Switch) findViewById(R.id.saunaLightSwitch);
        final Switch kiussiwtch = (Switch) findViewById(R.id.saunaKiuasSwitch);
        final TextView temp = (TextView) findViewById(R.id.Temp);
        final TextView humidity = (TextView) findViewById(R.id.Huminidty);

        //alustetaan datat vasta activityssä, koska jos data muuttuu palvelimella
        temp.setText(String.valueOf(homestatus.GetSaunaTemp()) + " c");
        humidity.setText(String.valueOf(homestatus.GetSaunaHumidity()));

        if(homestatus.GetSaunaLight()){
            lightswitch.setChecked(true);
        }else{
            lightswitch.setChecked(false);
        }

        if(homestatus.GetSaunaKiuas()){
            kiussiwtch.setChecked(true);
        }else{
            kiussiwtch.setChecked(false);
        }
    }
}
