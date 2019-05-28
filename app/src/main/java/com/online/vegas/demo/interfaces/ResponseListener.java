package com.online.vegas.demo.interfaces;


import com.online.vegas.demo.custom.Constant;

public interface ResponseListener {
    // API Response Listener
    public void onResponse(String tag, Constant.API_RESULT result, Object obj);

}
