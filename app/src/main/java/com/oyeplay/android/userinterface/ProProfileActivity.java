package com.oyeplay.android.userinterface;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.oyeplay.android.R;
import com.oyeplay.android.adapter.ExpandableAdapter;
import com.oyeplay.android.bean.BeanChild;
import com.oyeplay.android.bean.BeanGroup;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView imageView_dp = (ImageView) findViewById(R.id.roundedImage);

        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        ArrayList<BeanGroup> groupArrayList ;
        ExpandableAdapter menuAdapter;
        groupArrayList = SetStandardGroups();

        menuAdapter = new ExpandableAdapter(this, groupArrayList);
        expandableListView.setAdapter(menuAdapter);

    }

    public ArrayList<BeanGroup> SetStandardGroups() {

        String group_names[] = {"Description", "Achievements", "Number of students trained", "Rate Card",
                "Reviews"};

        String cateogry_names[] = {"SOmething", "SOmething", "SOmething","SOmething", "SOmething", "SOmething"};


        ArrayList<BeanGroup> list = new ArrayList<BeanGroup>();
        ArrayList<BeanChild> ch_list;
        int i = 0;

        for (i = 0; i < group_names.length; i++) {
            BeanGroup gru = new BeanGroup();
            gru.setName((group_names[i]));


            ch_list = new ArrayList<BeanChild>();


            BeanChild ch = new BeanChild();
            ch.setName(cateogry_names[i]);
            ch_list.add(ch);

            gru.setItems(ch_list);
            list.add(gru);
        }

        return list;
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
}
