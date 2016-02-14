package com.oyeplay.android.userinterface;

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
import android.widget.TextView;

import com.oyeplay.android.R;
import com.oyeplay.android.adapter.ProfessionalsAdapter;
import com.oyeplay.android.adapter.ReviewsAdapter;
import com.oyeplay.android.bean.BeanProfessionals;
import com.oyeplay.android.bean.BeanReviews;

import java.util.ArrayList;

public class ProfessionalsActivity extends AppCompatActivity {

    public ArrayList<BeanProfessionals> beanProfessionals = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professionals);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView textViewHead = (TextView) findViewById(R.id.textViewHead);
        TextView textViewSubHead = (TextView) findViewById(R.id.textViewSUbHead);

        textViewHead.setText("All Games");
        textViewSubHead.setText("256"+" Near you");


        beanProfessionals.add(new BeanProfessionals("Yashwanth", "26 Yrs", "3 Years of exp", "HSR layout Bangalore",
                R.drawable.ic_account, 5, R.drawable.ic_football));
        beanProfessionals.add(new BeanProfessionals("Yashwanth", "26 Yrs", "3 Years of exp", "HSR layout Bangalore",
                R.drawable.ic_account, 5, R.drawable.ic_football));
        beanProfessionals.add(new BeanProfessionals("Yashwanth", "26 Yrs", "3 Years of exp", "HSR layout Bangalore",
                R.drawable.ic_account, 5, R.drawable.ic_football));
        beanProfessionals.add(new BeanProfessionals("Yashwanth", "26 Yrs", "3 Years of exp", "HSR layout Bangalore",
                R.drawable.ic_account, 5, R.drawable.ic_football));
        beanProfessionals.add(new BeanProfessionals("Yashwanth", "26 Yrs", "3 Years of exp", "HSR layout Bangalore",
                R.drawable.ic_account, 5, R.drawable.ic_football));
        beanProfessionals.add(new BeanProfessionals("Yashwanth", "26 Yrs", "3 Years of exp", "HSR layout Bangalore",
                R.drawable.ic_account, 5, R.drawable.ic_football));
        beanProfessionals.add(new BeanProfessionals("Yashwanth", "26 Yrs", "3 Years of exp", "HSR layout Bangalore",
                R.drawable.ic_account, 5, R.drawable.ic_football));
        beanProfessionals.add(new BeanProfessionals("Yashwanth", "26 Yrs", "3 Years of exp", "HSR layout Bangalore",
                R.drawable.ic_account, 5, R.drawable.ic_football));
        beanProfessionals.add(new BeanProfessionals("Yashwanth", "26 Yrs", "3 Years of exp", "HSR layout Bangalore",
                R.drawable.ic_account, 5, R.drawable.ic_football));

        initViews();
        populateRecyclerView();
    }

    private void initViews() {
       recyclerView = (RecyclerView) findViewById(R.id.recyclerView_professionals);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
    }

    // populate the list view by adding data to arraylist
    private void populateRecyclerView() {

        ProfessionalsAdapter adapter = new ProfessionalsAdapter(ProfessionalsActivity.this, beanProfessionals);
//        adapter.setMyClickListener(this);
        beanProfessionals = adapter.arrayList;
        recyclerView.setAdapter(adapter);// set adapter on recyclerview
        adapter.notifyDataSetChanged();// Notify the adapter
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_professionals, menu);
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
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
