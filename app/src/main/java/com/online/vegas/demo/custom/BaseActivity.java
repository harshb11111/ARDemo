package com.online.vegas.demo.custom;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.online.vegas.demo.R;
import com.online.vegas.demo.databinding.ActivityBaseBinding;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


/**
 * Created by Harshil
 */

public class BaseActivity extends AbstractBaseActivity {

    public BaseActivity me;
    public ActivityBaseBinding baseBinding;
    public FragmentManager fragmentManager;
    public String url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.setMyLocale(this, Utils.getLanguageDirection(this).equalsIgnoreCase("ltr") ? "en" : "ar");
        baseBinding = DataBindingUtil.setContentView(this, R.layout.activity_base);
        // Set font
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath(getString(R.string.font_regular))
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        init();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    /**
     * Initialization of object members
     */
    private void init() {
        me = this;
        url = "android.resource://" + getPackageName() + "/";
        setToolBar(baseBinding.mToolbar);
        fragmentManager = getSupportFragmentManager();
        // Get a reference to the ViewModel for this screen.

    }

    protected void setToolBar(Toolbar mToolBar) {
        try {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
            getWindow().setWindowAnimations(0);
            setSupportActionBar(mToolBar);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back_arrow);
            baseBinding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hideBackArrow() {
        try {
            getSupportActionBar().setHomeButtonEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back_arrow);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Gson getGsonInstance() {
        return new GsonBuilder().excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC).create();
    }

    protected void setTitle(String title) {
        baseBinding.toolbarTitle.setText(title);
        baseBinding.toolbarTitle.setTextColor(getResources().getColor(R.color.colorWhite));
    }

    public void setFullScreen() {
        try {
            getSupportActionBar().hide();
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        finish();
        Utils.hideSoftKeyboard(me);
        super.onBackPressed();
    }

}