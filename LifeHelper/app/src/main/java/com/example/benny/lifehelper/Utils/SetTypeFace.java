package com.example.benny.lifehelper.Utils;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * Created by benny on 17/2/2.
 */
public class SetTypeFace {

    public static void setFace(Context context, TextView textView, String path) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), path);
        textView.setTypeface(typeface);
    }
}
