package com.online.vegas.demo.custom;

import android.support.annotation.NonNull;


/**
 * Created by  Harshil
 */

public final class Constant {

    /**
     * Base Url
     */

//    public static final String BASE_URL = "https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/facts.json";
    public static final String BASE_URL = "https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/";

    /**
     * API
     **/
    public static final String DEVICE_TYPE = "android";
    public static String LANGUAGE = "en";
    public static CustomDialog custDailog = null;


    public enum API_RESULT {
        SUCCESS, FAIL
    }

    public static final String FEED_LIST_API = "facts.json";

    public static String isSuccess(@NonNull String status) {
        return status = "success";
    }

}

