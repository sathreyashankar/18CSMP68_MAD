package com.example.mystopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    int counter = 0;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);
        textView = findViewById(R.id.myText);
    }

    public void startEvent(View view) {
        handler.postDelayed(myThread, 0);
    }

    public void stopEvent(View view) {
        handler.removeCallbacks(myThread);
    }

    private final Runnable myThread = new Runnable() {
        @Override
        public void run() {
            textView.setText(" " + counter);
            handler.postDelayed(this, 1000);
            counter += 1;
        }
    };
}