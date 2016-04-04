package com.main.henna.kayttoliittyma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class WhatToDoActivity extends AppCompatActivity {
    //Datan voisi hakea kannasta ja alustaa listaan, mutta staattisesti nyt alustettu activityn latauksessa
    public List<String> DataArray =  new ArrayList<String>();
    public boolean isHouse = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_to_do);

        Button userSpinnerbtn = (Button)findViewById(R.id.ControlUsers_btn);
        Button homeSpinnerbtn = (Button) findViewById(R.id.ControlHomes_bt);
        final ListView mainListView = (ListView) findViewById(R.id.mainListView );
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, DataArray);
        mainListView.setAdapter(adapter);
        mainListView.setClickable(true);
        Button AddNew = (Button) findViewById(R.id.AddNew_btn);
        AddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isHouse){
                    Intent myIntent = new Intent(WhatToDoActivity.this, ControlHouseActivity.class);
                    WhatToDoActivity.this.startActivity(myIntent);
                }else{
                    Intent myIntent = new Intent(WhatToDoActivity.this, ControlUserActivity.class);
                    WhatToDoActivity.this.startActivity(myIntent);
                }
            }
        });

        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Object o = mainListView.getItemAtPosition(position);
                //avataan uusi house intentti ja nimeksi se extra jota clickataan, oikeassa ohjelmassa otettaisiin ID ja haettaisiin kannasta loput datat

                if(isHouse){
                    Intent myIntent = new Intent(WhatToDoActivity.this, ControlHouseActivity.class);
                    myIntent.putExtra("TUNNUS",o.toString());
                    WhatToDoActivity.this.startActivity(myIntent);
                }else{
                    Intent myIntent = new Intent(WhatToDoActivity.this, ControlUserActivity.class);
                    myIntent.putExtra("TUNNUS",o.toString());
                    WhatToDoActivity.this.startActivity(myIntent);
                }
            }
        });


        userSpinnerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataArray.clear();
                // Data haettaisiin oikeasti serveriltä , mutta demonstroinnin vuoksi alustetaan staattinen data
                DataArray.add("Herbertti");
                DataArray.add("Aleksanteri");
                DataArray.add("Henna");
                DataArray.add("Nuppu");
                DataArray.add("Luka");
                DataArray.add("Erno");
                adapter.notifyDataSetChanged();
                isHouse = false;
            }
        });

        homeSpinnerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataArray.clear();
                // Data haettaisiin oikeasti serveriltä , mutta demonstroinnin vuoksi alustetaan staattinen data
                DataArray.add("Vuorikatu 3415");
                DataArray.add("Turuntori 3");
                DataArray.add("Yliopistotie 4");
                DataArray.add("Kakkakuja 5");
                DataArray.add("Nikolauksen tie 6");
                adapter.notifyDataSetChanged();
                isHouse = true;
            }
        });

    }
}
