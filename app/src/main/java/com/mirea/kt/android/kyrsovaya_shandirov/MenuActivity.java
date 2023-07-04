package com.mirea.kt.android.kyrsovaya_shandirov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void startActivity1(View v){
        Intent intent = new Intent(this, Networq.class);
        startActivity(intent);
        Log.d("app_tag", "Open network activity");
    }

    public void startActivity2(View v){
        Intent intent = new Intent(this, Password.class);
        startActivity(intent);
        Log.d("app_tag", "Open Password activity");
    }
    public void startActivity3(View v){
        Intent intent = new Intent(this, DataTransfer.class);
        startActivity(intent);
        Log.d("app_tag", "Open DataTransfer activity");
    }
    public void startActivity4(View v){
        Intent intent = new Intent(this, Poe.class);
        startActivity(intent);
        Log.d("app_tag", "Open Poe activity");
    }
}