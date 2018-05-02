package com.example.as.appmarket_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Launcher extends Activity{
    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.launcher);

        new NetworkThread().start();

        Integer time = 500;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Launcher.this, MainActivity.class);
                startActivity(intent);
                Launcher.this.finish();
            }
        }, time);


    }
}
