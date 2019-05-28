package com.online.vegas.demo.custom;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Patterns;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.online.vegas.demo.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Utils {

    public static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();

    public static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .readTimeout(5, TimeUnit.MINUTES)
            .connectTimeout(5, TimeUnit.MINUTES).addInterceptor(loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY))
            .build();

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient)
            .build();


    public static void showToastMessage(Context context, String mgs, boolean isShort) {
        Toast.makeText(context, mgs, isShort ? Toast.LENGTH_SHORT : Toast.LENGTH_LONG).show();
    }

    public static boolean isRegistered(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getBoolean("isRegistered", false);
    }

    public static void setRegistered(Context context, boolean isRegistered) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().putBoolean("isRegistered", isRegistered).apply();
    }

    public static void showLog(String tag, String msg) {
        Log.e(tag, msg);
    }

    public static String getGCMToken(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString("GCMToken", "");
    }

    public static void setGCMToken(String GCMToken) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance());
        prefs.edit().putString("GCMToken", GCMToken).apply();
    }

    public static String getProfile() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance());
        return prefs.getString("profile", "");
    }

    public static void setProfile(String profile) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance());
        prefs.edit().putString("profile", profile).apply();
    }

    public static void setUserId(String userId) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance());
        prefs.edit().putString("userId", userId).apply();
    }

    public static String getUserId() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance());
        return prefs.getString("userId", "");
    }

    public static void setLanguageDirection(Context context, String languageDir) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().putString("languageDirection", languageDir).apply();
    }

    public static String getLanguageDirection(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString("languageDirection", "ltr");
    }

    public static String getFullName() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance());
        return prefs.getString("FullName", "");
    }

    public static void setFullName(String FullName) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance());
        prefs.edit().putString("FullName", FullName).apply();
    }

    public static String getNumber() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance());
        return prefs.getString("Number", "");
    }

    public static void setNumber(String Number) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance());
        prefs.edit().putString("Number", Number).apply();
    }

    public static String getEmail() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance());
        return prefs.getString("Email", "");
    }

    public static void setEmail(String Email) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance());
        prefs.edit().putString("Email", Email).apply();
    }

    public static String getBranchID() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance());
        return prefs.getString("branchID", "");
    }

    public static void setBranchID(String branchID) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance());
        prefs.edit().putString("branchID", branchID).apply();
    }

    public static String getBranchName() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance());
        return prefs.getString("branchName", "");
    }

    public static void setBranchName(String branchName) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance());
        prefs.edit().putString("branchName", branchName).apply();
    }

    public static String getShiftID() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance());
        return prefs.getString("shiftID", "");
    }

    public static void setShiftID(String shiftID) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance());
        prefs.edit().putString("shiftID", shiftID).apply();
    }

    public static String getShiftName() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance());
        return prefs.getString("shiftName", "");
    }

    public static void setShiftName(String shiftName) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance());
        prefs.edit().putString("shiftName", shiftName).apply();
    }

    public static String getSLang() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance());
        return prefs.getString("SLang", "");
    }

    public static void setSLang(String SLang) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance());
        prefs.edit().putString("SLang", SLang).apply();
    }


    public static String getLocale(Context mContext) {
        Locale locale;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            locale = mContext.getResources().getConfiguration().getLocales().get(0);
        } else {
            locale = mContext.getResources().getConfiguration().locale;
        }
        return String.valueOf(locale.getLanguage());
    }

    public static void setMyLocale(Context context, String lang) {
        Locale myLocale = new Locale(lang);
        Locale.setDefault(myLocale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.locale = myLocale;
        context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
    }

    public static boolean checkConnectivity(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = cm.getActiveNetworkInfo();
            if (info == null) {
                return false;
            } else if (info.isConnectedOrConnecting()) {
                return true;
            }
        } catch (Exception e) {
            Log.e("Error ", e.toString());
        }
        return false;
    }// End of checkConnectivity

    /**
     * Hides the soft keyboard
     */
    public static void hideSoftKeyboard(Activity me) {
        if (me.getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) me.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(me.getCurrentFocus().getWindowToken(), 0);
        }
    }

    public final static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }



    public static float convertDpToPixel(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }

    public static void setFonts(TextInputLayout textInputLayout) {
        textInputLayout.setTypeface(Typeface.createFromAsset(MyApplication.getInstance().getAssets(), MyApplication.getInstance().getString(R.string.font_regular)));
    }

    public static void setFonts(Button btn) {
        btn.setTypeface(Typeface.createFromAsset(MyApplication.getInstance().getAssets(), MyApplication.getInstance().getString(R.string.font_regular)));
    }

    public static void setFonts(TextView txtview) {
        txtview.setTypeface(Typeface.createFromAsset(MyApplication.getInstance().getAssets(), MyApplication.getInstance().getString(R.string.font_regular)));
    }

    public static void setFonts(EditText editText) {
        editText.setTypeface(Typeface.createFromAsset(MyApplication.getInstance().getAssets(), MyApplication.getInstance().getString(R.string.font_regular)));
    }

    public static void showProgress(Context context) {
        try {
            if (Constant.custDailog != null && Constant.custDailog.isShowing())
                Constant.custDailog.dismiss();

            if (Constant.custDailog == null)
                Constant.custDailog = new CustomDialog(context);
            Constant.custDailog.setCancelable(false);
            Constant.custDailog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dismissProgress() {
        if (Constant.custDailog != null && Constant.custDailog.isShowing())
            Constant.custDailog.dismiss();
        Constant.custDailog = null;
    }

    public static String dateConvert(String strdate) {
        String newDateStr = "";
        try {
            SimpleDateFormat curFormater = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date dateObj = curFormater.parse(strdate);
            SimpleDateFormat postFormater = new SimpleDateFormat("dd MMMM yyyy, EEE", Locale.ENGLISH);

            newDateStr = postFormater.format(dateObj);
            return newDateStr;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newDateStr;
    }

    public static String dateConvertWeekMonth(String strdate) {
        String newDateStr = "";
        try {
            SimpleDateFormat curFormater = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date dateObj = curFormater.parse(strdate);
            SimpleDateFormat postFormater = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

            newDateStr = postFormater.format(dateObj);
            return newDateStr;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newDateStr;
    }

    public static String convertToEnglish(String value) {
        String newValue = (((((((((((value + "")
                .replaceAll("١", "1")).replaceAll("٢", "2"))
                .replaceAll("٣", "3")).replaceAll("٤", "4"))
                .replaceAll("٥", "5")).replaceAll("٦", "6"))
                .replaceAll("٧", "7")).replaceAll("٨", "8"))
                .replaceAll("٩", "9")).replaceAll("٠", "0"));
        return newValue;
    }

    public static String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return capitalize(model);
        }
        return capitalize(manufacturer) + "-" + model;
    }

    private static String capitalize(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] arr = str.toCharArray();
        boolean capitalizeNext = true;

        StringBuilder phrase = new StringBuilder();
        for (char c : arr) {
            if (capitalizeNext && Character.isLetter(c)) {
                phrase.append(Character.toUpperCase(c));
                capitalizeNext = false;
                continue;
            } else if (Character.isWhitespace(c)) {
                capitalizeNext = true;
            }
            phrase.append(c);
        }

        return phrase.toString();
    }
}