package com.yaydev.blackbook;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {

    public static final String FIRST_TIME = "first";
    private final SharedPreferences pref;

    public PrefManager(Context context) {
        pref = context.getSharedPreferences("main", Context.MODE_PRIVATE);
    }

    public void editFirstTimeCheck(boolean is) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(FIRST_TIME, is);
        editor.apply();
    }

    public boolean isFistCheck() {
        return pref.getBoolean(FIRST_TIME, false);
    }
}
