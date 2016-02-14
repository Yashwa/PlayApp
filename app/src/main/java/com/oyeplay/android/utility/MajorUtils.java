package com.oyeplay.android.utility;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by hubbelsoftware on 2/10/16.
 */
public class MajorUtils {

    public static void toastit(String msg, Context context) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT);
    }

    public static void logit(String tag, String msg) {
        Log.d(tag, msg);
    }

    public static void logit(String msg) {
        Log.d("Data Log", msg);
    }

    public static String replace(String pattern, String data, String value) {
        return data.replace(pattern, value);
    }


    public static String encode(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }


    }

    public static String decode(String s) {
        try {
            return URLDecoder.decode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

}
