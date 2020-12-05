package com.yash.logging;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.yash.logging.databinding.ActivityLogViewerBinding;

public class LogViewerActivity extends AppCompatActivity {
    ActivityLogViewerBinding logViewerBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logViewerBinding = ActivityLogViewerBinding.inflate(getLayoutInflater());
        setContentView(logViewerBinding.getRoot());
        logViewerBinding.logs.setText(LogHelper.getLogs());
    }
}