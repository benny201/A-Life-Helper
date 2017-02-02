package com.example.benny.lifehelper.Utils;


import android.icu.text.IDNA;
import android.util.Log;

/**
 * Created by benny on 17/2/1.
 */
public class LogTool {

    public LogTool() {

    }

    //turn-on-off
    public static boolean onOff = true;
    //TAG
    public static String TAG = "BennyTest";

    //log fucntions
    public static  void logI(String mytest) {
        if (onOff) {
            Log.i(TAG, "LogI: " + mytest);
        }
    }

    public static void logD(String mytest) {
        if (onOff) {
            Log.d(TAG, "logd: " + mytest);
        }
    }

    public  static void logE(String mytest) {
        if (onOff) {
            Log.e(TAG, "logE: " + mytest);
        }
    }

    public static void logW(String mytest) {
        if (onOff) {
            Log.w(TAG, "logW: " + mytest);
        }
    }
}
