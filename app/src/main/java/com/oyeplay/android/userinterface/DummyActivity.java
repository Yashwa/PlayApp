package com.oyeplay.android.userinterface;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.oyeplay.android.R;
import com.oyeplay.android.adapter.AmenitiesAdapter;
import com.oyeplay.android.adapter.OffersAdapter;
import com.oyeplay.android.bean.BeanAmenities;
import com.oyeplay.android.bean.BeanOffers;

import java.util.ArrayList;

public class DummyActivity extends AppCompatActivity {
    public ArrayList<BeanAmenities> amenities = new ArrayList<>();
    public ArrayList<BeanOffers> offers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView_dummy);
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
//
//        amenities.add(new BeanAmenities("Washroom"));
//        amenities.add(new BeanAmenities("Washroom"));
//        amenities.add(new BeanAmenities("Washroom"));
//        amenities.add(new BeanAmenities("Washroom"));
//        amenities.add(new BeanAmenities("Washroom"));
//        amenities.add(new BeanAmenities("Washroom"));
//
//        AmenitiesAdapter adapter = new AmenitiesAdapter(this, amenities);
//        amenities = adapter.arrayList;
//        recyclerView.setAdapter(adapter);// set adapter on recyclerview
//        adapter.notifyDataSetChanged();// Notify the adapter


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView_dummy);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

        offers.add(new BeanOffers("Offer1", "20% off on booking before Tuesday", "12/52/2016 wednesday", "700$",
                "500$", 5));
        offers.add(new BeanOffers("Offer1", "20% off on booking before Tuesday", "12/52/2016 wednesday", "700$",
                "500$",5));
        offers.add(new BeanOffers("Offer1", "20% off on booking before Tuesday", "12/52/2016 wednesday", "700$",
                "500$",5));
        offers.add(new BeanOffers("Offer1", "20% off on booking before Tuesday", "12/52/2016 wednesday", "700$",
                "500$",5));
        offers.add(new BeanOffers("Offer1", "20% off on booking before Tuesday", "12/52/2016 wednesday", "700$",
                "500$",5));
        offers.add(new BeanOffers("Offer1", "20% off on booking before Tuesday", "12/52/2016 wednesday", "700$",
                "500$",5));
        offers.add(new BeanOffers("Offer1", "20% off on booking before Tuesday", "12/52/2016 wednesday", "700$",
                "500$",5));

        OffersAdapter adapter = new OffersAdapter(this, offers);
        offers = adapter.arrayList;
        recyclerView.setAdapter(adapter);// set adapter on recyclerview
        adapter.notifyDataSetChanged();// Notify the adapter





    }

}
