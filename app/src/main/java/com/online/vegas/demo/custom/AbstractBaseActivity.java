package com.online.vegas.demo.custom;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Build;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.TextView;

import com.online.vegas.demo.R;


/**
 * Created by  Hashil
 */

public abstract class AbstractBaseActivity extends AppCompatActivity {

    private static final String CONNECTIVITY_CHANGE = "android.net.conn.CONNECTIVITY_CHANGE";
    private InternetReceiver internetReceiver;

    /**
     * <!-- Add this line application theme-->
     * <!-- Add this lines to main view and details view->
     ***/
    public void startActivity(View viewStart, String transactionName, Intent intent) {
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, viewStart, transactionName);
        ActivityCompat.startActivity(this, intent, options.toBundle());
    }

    @Override
    protected void onResume() {
        super.onResume();
        /**RegisterInternetReceiver */
        if (internetReceiver == null) {
            internetReceiver = new InternetReceiver();
            registerReceiver(internetReceiver, new IntentFilter(CONNECTIVITY_CHANGE));
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        /**UnregisterInternetReceiver */
        if (internetReceiver != null) {
            unregisterReceiver(internetReceiver);
            internetReceiver = null;
        }
    }


    /**
     * This class responsible to intercept the broadcast of internet connectivity
     */
    public class InternetReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (!Utils.checkConnectivity(context)) {
                if (AbstractBaseActivity.this instanceof NoInternetActivity)
                    return;
                startActivity(new Intent(AbstractBaseActivity.this, NoInternetActivity.class));
            } else if (AbstractBaseActivity.this instanceof NoInternetActivity) {
                finish();
            }
        }
    }

    public void showSnackBar(Context context, String msg) {
        Snackbar snackbar = Snackbar.make(getWindow().getDecorView().getRootView().findViewById(R.id.frmContainer), msg, Snackbar.LENGTH_LONG);
        TextView tv = (TextView) snackbar.getView().findViewById(android.support.design.R.id.snackbar_text);
        tv.setTextColor(ContextCompat.getColor(context, R.color.colorWhite));
        snackbar.getView().setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent));
        snackbar.show();
    }
}
