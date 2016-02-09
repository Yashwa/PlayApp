package com.oyeplay.android.userinterface;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.oyeplay.android.R;
import com.oyeplay.android.adapter.ClubListAdapter;
import com.oyeplay.android.bean.BeanClubDetails;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ArrayList<BeanClubDetails> mClubArrayList = new ArrayList<>();
    BeanClubDetails beanClubDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

//        Bundle bundle = getIntent().getExtras();

        if (getIntent().getSerializableExtra("clubList") != null) {
            mClubArrayList = ((ArrayList<BeanClubDetails>) getIntent().getSerializableExtra("clubList"));
        }

        System.out.println("mClubArrayList = " + mClubArrayList);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        for(int i = 0; i < mClubArrayList.size(); i++) {
            LatLng sydney = new LatLng(mClubArrayList.get(i).getLat(), mClubArrayList.get(i).getLng());
            mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
            beanClubDetails = mClubArrayList.get(i);
            System.out.println(beanClubDetails);
            mMap.setInfoWindowAdapter(new MarkerInfoWindowAdapter());
        }
        LatLng sydney = new LatLng(mClubArrayList.get(1).getLat(), mClubArrayList.get(1).getLng());

        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

    }

    public class MarkerInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {
        public MarkerInfoWindowAdapter() {
        }

        @Override
        public View getInfoWindow(Marker marker) {
            return null;
        }

        @Override
        public View getInfoContents(Marker marker) {
            View view = getLayoutInflater().inflate(R.layout.info_window, null);

            final BeanClubDetails clubDetails = beanClubDetails;

            TextView name = (TextView) view.findViewById(R.id.textView_name);
            name.setText(clubDetails.getName());
            TextView address = (TextView) view.findViewById(R.id.textView_address);
            address.setText(clubDetails.getAddress());

            mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                @Override
                public void onInfoWindowClick(Marker marker) {
                    Intent intent = new Intent(getBaseContext(), DashboardActivity.class);
                    startActivity(intent);
                }
            });
            return view;
        }

    }
}
