package com.yash.logger;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.yash.logging.LogHelper;
import com.yash.logging.LogViewerActivity;
import com.yash.logging.R;
import com.yash.logging.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    ActivityMainBinding mainBinding;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        LogHelper.d(TAG, "onCreate: ");
        LogHelper.d(TAG, "onCreate: ");
        LogHelper.d(TAG, "onCreate: ");
        LogHelper.d(TAG, "onCreate: ");
        LogHelper.d(TAG, "onCreate: ");
        LogHelper.d(TAG, "onCreate: ");
        LogHelper.d(TAG, "onCreate: ");
        LogHelper.d(TAG, "onCreate: ");
        LogHelper.d(TAG, "onCreate: ");
        LogHelper.d(TAG, "onCreate: ");
        LogHelper.d(TAG, "onCreate: ");
        context = this;
        mainBinding.showLogs.setOnClickListener(v->{
//            AlertDialog.Builder builder = new AlertDialog.Builder(context);
//            builder.setTitle("App Logs")
//                    .setMessage(LogHelper.getLogs())
//                    .setCancelable(false)
//                    .setPositiveButton("CANCEL",(dialog, which) -> {
//                        dialog.dismiss();
//                    });
//            AlertDialog alertDialog = builder.create();
//            alertDialog.show();
            startActivity(new Intent(this, LogViewerActivity.class));
        });
    }
}