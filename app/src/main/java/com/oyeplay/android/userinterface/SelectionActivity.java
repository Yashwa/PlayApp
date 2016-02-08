package com.oyeplay.android.userinterface;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.oyeplay.android.R;
import com.oyeplay.android.adapter.SelectionAdapter;
import com.oyeplay.android.bean.BeanSelection;

import java.util.ArrayList;

public class SelectionActivity extends AppCompatActivity implements SelectionAdapter.MyClickListener{

    public static final String TAG = SelectionActivity.class.getSimpleName();

    private static RecyclerView recyclerView;

    public static final String[] TITLES = {"Foot ball", "Badminton", "Cricket", "Tennis", "Snooker",
            "Volley ball", "Swimming",
            "Table tennis", "Basket ball", "Hockey"};

    public static final Integer[] IMAGES = {R.drawable.soccer, R.drawable.soccer,
            R.drawable.soccer, R.drawable.soccer, R.drawable.soccer, R.drawable.soccer,
            R.drawable.soccer, R.drawable.soccer, R.drawable.soccer, R.drawable.soccer};

    public static final int[] IDS = {40, 81, 43, 127, 87, 86, 6, 4, 120, 122};

    private ArrayList<BeanSelection> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Select a Sport");

        initViews();
        populateRecyclerView();
    }


    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_selection);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
    }

    // populate the list view by adding data to arraylist
    private void populateRecyclerView() {
        arrayList = new ArrayList<>();
        for (int i = 0; i < TITLES.length; i++) {
            arrayList.add(new BeanSelection(TITLES[i], IMAGES[i], IDS[i]));
        }
        SelectionAdapter adapter = new SelectionAdapter(SelectionActivity.this, arrayList);
        adapter.setMyClickListener(this);
        arrayList = adapter.arrayList;
        recyclerView.setAdapter(adapter);// set adapter on recyclerview
        adapter.notifyDataSetChanged();// Notify the adapter
    }

    @Override
    public void myItemClicked(View view, int position, RelativeLayout relativeLayout) {
        relativeLayout.setVisibility(View.VISIBLE);
        relativeLayout.findViewWithTag(position).setVisibility(View.VISIBLE);

        Intent intent = new Intent(SelectionActivity.this, ClublistActivity.class);
        intent.putExtra("id", IDS[position]);
        intent.putExtra("title", TITLES[position]);
        startActivity(intent);


//        Toast.makeText(SelectionActivity.this, String.valueOf(position),Toast.LENGTH_LONG).show();
    }


    public void startClubList(){
    }
}
