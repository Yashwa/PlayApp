package com.oyeplay.android.userinterface;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.oyeplay.android.Application;
import com.oyeplay.android.R;
import com.oyeplay.android.adapter.ReviewsAdapter;
import com.oyeplay.android.adapter.SelectionAdapter;
import com.oyeplay.android.bean.BeanClubDetails;
import com.oyeplay.android.bean.BeanReviews;
import com.oyeplay.android.bean.BeanSports;

import java.util.ArrayList;

public class ReviewsActivity extends AppCompatActivity {

    int noofReviews = 0;
    public ArrayList<BeanReviews> beanReviews = new ArrayList<>();
    private static RecyclerView recyclerView;
    ReviewsAdapter adapter;
    Context context = this;
    LinearLayoutManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Reviews(" + noofReviews + ")"); // set noof reviews

        beanReviews.add(new BeanReviews("Yashwanth", R.drawable.ic_account, "5 June",
                "Good rives sdjk sdjhjksdf jlkd hsdjfh jsdfjk skjdfh ", 3));
        beanReviews.add(new BeanReviews("Yashwanth", R.drawable.ic_account, "5 June" ,
                "Good rives sdjk sdjhjksdf jlkd hsdjfh jsdfjk skjdfh ", 2));
        beanReviews.add(new BeanReviews("Yashwanth", R.drawable.ic_account, "5 June" ,
                "Good rives sdjk sdjhjksdf jlkd hsdjfh jsdfjk skjdfh ", 5));
        beanReviews.add(new BeanReviews("Yashwanth", R.drawable.ic_account, "5 June" ,
                "Good rives sdjk sdjhjksdf jlkd hsdjfh jsdfjk skjdfh ", 4));
        beanReviews.add(new BeanReviews("Yashwanth", R.drawable.ic_account, "5 June" ,
                "Good rives sdjk sdjhjksdf jlkd hsdjfh jsdfjk skjdfh ", 5));
        beanReviews.add(new BeanReviews("Yashwanth", R.drawable.ic_account, "5 June" ,
                "Good rives sdjk sdjhjksdf jlkd hsdjfh jsdfjk skjdfh ", 3));

        initViews();
        populateRecyclerView();
    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_reviews);
        manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
    }

    // populate the list view by adding data to arraylist
    private void populateRecyclerView() {

        adapter = new ReviewsAdapter(ReviewsActivity.this, beanReviews);
//        adapter.setMyClickListener(this);
        beanReviews = adapter.arrayList;
        recyclerView.setAdapter(adapter);// set adapter on recyclerview
        adapter.notifyDataSetChanged();// Notify the adapter
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reviews, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case R.id.action_add:
                Intent intent = new Intent(ReviewsActivity.this, WriteReviewActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
