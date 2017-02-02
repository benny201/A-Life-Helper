package com.example.benny.lifehelper.UI;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.benny.lifehelper.MainActivity;
import com.example.benny.lifehelper.R;

import java.util.ArrayList;
import java.util.List;
import com.example.benny.lifehelper.Adapter.GuideViewAdapter;
import com.example.benny.lifehelper.Utils.LogTool;


public class GuideActivity extends AppCompatActivity implements View.OnClickListener {

    //enter button
    private Button enterButton;
    private Button skipButton;

    //viewpager
    private ViewPager homeViewPager;
    private GuideViewAdapter guildeViewAdapter;

    //view in viewPager
    private View view1;
    private View view2;
    private View view3;
    private ImageView circle1;
    private ImageView circle2;
    private ImageView circle3;

    //view list
    private List<View> viewList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        initView();
    }

    private void initView() {

        //init cirles in viewPager
        circle1 = (ImageView) findViewById(R.id.circle1);
        circle2 = (ImageView) findViewById(R.id.circle2);
        circle3 = (ImageView) findViewById(R.id.circle3);
        setCircleImage(true,false,false);

        //viewPager init
        homeViewPager = (ViewPager) findViewById(R.id.guideView);

        view1 = View.inflate(this, R.layout.guide_page_one, null);
        view2 = View.inflate(this, R.layout.guide_page_two, null);
        view3 = View.inflate(this, R.layout.guide_page_three, null);

        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);

        guildeViewAdapter = new GuideViewAdapter(viewList);
        homeViewPager.setAdapter(guildeViewAdapter);

        //init button
        enterButton = (Button) view3.findViewById(R.id.enterButton);
        skipButton = (Button) findViewById(R.id.skipButton);

        //listen to button
        enterButton.setOnClickListener(this);
        skipButton.setOnClickListener(this);


        //listen to viewPager
        homeViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                LogTool.logE("" + position);
                switch (position) {
                    case 0:
                        setCircleImage(true, false, false);
                        skipButton.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        setCircleImage(false, true, false);
                        skipButton.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        setCircleImage(false, false, true);
                        skipButton.setVisibility(View.INVISIBLE);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void setCircleImage(boolean isShowOne, boolean isShowTwo, boolean isShowThree) {
        //circle1
        if(isShowOne) {
            circle1.setBackgroundResource(R.drawable.point_on);
        } else {
            circle1.setBackgroundResource(R.drawable.point_off);
        }

        //circle2
        if(isShowTwo) {
            circle2.setBackgroundResource(R.drawable.point_on);
        } else {
            circle2.setBackgroundResource(R.drawable.point_off);
        }

        //circle3
        if(isShowThree) {
            circle3.setBackgroundResource(R.drawable.point_on);
        } else {
            circle3.setBackgroundResource(R.drawable.point_off);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.skipButton:

                break;
            case R.id.enterButton:
                startActivity(new Intent(GuideActivity.this, MainActivity.class));
                finish();
                break;
            default:
                break;
        }
    }
}
