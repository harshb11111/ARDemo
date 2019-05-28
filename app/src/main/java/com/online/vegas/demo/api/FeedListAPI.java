package com.online.vegas.demo.api;

import android.app.Activity;
import android.content.Context;
import android.util.Log;


import com.online.vegas.demo.custom.Constant;
import com.online.vegas.demo.custom.Utils;
import com.online.vegas.demo.interfaces.ResponseListener;
import com.online.vegas.demo.model.FeedListData;
import com.online.vegas.demo.requestresponse.FeedListResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public class FeedListAPI {

    private final static String API = Constant.FEED_LIST_API;
    private ResponseListener responseListener = null;
    private Context context = null;
    private static IRequestData iRequestData = null;
    public ArrayList<FeedListData> feedList = null;
    public String title = "";


    public FeedListAPI(Context _context, ResponseListener _responseListener) {
        this.context = _context;
        responseListener = _responseListener;
        iRequestData = Utils.retrofit.create(IRequestData.class);
    }

    // Request Api Param
    private interface IRequestData {
        @FormUrlEncoded
        @POST(API)
        Call<FeedListResponse> getResponseData(
                @Field("device_type") String deviceType
        );
    }

    public Void execute(String deviceType) {
        try {
            Call<FeedListResponse> call = iRequestData.getResponseData(deviceType);
            call.enqueue(new Callback<FeedListResponse>() {
                @Override
                public void onResponse(Call<FeedListResponse> call, Response<FeedListResponse> response) {
                    String message = "";
                    String status = "";
                    try {
                        title = response.body().getTitle();
                        Log.e("TITLE==>", response.body().getTitle() + "");
                        Log.e("Data Count==>", response.body().getRows().size() + "");
                        if (response.body().getRows().size() > 0) {
                            status = "success";
                        } else {
                            status = "fail";
                        }
                        feedList = new ArrayList<>();
                        feedList.addAll(response.body().getRows());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    doCallBack(status, message);
                }

                @Override
                public void onFailure(Call<FeedListResponse> call, Throwable t) {
                    Log.e("Upload error:", t.getMessage());
                    doCallBack("error", t.getMessage());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     * Send control back to the caller which includes
     * Status: Successful or Failure Message: Its an Object, if required
     */
    private void doCallBack(final String status, final String mesg) {
        ((Activity) context).runOnUiThread(new Runnable() {

            @Override
            public void run() {
                try {
                    if (status.equalsIgnoreCase("success")) {
                        responseListener.onResponse(API, Constant.API_RESULT.SUCCESS, null);
                    } else if (status.equalsIgnoreCase("fail")) {
                        Utils.showToastMessage(context, mesg, false);
                        responseListener.onResponse(API, Constant.API_RESULT.FAIL, null);
                    } else {
                        Utils.showToastMessage(context, mesg, false);
                        responseListener.onResponse(API, Constant.API_RESULT.FAIL, null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    Utils.showLog("API==>", API);
                }
            }
        });
    }
}