package com.example.benny.lifehelper.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by benny on 17/2/1.
 */
public class SharedPreferencesTool {


    public static String defaultSP = "configs";

    //put String value
    public static void putString(Context context, String key, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(defaultSP, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    //put Integer value
    public static void putInt(Context context, String key, int value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(defaultSP, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    //put Boolean value
    public static void putBool(Context context, String key, boolean value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(defaultSP, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    //get String value
    public static String getString(Context context, String key, String defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(defaultSP, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, defaultValue);
    }

    //get Integer value
    public static Integer getInt(Context context, String key, int defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(defaultSP, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, defaultValue);
    }

    //get Integer value
    public static Boolean getBool(Context context, String key, boolean defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(defaultSP, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, defaultValue);
    }


    //delete
    public static void delete(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(defaultSP, Context.MODE_PRIVATE);
        sharedPreferences.edit().remove(key).apply();
    }

    //delete ALl
    public static void deleteAll(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(defaultSP, Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();
    }



}
