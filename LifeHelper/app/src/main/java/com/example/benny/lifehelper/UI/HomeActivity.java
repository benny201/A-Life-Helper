package com.example.benny.lifehelper.UI;

import android.content.Context;
import android.content.Entity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.benny.lifehelper.Entity.Statics;
import com.example.benny.lifehelper.MainActivity;
import com.example.benny.lifehelper.R;
import com.example.benny.lifehelper.Utils.SetTypeFace;
import com.example.benny.lifehelper.Utils.SharedPreferencesTool;

public class HomeActivity extends AppCompatActivity {


    //ui
    private TextView homeText;

    //delay and initialize view
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case Statics.HANDLER_FIRST_BOOT:
                    if (isFirstTime()) {
                        startActivity(new Intent(HomeActivity.this, GuideActivity.class));
                    } else {
                        startActivity(new Intent(HomeActivity.this, MainActivity.class));
                    }
                    finish();
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }

    //initialize view
    public void initView() {
        //delay 3s
        handler.sendEmptyMessageDelayed(Statics.HANDLER_FIRST_BOOT, 3000);
        //initialize
        homeText = (TextView) findViewById(R.id.home_page_text);

        //set typeface
        SetTypeFace.setFace(this, homeText, "fonts/font2.ttf");
    }

    //
    public boolean isFirstTime() {
        boolean isFirst = SharedPreferencesTool.getBool(this, Statics.FIRST_TIME_INFO, true);
        if (isFirst) {
            //modify to false for not first time booting
            SharedPreferencesTool.putBool(this, Statics.FIRST_TIME_INFO, false);
            return true;
        } else {
            return false;
        }
    }



}
