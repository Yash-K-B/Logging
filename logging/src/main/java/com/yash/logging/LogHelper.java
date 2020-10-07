package com.yash.logging;

import android.util.Log;

public class LogHelper {
    private String tag;

    static LogHelper instance;

    public static LogHelper getInstance(String tag) {
        if (instance == null)
            instance = new LogHelper(tag);
        return instance;
    }

    private LogHelper(String tag) {
        this.tag = tag;
    }

    public void d(String tag, String message) {
        Log.d(this.tag, tag + " : " + message);
    }

    public void i(String tag, String message) {
        Log.i(this.tag, tag + " : " + message);
    }

    public void e(String tag, String message) {
        Log.e(this.tag, tag + " : " + message);
    }

    public void v(String tag, String message) {
        Log.v(this.tag, tag + " : " + message);
    }

    public void w(String tag, String message) {
        Log.w(this.tag, tag + " : " + message);
    }


}
