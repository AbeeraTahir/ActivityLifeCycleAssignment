package com.example.activitylab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends AppCompatActivity {
    private static final String CREATE_KEY = "create2";
    private static final String START_KEY = "start2";
    private static final String RESUME_KEY = "resume2";
    private static final String RESTART_KEY = "restart2";

    String tag = "lifecycle";
    TextView onCreate;
    TextView onStart;
    TextView onResume;
    TextView onRestart;
    Button btnCA;

    int nCreate = 0;
    int nRestart = 0;
    int nStart = 0;
    int nResume = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        Intent intent = getIntent();

        onCreate = findViewById(R.id.tvOnCreate2);
        onStart = findViewById(R.id.tvOnStart2);
        onResume = findViewById(R.id.tvOnResume2);
        onRestart = findViewById(R.id.tvOnRestart2);
        btnCA = findViewById(R.id.btnCloseActivity);

        btnCA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if (savedInstanceState != null)
        {
            nCreate = savedInstanceState.getInt(CREATE_KEY);
            nRestart = savedInstanceState.getInt(RESTART_KEY);
            nStart = savedInstanceState.getInt(START_KEY);
            nResume = savedInstanceState.getInt(RESUME_KEY);
        }
        nCreate++;
        Log.i(tag,"onCreate started");
        totalCounts2();
    }
    @Override
    protected void onStart() {
        super.onStart();
        nStart++;
        Log.i(tag, "onStart started");
        totalCounts2();
    }

    @Override
    protected void onResume() {
        super.onResume();
        nResume++;
        Log.i(tag, "onResume started");
        totalCounts2();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        nRestart++;
        Log.i(tag, "onRestart started");
        totalCounts2();
    }
    protected void onStop() {
        super.onStop();
        Log.i(tag, "onStop started");
    }
    protected void onPause() {
        super.onPause();
        Log.i(tag, "onPause started");
    }
    protected void onDestroy() {
        super.onDestroy();
        Log.i(tag, "onDestroy started");
    }
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(CREATE_KEY, nCreate);
        savedInstanceState.putInt(RESTART_KEY, nRestart);
        savedInstanceState.putInt(START_KEY, nStart);
        savedInstanceState.putInt(RESUME_KEY, nResume);
    }
    public void totalCounts2() {

        onCreate.setText("onCreate() calls: " + nCreate);
        onStart.setText("onStart() calls: " + nStart);
        onResume.setText("onResume() calls: " + nResume);
        onRestart.setText("onRestart() calls: " + nRestart);

    }
}