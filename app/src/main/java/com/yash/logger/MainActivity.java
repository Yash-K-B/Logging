package com.yash.logger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.yash.logging.LogHelper;
import com.yash.logging.R;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogHelper.d(TAG, "onCreate: ");
    }
}