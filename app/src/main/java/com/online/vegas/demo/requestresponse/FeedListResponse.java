
package com.online.vegas.demo.requestresponse;

import com.online.vegas.demo.model.FeedListData;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by harshil
 */

public class FeedListResponse {

    private String title;
    private ArrayList<FeedListData> rows;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<FeedListData> getRows() {
        return rows;
    }

    public void setRows(ArrayList<FeedListData> rows) {
        this.rows = rows;
    }
}
