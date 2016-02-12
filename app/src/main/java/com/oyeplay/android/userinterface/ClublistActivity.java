package com.oyeplay.android.userinterface;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;
import com.oyeplay.android.Application;
import com.oyeplay.android.R;
import com.oyeplay.android.adapter.ClubListAdapter;
import com.oyeplay.android.bean.BeanClubDetails;
import com.oyeplay.android.bean.BeanGrounds;
import com.oyeplay.android.db.SharedPrefrenceHelper;
import com.oyeplay.android.utility.Api;
import com.oyeplay.android.utility.MajorUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import cn.pedant.SweetAlert.SweetAlertDialog;
import io.nlopez.smartlocation.OnLocationUpdatedListener;
import io.nlopez.smartlocation.SmartLocation;

public class ClublistActivity extends AppCompatActivity {

    private ArrayList<BeanClubDetails> arrayList = new ArrayList<>();
    ClubListAdapter adapter;
    private RecyclerView recyclerView;
    LinearLayoutManager manager;
    Context context = this;
    String title = "";
    int id = 0;
    private Geocoder geocoder;
    SweetAlertDialog pDialog;
    private List<Address> addresses;
    String jsonresponse;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    TextView textView_title, textView_totalClubs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clublist);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            id = bundle.getInt("id");
            title = bundle.getString("title");
            Application.sport = title;
        }


        textView_title = (TextView) findViewById(R.id.title);
        textView_totalClubs = (TextView) findViewById(R.id.totalClubs);
        textView_title.setText(title);
        textView_totalClubs.setText("..." + " Near you");

        arrayList.add(new BeanClubDetails("STR Sports club", "HSR layout | 5.5km", 4, R.drawable.img_club_fb,
                R.drawable.vector_square, 500, 12.151515, 7.323569));
        arrayList.add(new BeanClubDetails("Lions club", "HSR layout | 5km", 5, R.drawable.img_club_fb,
                R.drawable.vector_square, 500, 12.654655, 7.389725));
        arrayList.add(new BeanClubDetails("STR Sports club", "HSR layout | 5.5km", 2, R.drawable.img_club_fb,
                R.drawable.vector_square, 500, 12.654825, 7.777654));
        arrayList.add(new BeanClubDetails("STR Sports club", "HSR layout | 5.5km", 5, R.drawable.img_club_fb,
                R.drawable.vector_square, 500, 12.544654, 7.545669));
        arrayList.add(new BeanClubDetails("STR Sports club", "HSR layout | 5.5km", 1, R.drawable.img_club_fb,
                R.drawable.vector_square, 500, 12.141684, 7.326859));
        arrayList.add(new BeanClubDetails("STR Sports club", "HSR layout | 5.5km", 4, R.drawable.img_club_fb,
                R.drawable.vector_square, 500, 12.654684, 7.392121));
        arrayList.add(new BeanClubDetails("STR Sports club", "HSR layout | 5.5km", 2, R.drawable.img_club_fb,
                R.drawable.vector_square, 500, 12.532156, 7.545465));
        arrayList.add(new BeanClubDetails("Cikra club", "HSR layout | 5.5km", 3, R.drawable.img_club_fb,
                R.drawable.vector_square, 500, 12.468465, 7.444569));

        initViews();

        showprogressD();
        getgrounds();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_userFeed);
        //        recyclerView.setHasFixedSize(true);
        manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_clublist, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case R.id.action_filter:
                Intent intent = new Intent(ClublistActivity.this, FilterActivity.class);
                startActivity(intent);
                finish();
                return true;

            case R.id.action_map:
                Intent intent1 = new Intent(ClublistActivity.this, MapsActivity.class);
                intent1.putExtra("clubList", arrayList);
                intent1.putExtra("clubListBean", arrayList);
                intent1.putExtra("beangrounds", jsonresponse);
                startActivity(intent1);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void getgrounds() {

        final String[] url = {String.format(Api.getgrounds, title, SharedPrefrenceHelper.getSharedPreferencesString(context, "currentcity", "Bangalore"))};
        if (SmartLocation.with(context).location().state().locationServicesEnabled()) {


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

                                    url[0] = String.format(Api.getgrounds2, title, SharedPrefrenceHelper.getSharedPreferencesString(context, "currentcity", "Bangalore"), String.valueOf(location.getLatitude()), String.valueOf(location.getLongitude()));

                                } else {
                                    url[0] = String.format(Api.getgrounds2, title, SharedPrefrenceHelper.getSharedPreferencesString(context, "currentcity", "Bangalore"), String.valueOf(location.getLatitude()), String.valueOf(location.getLongitude()));
                                }
                                MajorUtils.logit("Url_grounds2", url[0]);
                                callapi(url);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    });


        } else {

            callapi(url);
        }



    }

    public void callapi(String[] url){
        final Gson gson = new Gson();
        MajorUtils.logit("url_winer", url[0]);
        JsonObjectRequest request = new JsonObjectRequest(url[0], null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                if (!response.has("errorCode")) {

                    jsonresponse = response.toString();
                    MajorUtils.logit("response_groundsearch", response.toString());

                    BeanGrounds beanGrounds = gson.fromJson(response.toString(), BeanGrounds.class);

                    inflateadapter(beanGrounds);
                    hideprogressD(true);
                } else {

                    try {
                        MajorUtils.logit("error_ground", response.getString("errorMessage"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    hideprogressD(false);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                hideprogressD(false);
            }
        });

        Application.getInstance().addToRequestQueue(request);

    }
    public void inflateadapter(BeanGrounds grounds) {
        List<com.oyeplay.android.bean.R> arrayListg = grounds.getData().getRs();
        adapter = new ClubListAdapter(this, grounds);
//        adapter.setMyClickListener(this);
        arrayListg = adapter.arrayList;
        recyclerView.setAdapter(adapter);// set adapter on recyclerview
        adapter.notifyDataSetChanged();// Notify the adapter


        textView_totalClubs.setText(String.valueOf(grounds.getData().getRs().size()) + " Near you");
    }

    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public void onStop() {
        super.onStop();


    }

    public void showprogressD() {
        pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Loading");
        pDialog.setCancelable(false);
        pDialog.show();
    }

    public void hideprogressD(boolean successs) {


        if (successs) {
            pDialog.dismiss();
        } else {
            pDialog = new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE);

            pDialog.setTitleText("Oops...");
            pDialog.setCancelable(false);
            pDialog.setContentText("Something went wrong!");
            pDialog.show();
        }


    }
}
