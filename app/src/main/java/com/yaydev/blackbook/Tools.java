package com.yaydev.blackbook;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

public class Tools {

    public static void changeToolbarFont(Activity context, Toolbar toolbar, String font) {
        for (int i = 0; i < toolbar.getChildCount(); i++) {
            View view = toolbar.getChildAt(i);
            if (view instanceof TextView) {
                TextView tv = (TextView) view;
                if (tv.getText().equals(toolbar.getTitle())) {
                    applyFont(tv, context, font);
                    break;
                }
            }
        }
    }

    public static void applyFont(TextView tv, Activity context, String font) {
        tv.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/" + font));
    }
}
