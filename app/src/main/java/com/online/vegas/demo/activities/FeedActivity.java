package com.online.vegas.demo.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.online.vegas.demo.R;
import com.online.vegas.demo.adapters.FeedListAdapter;
import com.online.vegas.demo.api.FeedListAPI;
import com.online.vegas.demo.custom.BaseActivity;
import com.online.vegas.demo.custom.Constant;
import com.online.vegas.demo.custom.Utils;
import com.online.vegas.demo.databinding.ActivityFeedBinding;
import com.online.vegas.demo.interfaces.ResponseListener;

import java.util.Collections;


public class FeedActivity extends BaseActivity implements ResponseListener {

    private ActivityFeedBinding binding;
    private FeedListAPI feedListAPI = null;
    private FeedListAdapter adapter = null;
    boolean doubleBackToExitPressedOnce = false;
    private boolean isRefresh = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFeedBinding.inflate(getLayoutInflater(), baseBinding.frmContainer, true);
        init();
    }

    private void init() {
        me = this;
        hideBackArrow();
        callApi(1);
        binding.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // cancel the Visual indication of a refresh
                binding.swipeRefreshLayout.setRefreshing(false);
                isRefresh = true;
                callApi(1);
            }
        });
    }

    private void callApi(int tag) {
        if (!isRefresh)
            Utils.showProgress(me);
        if (tag == 1) {
            if (feedListAPI == null)
                feedListAPI = new FeedListAPI(me, this);
            feedListAPI.execute(Constant.DEVICE_TYPE);
        }
    }

    @Override
    public void onResponse(String tag, Constant.API_RESULT result, Object obj) {
        if (!isRefresh)
            Utils.dismissProgress();
        if (tag == Constant.FEED_LIST_API && result == Constant.API_RESULT.SUCCESS) {
            adapter = new FeedListAdapter(feedListAPI.feedList, me);
            binding.rvFeed.setLayoutManager(new LinearLayoutManager(this));
            binding.rvFeed.setAdapter(adapter);
            setTitle(feedListAPI.title);
        }
        isRefresh = false;
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, getResources().getString(R.string.strBackAgain), Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}
