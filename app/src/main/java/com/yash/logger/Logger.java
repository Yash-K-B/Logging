package com.yash.logger;

import android.app.Application;

import com.yash.logging.LogHelper;

public class Logger extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LogHelper.deploy(this,"LOGGER");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        LogHelper.flush();
    }

}
