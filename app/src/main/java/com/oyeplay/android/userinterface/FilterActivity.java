package com.oyeplay.android.userinterface;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.oyeplay.android.Application;
import com.oyeplay.android.R;
import com.oyeplay.android.bean.Cities;
import com.oyeplay.android.db.SharedPrefrenceHelper;
import com.oyeplay.android.utility.Api;
import com.oyeplay.android.utility.MajorUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import io.nlopez.smartlocation.OnLocationUpdatedListener;
import io.nlopez.smartlocation.SmartLocation;

public class FilterActivity extends AppCompatActivity {

    Spinner spinner_cities;
    Context context = this;
    EditText editText_location;
    private List<Address> addresses;
    private Geocoder geocoder;
    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        spinner_cities = (Spinner) findViewById(R.id.spinner_city);

        editText_location = (EditText) findViewById(R.id.editText_location);

        initiate();
        spinner_cities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SharedPrefrenceHelper.putSharedPreferencesString(context, "currentcity", list.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_filter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case R.id.action_done:

                Intent intent = new Intent(this,ClublistActivity.class);
                intent.putExtra("title", Application.sport);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);

                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    //Methode used to initate all methods for oncreate
    public void initiate() {
        populateCities();
    }

    public void populateCities() {
        final Gson gson = new Gson();
        ArrayAdapter<String> adapter;


        list = new ArrayList<String>();
        Cities city;
        try {
            JSONArray cities = new JSONObject(SharedPrefrenceHelper.getSharedPreferencesString(context, Api.getcities, "")).getJSONArray("data");


            for (int i = 0; i < cities.length(); i++) {

                city = gson.fromJson(cities.get(i).toString(), Cities.class);


                MajorUtils.logit("city_final", city.getCn());
                list.add(city.getCn());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        spinner_cities.setAdapter(adapter);

        if (SmartLocation.with(context).location().state().locationServicesEnabled()) {
            getaddress();
        } else {
            editText_location.setText("Enable Location");
        }

    }

    public void getaddress() {
        SmartLocation.with(context).location()
                .oneFix()
                .start(new OnLocationUpdatedListener() {
                    @Override
                    public void onLocationUpdated(Location location) {

                        geocoder = new Geocoder(context, Locale.ENGLISH);
                        try {
                            addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                            StringBuilder str = new StringBuilder();
                            if (geocoder.isPresent()) {

                                editText_location.setText(addresses.get(0).getAddressLine(0)
                                        + addresses.get(0).getAddressLine(1) + " ");

                            } else {
                                editText_location.setText("not address");
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                });
    }
}
