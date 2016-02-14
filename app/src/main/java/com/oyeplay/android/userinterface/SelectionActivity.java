package com.oyeplay.android.userinterface;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.oyeplay.android.R;
import com.oyeplay.android.adapter.SelectionAdapter;
import com.oyeplay.android.bean.BeanSports;
import com.oyeplay.android.bean.Cities;
import com.oyeplay.android.db.SharedPrefrenceHelper;
import com.oyeplay.android.utility.Api;
import com.oyeplay.android.utility.MajorUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import io.nlopez.smartlocation.SmartLocation;

public class SelectionActivity extends AppCompatActivity implements SelectionAdapter.MyClickListener {

    public static final String TAG = SelectionActivity.class.getSimpleName();
    public ArrayList<BeanSports> allsports = new ArrayList<>();
    private static RecyclerView recyclerView;
    SelectionAdapter adapter;
    Context context = this;
    public static final String[] TITLES = {"Badminton", "Basketball", "Cricket", "Cricket Net", "Football",
            "Golf", "Hockey",
            "Snooker", "Squash", "Swimming", "Table Tennis", "Tennis", "Volleyball"};

    public static final Integer[] IMAGES = {
            R.drawable.soccer,
            R.drawable.soccer,

            R.drawable.soccer,
            R.drawable.soccer,
            R.drawable.soccer,
            R.drawable.soccer,


            R.drawable.soccer,
            R.drawable.soccer,
            R.drawable.soccer,
            R.drawable.soccer,
            R.drawable.soccer,
            R.drawable.soccer,
            R.drawable.soccer,
            R.drawable.soccer};

    public static final int[] IDS = {40, 81, 43, 127, 87, 86, 6, 4, 120, 122, 12, 34, 45};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Select a Sport");



        initiate();
    }


    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_selection);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
    }

    // populate the list view by adding data to arraylist
    private void populateRecyclerView() {

        adapter = new SelectionAdapter(SelectionActivity.this, allsports);
        adapter.setMyClickListener(this);
        allsports = adapter.arrayList;
        recyclerView.setAdapter(adapter);// set adapter on recyclerview
        adapter.notifyDataSetChanged();// Notify the adapter
    }

    @Override
    public void myItemClicked(View view, int position, RelativeLayout relativeLayout) {
        // relativeLayout.setVisibility(View.VISIBLE);
        relativeLayout.findViewWithTag(position).setVisibility(View.VISIBLE);

        checkgps(position);




        Toast.makeText(SelectionActivity.this, String.valueOf(position), Toast.LENGTH_LONG).show();
    }


    public void startClubList() {
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (adapter != null) {
            if (adapter.getItemCount() > 0) {
                adapter.notifyDataSetChanged();
            }
        }

    }

    public void getcities() {
        final Gson gson = new Gson();

        JsonObjectRequest request = new JsonObjectRequest(Api.getcities, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                MajorUtils.logit("response_citites", response.toString());
                Cities city;
                SharedPrefrenceHelper.putSharedPreferencesString(context, Api.getcities, response.toString());
                try {
                    JSONArray cities = response.getJSONArray("data");


                    for (int i = 0; i < cities.length(); i++) {

                        city = gson.fromJson(cities.get(i).toString(), Cities.class);


                        MajorUtils.logit("city_final", city.getCn());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        com.oyeplay.android.Application.getInstance().addToRequestQueue(request);
    }



    public void getsportcount() {
        final Gson gson = new Gson();
        JSONArray sportsarray = new JSONArray(Arrays.asList(TITLES));
        MajorUtils.logit("response_clubcount", sportsarray.toString());
        JsonObjectRequest request = new JsonObjectRequest( String .format(Api.getclubcount,"Bangalore"), null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                MajorUtils.logit("response_clubcount", response.toString());


                try {
                    JSONObject data = response.getJSONObject("data");
                    Iterator keys = data.keys();

                    while (keys.hasNext()) {

                        String sport = (String) keys.next();


                        String count = data.get(sport).toString();


                        allsports.add(new BeanSports(sport, R.drawable.soccer, Integer.parseInt(count)));
                    }
                    populateRecyclerView();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                MajorUtils.logit("response_clubcount", "ERROR");
            }
        });

        com.oyeplay.android.Application.getInstance().addToRequestQueue(request);


    }

    public void checkgps(final int pos){
        if (!SmartLocation.with(context).location().state().locationServicesEnabled()) {
            new MaterialDialog.Builder(this)
                    .title("GPS required")
                    .content("Please enable your gps for better experience\n\nEnable now?")
                    .positiveText("Yes")
                    .negativeText("Not now")
                    .onPositive(new MaterialDialog.SingleButtonCallback() {
                        @Override
                        public void onClick(MaterialDialog dialog, DialogAction which) {

                        }
                    })
                    .onNegative(new MaterialDialog.SingleButtonCallback() {
                        @Override
                        public void onClick(MaterialDialog dialog, DialogAction which) {
                            Intent intent = new Intent(SelectionActivity.this, FilterActivity.class);
                            intent.putExtra("id", allsports.get(pos).getId());
                            intent.putExtra("title", allsports.get(pos).getTitle());
                            startActivity(intent);
                        }
                    })
                    .show();
        } else {
            Intent intent = new Intent(SelectionActivity.this, ClublistActivity.class);
            intent.putExtra("id", allsports.get(pos).getId());
            intent.putExtra("title", allsports.get(pos).getTitle());
            startActivity(intent);
        }
    }
    public void initiate() {
        initViews();
            getcities();
            getsportcount();

    }

}
