package com.oyeplay.android.userinterface;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

import com.oyeplay.android.R;
import com.oyeplay.android.dashboardfragment.GamesFragment;

public class DashboardActivity extends AppCompatActivity {

    String gameName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null) {
            gameName = bundle.getString("name");
            getSupportActionBar().setTitle(gameName);
        }



        ViewPager viewPager = (ViewPager) findViewById(R.id.htab_viewpager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs_dashboard);

        viewPager.setAdapter(new SectionPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

    }

    public class SectionPagerAdapter extends FragmentPagerAdapter {

        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new GamesFragment();
                case 1:
                    return new GamesFragment();
                case 2:
                    return new GamesFragment();
                case 3:
                    return new GamesFragment();
                case 4:
                    return new GamesFragment();
                case 5:
                    return new GamesFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "CRICKET";
                case 1:
                    return "FOOT BALL";
                case 2:
                    return "TENNIS";
                case 3:
                    return "HOCKEY";
                case 4:
                    return "BASKET BALL";
                case 5:
                    return "TABLE TENNIS";
                default:
                    return "MISC";
            }
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
}
