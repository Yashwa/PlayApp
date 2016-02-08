package com.oyeplay.android.userinterface;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import com.oyeplay.android.R;
import com.oyeplay.android.adapter.ClubListAdapter;
import com.oyeplay.android.bean.BeanClubDetails;

import java.util.ArrayList;
import java.util.Map;

public class ClublistActivity extends AppCompatActivity {

    private ArrayList<BeanClubDetails> arrayList = new ArrayList<>();
    ClubListAdapter adapter;
    private RecyclerView recyclerView;
    LinearLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clublist);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int id = 0;
        String title = "";

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            id = bundle.getInt("id");
            title = bundle.getString("title");
        }

        TextView textView_title, textView_totalClubs;

        textView_title = (TextView) findViewById(R.id.title);
        textView_totalClubs = (TextView) findViewById(R.id.totalClubs);
        textView_title.setText(title);
        textView_totalClubs.setText("256" + " Near you");

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

        adapter = new ClubListAdapter(this, arrayList);
//        adapter.setMyClickListener(this);
        arrayList = adapter.arrayList;
        recyclerView.setAdapter(adapter);// set adapter on recyclerview
        adapter.notifyDataSetChanged();// Notify the adapter

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
                return true;

            case R.id.action_map:
                Intent intent1 = new Intent(ClublistActivity.this, MapsActivity.class);
                intent1.putExtra("clubList", arrayList);
                intent1.putExtra("clubListBean", arrayList);
                startActivity(intent1);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
