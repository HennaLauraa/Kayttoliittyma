package com.main.henna.kayttoliittyma;


import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Objects;

/**
 * Created by Henri on 17.2.2016.
 */

public class HomeStatus {
    //replace with dynamic data.
    //ReadJsonFromFile
    //kellari
    double KellaridB;
    boolean KellariLight;
    boolean KellariMusic;
    //Terassi
    double TerassiTemp;
    boolean TerassiLight;
    //Sauna
    boolean SaunaLight;
    double SaunaTemp;
    String Saunahumidity;
    boolean SaunaKiuas;

    JSONObject jsonObjecti = new JSONObject();

    //endHomeStatus

    public void jsonToStringFromAssetFolder(String fileName,Context context) throws IOException, JSONException {
        AssetManager manager = context.getAssets();
        InputStream file = manager.open(fileName);

        byte[] data = new byte[file.available()];
        file.read(data);
        file.close();

        String jsonString = new String(data);

        jsonObjecti = new JSONObject(jsonString);

        //kellari
            this.KellaridB = Double.parseDouble(jsonObjecti.getJSONObject("HouseStatus").getJSONObject("Kellari").get("Volume").toString());
            this.KellariLight = Boolean.valueOf(jsonObjecti.getJSONObject("HouseStatus").getJSONObject("Kellari").get("Light").toString());
            this.KellariMusic = Boolean.valueOf(jsonObjecti.getJSONObject("HouseStatus").getJSONObject("Kellari").get("Music").toString());
        //sauna
            this.SaunaLight = Boolean.valueOf(jsonObjecti.getJSONObject("HouseStatus").getJSONObject("Sauna").get("Light").toString());
            this.SaunaTemp = Double.parseDouble(jsonObjecti.getJSONObject("HouseStatus").getJSONObject("Sauna").get("temp").toString());
            this.Saunahumidity = (String) jsonObjecti.getJSONObject("HouseStatus").getJSONObject("Sauna").get("Humidity");
            this.SaunaKiuas = Boolean.valueOf(jsonObjecti.getJSONObject("HouseStatus").getJSONObject("Sauna").get("Kiuas").toString());
        //terassi
            this.TerassiTemp = Double.parseDouble(jsonObjecti.getJSONObject("HouseStatus").getJSONObject("Terassi").get("temp").toString());
            this.TerassiLight = Boolean.valueOf(jsonObjecti.getJSONObject("HouseStatus").getJSONObject("Terassi").get("Light").toString());
        // tee tosta vitusta jsoni ja aseta datat

        //esimerkki tallennuksesta

    }

    public void SaveData(){
        //JSON esittää palvelimen tilaa, joten muutettaisiin muuttuneet datat palvelimella
        //tehä jsonobjectista stringi
        //avata tiedosto
        //kirjottaa tiedosto uudestaan
        //sulkea tiedosto
        //???
        //voittoa

        Log.d("Tallennus", "funktiota kutsuttiin");
    }



    public boolean GetSaunaLight(){
        return this.SaunaLight;
     }
    public boolean GetSaunaKiuas(){
        return this.SaunaKiuas;
    }
    public double GetSaunaTemp(){
        return this.SaunaTemp;
    }
    public String GetSaunaHumidity(){
        return this.Saunahumidity;
    }
    //kellari getterit
    public double GetKellaridB(){
        return this.KellaridB;
    }
    public boolean GetKellariLight(){
        return this.KellariLight;
    }
    public boolean GetKellariMusic(){
        return this.KellariMusic;
    }
    //terassi
    public double GetTerassiTemp(){
        return this.TerassiTemp;
    }
    public boolean GetTerassiLight(){
        return this.TerassiLight;
    }
}
