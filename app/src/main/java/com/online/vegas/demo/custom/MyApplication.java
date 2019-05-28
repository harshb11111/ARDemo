package com.online.vegas.demo.custom;

import android.app.Application;
import android.content.res.Configuration;


/**
 * Created by Harshil
 */

public class MyApplication extends Application {

    public static final String TAG = MyApplication.class.getSimpleName();
    private static MyApplication mInstance;
    public static boolean isLTR = true;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
        isLTR = Utils.getLanguageDirection(this).equalsIgnoreCase("ltr");
//        Fresco.initialize(this);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Utils.setMyLocale(this, Utils.getLanguageDirection(this).equalsIgnoreCase("ltr") ? "en" : "ar");
    }

    public static synchronized MyApplication getInstance() {
        return mInstance;
    }

}