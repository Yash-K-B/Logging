package com.yash.logging;

import android.content.Context;
import android.util.Log;

import com.yash.logging.settings.LogHelperSettings;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogHelper {
    private String tag;
    private FileWriter logsWriter;
    private static LogHelperSettings logHelperSettings;

    private static LogHelper instance;

    public static void deploy(Context context, String tag) {
        instance = new LogHelper(context, tag);
    }

    public static void flush() {
        instance.save();
    }


    public static void d(String tag, String message) {
        instance.log("D", tag, message);
        if (logHelperSettings.isConsoleLogging())
            Log.d(instance.tag, tag + " : " + message);
    }

    public static void i(String tag, String message) {
        instance.log("I", tag, message);
        if (logHelperSettings.isConsoleLogging())
            Log.i(instance.tag, tag + " : " + message);
    }

    public static void e(String tag, String message) {
        instance.log("E", tag, message);
        if (logHelperSettings.isConsoleLogging())
            Log.e(instance.tag, tag + " : " + message);
    }

    public static void v(String tag, String message) {
        instance.log("V", tag, message);
        if (logHelperSettings.isConsoleLogging())
            Log.v(instance.tag, tag + " : " + message);
    }

    public static void w(String tag, String message) {
        instance.log("W", tag, message);
        if (logHelperSettings.isConsoleLogging())
            Log.w(instance.tag, tag + " : " + message);
    }

    public static LogHelperSettings getLogHelperSettings() {
        return logHelperSettings;
    }

    public static void setLogHelperSettings(LogHelperSettings logHelperSettings) {
        LogHelper.logHelperSettings = logHelperSettings;
    }

    private LogHelper(Context context, String tag) {
        logHelperSettings = new LogHelperSettings();
        this.tag = tag;
        File logFile = new File(context.getFilesDir(), "logs.txt");
        try {
            logsWriter = new FileWriter(logFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void save() {
        try {
            logsWriter.flush();
            logsWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void log(String type, String tag, String message) {
        if(!logHelperSettings.isFileLogging()) return;
        try {
            logsWriter.write("\t" + type + " -> " + tag + " : " + message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
