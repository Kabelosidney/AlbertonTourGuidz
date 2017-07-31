package com.mlab.kabelo.albertontourguid;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    public Button Mall_and_ShopsBtn,HospitalsBtn,ParksBtn,EntertainmentBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // CategoryFragmentPagerAdapter adapter =
        //     new CategoryFragmentPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(new CategoryFragmentPagerAdapter(getSupportFragmentManager(),
                HomeActivity.this));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}
