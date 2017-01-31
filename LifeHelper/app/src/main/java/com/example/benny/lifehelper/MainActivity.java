package com.example.benny.lifehelper;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.benny.lifehelper.Fragment.HelperFragment;
import com.example.benny.lifehelper.Fragment.NewsFragment;
import com.example.benny.lifehelper.Fragment.Personal;
import com.example.benny.lifehelper.Fragment.PictureFragment;
import com.example.benny.lifehelper.UI.SettingActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //views
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FloatingActionButton floatingActionButton;

    //title
    private List<String> titleList;
    //fragment
    private List<Fragment> fragmentList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //delete the boundary
        getSupportActionBar().setElevation(0);

        initData();
        initView();
    }

    //initial data
    private void initData() {
        titleList = new ArrayList<>();
        titleList.add(this.getString(R.string.block1));
        titleList.add(this.getString(R.string.block2));
        titleList.add(this.getString(R.string.block3));
        titleList.add(this.getString(R.string.block4));

        fragmentList = new ArrayList<>();
        fragmentList.add(new HelperFragment());
        fragmentList.add(new NewsFragment());
        fragmentList.add(new PictureFragment());
        fragmentList.add(new Personal());
    }

    //initial view
    private void initView() {
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.Float_Button);

        //default the float button to invisible
        floatingActionButton.setVisibility(View.GONE);

        //listen to floatingButton
        floatingActionButton.setOnClickListener(this);


        viewPager.setOffscreenPageLimit(fragmentList.size());
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titleList.get(position);
            }
        });

        //set listener to viewpager
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    floatingActionButton.setVisibility(View.GONE);
                } else {
                    floatingActionButton.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //bind viewpager
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Float_Button:
                startActivity(new Intent(this, SettingActivity.class));
                break;
            default:
                break;
        }
    }
}
