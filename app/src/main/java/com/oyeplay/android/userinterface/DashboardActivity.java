package com.oyeplay.android.userinterface;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.oyeplay.android.Application;
import com.oyeplay.android.R;
import com.oyeplay.android.dashboardfragment.GamesFragment;
import com.oyeplay.android.utility.Api;
import com.oyeplay.android.utility.MajorUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class DashboardActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener {
    SliderLayout sliderShow;
    String gameName, cityName;
    SweetAlertDialog pDialog;
    TabLayout tabLayout;
    String finaljson;
    ViewPager viewPager;

    ArrayList<String> tittles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView textViewHead = (TextView) findViewById(R.id.textViewHead);
        TextView textViewSubHead = (TextView) findViewById(R.id.textViewSUbHead);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            gameName = bundle.getString("name");
            cityName = bundle.getString("city");
            //gameName = "STR Sports club";
//            getSupportActionBar().setTitle(gameName);
//            getSupportActionBar().setSubtitle(cityName);

            textViewHead.setText(gameName);
            textViewSubHead.setText(cityName);
        }

        showprogressD();
        getdails();

        viewPager = (ViewPager) findViewById(R.id.htab_viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabs_dashboard);

        sliderShow = (SliderLayout) findViewById(R.id.slider);


        HashMap<String, String> url_maps = new HashMap<String, String>();
        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Hannibal", R.drawable.img_club_fb);
        file_maps.put("Big Bang Theory", R.drawable.img_club_fb);
        file_maps.put("House of Cards", R.drawable.img_club_fb);
        file_maps.put("Game of Thrones", R.drawable.img_club_fb);

        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
//                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra", name);

            sliderShow.addSlider(textSliderView);
        }
        sliderShow.setPresetTransformer(SliderLayout.Transformer.Default);
        sliderShow.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
//        sliderShow.setCustomAnimation(new DescriptionAnimation());
        sliderShow.setDuration(4000);
//        sliderShow.addOnPageChangeListener(this);
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    public class SectionPagerAdapter extends FragmentPagerAdapter {

        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
//            switch (position) {
//                case 0:
//                    return new GamesFragment();
//                case 1:
//                    return new GamesFragment();
//                case 2:
//                    return new GamesFragment();
//                case 3:
//                    return new GamesFragment();
//                case 4:
//                    return new GamesFragment();
//                case 5:
//                    return new GamesFragment();
//                default:
//                    return null;
//            }

            Bundle bundle = new Bundle();
            bundle.putString("json", finaljson);
            bundle.putString("selection", tittles.get(position));
            GamesFragment sport = new GamesFragment();
            sport.setArguments(bundle);
            return sport;
        }

        @Override
        public int getCount() {
            return tittles.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tittles.get(position);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case R.id.action_share:
                return true;

            case R.id.action_like:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void getdails() {
        MajorUtils.logit("url", Api.getclubdetails + cityName + "/" + MajorUtils.encode(gameName));
        JsonObjectRequest request = new JsonObjectRequest(Api.getclubdetails + cityName + "/" + gameName.replace(" ", "%20"), null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                MajorUtils.logit("response_clubdetails", response.toString());
                if (!response.has("errorCode")) {
                    finaljson = response.toString();
                    setuptabs(response);
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
            pDialog.setCancelable(true);

            pDialog.setContentText("Something went wrong!");
            pDialog.show();
        }


    }

    public void setuptabs(JSONObject response) {


        tabLayout.addTab(tabLayout.newTab().setText(""));

        try {
            JSONObject data = response.getJSONObject("data").getJSONObject("cbg");
            Iterator keys = data.keys();

            while (keys.hasNext()) {

                String sport = (String) keys.next();


                tittles.add(sport);

                tabLayout.addTab(tabLayout.newTab().setText(sport));


            }
            viewPager.setAdapter(new SectionPagerAdapter(getSupportFragmentManager()));
            tabLayout.setupWithViewPager(viewPager);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}


