package com.online.vegas.demo.custom;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.online.vegas.demo.R;


public class NoInternetActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_no_internet);
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}