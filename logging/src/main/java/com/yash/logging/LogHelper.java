package com.yash.logging;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import androidx.annotation.NonNull;

import com.yash.logging.settings.LogHelperSettings;
import com.yash.logging.utils.ExceptionUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class LogHelper {
    private final String tag;
    private static final String FILE_NAME = "logs.txt";
    File logFile;
    private DataOutputStream logsWriter;
    private static LogHelperSettings logHelperSettings;

    private static LogHelper instance;

    public static void deploy(Context context, String tag) {
        instance = new LogHelper(context, tag);
    }

    public static void flush() {
        instance.save();
    }

    public static String getLogs() {
        return instance.readLogs();
    }


    public static void d(String tag, String message) {
        instance.log("D", tag, message);
        if (logHelperSettings.isConsoleLogging())
            Log.d(instance.tag, tag + " : " + message);
    }

    public static void d(String tag, String message, Object... vars) {
        String finalMessage = String.format(Locale.US, message, vars);
        instance.log("D", tag, finalMessage);
        if (logHelperSettings.isConsoleLogging())
            Log.d(instance.tag, tag + " : " + finalMessage);
    }

    public static void i(String tag, String message) {
        instance.log("I", tag, message);
        if (logHelperSettings.isConsoleLogging())
            Log.i(instance.tag, tag + " : " + message);
    }

    public static void i(String tag, String message, Object... vars) {
        String finalMessage = String.format(Locale.US, message, vars);
        instance.log("I", tag, finalMessage);
        if (logHelperSettings.isConsoleLogging())
            Log.i(instance.tag, tag + " : " + finalMessage);
    }

    public static void e(String tag, String message) {
        instance.log("E", tag, message);
        if (logHelperSettings.isConsoleLogging())
            Log.e(instance.tag, tag + " : " + message);
    }

    public static void e(String tag, String message, Throwable t) {
        instance.log("E", tag, message + "\n" + ExceptionUtil.getStackStrace(t));
        if (logHelperSettings.isConsoleLogging())
            Log.e(instance.tag, tag + " : " + message, t);
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

    private LogHelper(@NonNull Context context, @NonNull String tag) {
        logHelperSettings = new LogHelperSettings();
        this.tag = tag;

        logFile = new File(Environment.getExternalStorageState(context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)).equals(Environment.MEDIA_MOUNTED) ? context.getExternalFilesDir(null) : context.getFilesDir(), FILE_NAME);
        try {
            logsWriter = new DataOutputStream(new FileOutputStream(new File(context.getFilesDir(), FILE_NAME), true));
            logsWriter.writeBytes("TimeStamp: **** " + new Date().toString() + " ****\n");
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
        if (!logHelperSettings.isFileLogging()) return;
        try {
            logsWriter.writeBytes("  " + type + " ->  " + tag + " : " + message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @NonNull
    private String readLogs() {
        StringBuilder builder = new StringBuilder();
        try {
            FileInputStream logsReader = new FileInputStream(logFile);
            byte[] bytes = new byte[16384];
            int count;
            while ((count = logsReader.read(bytes)) != -1) {
                for (int i = 0; i < count; i++) {
                    builder.append((char) bytes[i]);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }


}
