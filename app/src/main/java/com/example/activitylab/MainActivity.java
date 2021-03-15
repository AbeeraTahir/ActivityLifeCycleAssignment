package com.example.activitylab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String CREATE_KEY = "create";
    private static final String START_KEY = "start";
    private static final String RESUME_KEY = "resume";
    private static final String RESTART_KEY = "restart";

    String tag = "lifecycle";
    TextView onCreate;
    TextView onStart;
    TextView onResume;
    TextView onRestart;
    Button btnA2;

    int mCreate = 0;
    int mRestart = 0;
    int mStart = 0;
    int mResume = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onCreate = findViewById(R.id.tvOnCreate);
        onStart = findViewById(R.id.tvOnStart);
        onResume = findViewById(R.id.tvOnResume);
        onRestart = findViewById(R.id.tvOnRestart);
        btnA2 = findViewById(R.id.btnActivity2);

        btnA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityTwo.class);
                startActivity(intent);
            }
        });

        if (savedInstanceState != null)
        {
            mCreate = savedInstanceState.getInt(CREATE_KEY);
            mRestart = savedInstanceState.getInt(RESTART_KEY);
            mStart = savedInstanceState.getInt(START_KEY);
            mResume = savedInstanceState.getInt(RESUME_KEY);
        }
        mCreate++;
        Log.i(tag,"onCreate started");
        totalCounts();
    }


        @Override
    protected void onStart() {
        super.onStart();
        mStart++;
        Log.i(tag, "onStart started");
        totalCounts();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mResume++;
        Log.i(tag, "onResume started");
        totalCounts();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mRestart++;
        Log.i(tag, "onRestart started");
        totalCounts();
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
        savedInstanceState.putInt(CREATE_KEY, mCreate);
        savedInstanceState.putInt(RESTART_KEY, mRestart);
        savedInstanceState.putInt(START_KEY, mStart);
        savedInstanceState.putInt(RESUME_KEY, mResume);
    }
    public void totalCounts() {

        onCreate.setText("onCreate() calls: " + mCreate);
        onStart.setText("onStart() calls: " + mStart);
        onResume.setText("onResume() calls: " + mResume);
        onRestart.setText("onRestart() calls: " + mRestart);

    }
}