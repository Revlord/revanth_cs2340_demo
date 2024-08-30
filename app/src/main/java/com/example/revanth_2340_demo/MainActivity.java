package com.example.revanth_2340_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate method called");
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //fist find button by ID
        Button openButton = findViewById(R.id.myButton);

        //and then we set an onclicklistener to the button
        openButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //gotta create an intent to start secondactivity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                //use bundle ot add the extra data that we need
                intent.putExtra("KEY", "Hello from mainActivity to secondActivity");

                //starting the second activity
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart is called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume is called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause is called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop is called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy is called");
    }

}