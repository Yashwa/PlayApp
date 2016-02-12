package com.oyeplay.android.main;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.oyeplay.android.R;
import com.oyeplay.android.main.fragments.Fragment_Search;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gaurav Badarkhe on 1/19/16.
 */
public class Home extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons_selected = {
            R.drawable.icon_searchwhite,
            R.drawable.icon_offerswhite,
            R.drawable.icon_favouritewhite,
            R.drawable.icon_mybookingwhite
    };
    private int[] tabIcons_unselected = {
            R.drawable.icon_search,
            R.drawable.icon_offer,
            R.drawable.icon_favourite,
            R.drawable.icon_mybooking
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle("OyePlay");

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.setIcon(tabIcons_selected[tab.getPosition()]);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.setIcon(tabIcons_unselected[tab.getPosition()]);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                tab.setIcon(tabIcons_selected[tab.getPosition()]);
            }
        });

    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons_selected[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons_unselected[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons_unselected[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons_unselected[3]);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fragment_Search(), "SEARCH");
        adapter.addFragment(new Fragment(), "OFFERS");
        adapter.addFragment(new Fragment(), "FAVOURITE");
        adapter.addFragment(new Fragment(), "BOOKINGS");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }
    }
}
