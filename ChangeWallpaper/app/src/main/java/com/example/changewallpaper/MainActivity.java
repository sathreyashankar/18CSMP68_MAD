package com.example.changewallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn;
    boolean running;
    int ia[]={R.drawable.one1,R.drawable.two2,R.drawable.three3,R.drawable.four4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.button);
        btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(!running)
        {
            new Timer().schedule(new myTimer(),0,1000);
            running=true;
        }
    }
    public class myTimer extends  TimerTask {
        @Override
        public void run() {
            WallpaperManager wallpaperManager = WallpaperManager.getInstance(getBaseContext());
            Random random=new Random();
            try {
                wallpaperManager.setBitmap(BitmapFactory.decodeResource(getResources(),ia[random.nextInt(4)]));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}


