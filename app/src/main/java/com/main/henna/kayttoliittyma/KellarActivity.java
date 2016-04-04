package com.main.henna.kayttoliittyma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;

import org.json.JSONException;

import java.io.IOException;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class KellarActivity extends AppCompatActivity {
    final HomeStatus homestatus = new HomeStatus();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kellar);

        try {
            //alusta data
            homestatus.jsonToStringFromAssetFolder("HouseData.json",getApplicationContext());
            //jos tiedostoa ei löydy
        } catch (IOException e) {
            e.printStackTrace();
            //jos JSONia ei löydy
        } catch (JSONException e) {
            e.printStackTrace();
        }


        final TextView VolumeLabel = (TextView) findViewById(R.id.KellarMusicdB);

        final Switch lightswitch = (Switch) findViewById(R.id.KellarLightSwitch);
        final Switch musicswitch = (Switch) findViewById(R.id.KellarMusicSwitch);

        musicswitch.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                homestatus.SaveData();
            }
        });

        VolumeLabel.setText(String.valueOf(homestatus.GetKellaridB()) + " dB");

        if(homestatus.GetKellariLight()){
            lightswitch.setChecked(true);
        }else{
            lightswitch.setChecked(false);
        }
        if (homestatus.GetKellariMusic()) {
            musicswitch.setChecked(true);
        }else{
            musicswitch.setChecked(false);
        }
    }


}
