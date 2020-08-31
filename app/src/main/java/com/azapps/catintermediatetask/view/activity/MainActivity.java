package com.azapps.catintermediatetask.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.azapps.catintermediatetask.R;
import com.azapps.catintermediatetask.adapter.HomeTabsViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HomeTabsViewPagerAdapter pagerAdapter = new HomeTabsViewPagerAdapter(getSupportFragmentManager()
                ,HomeTabsViewPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,this);
        ViewPager viewPager = findViewById(R.id.activity_home_view_pager);
        viewPager.setAdapter(pagerAdapter);
        TabLayout tabLayout = findViewById(R.id.activity_home_tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }
}