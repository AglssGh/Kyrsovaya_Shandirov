package com.mirea.kt.android.kyrsovaya_shandirov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.security.SecureRandom;

public class Password extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        Button generateButton = findViewById(R.id.generateButton);
        generateButton.setOnClickListener(this);

        Button copyButton = findViewById(R.id.copy);
        copyButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

            int length = 10;
            String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789#$%&@!";
            SecureRandom random = new SecureRandom();
            StringBuilder password = new StringBuilder();
            for (int i = 0; i < length; i++) {
                int index = random.nextInt(symbols.length());
                char randomChar = symbols.charAt(index);
                password.append(randomChar);
            }
            TextView passwordTextView = findViewById(R.id.tvPassword);
        if(v.getId() == R.id.generateButton) {
            Log.d("app_tag", "click button");
            passwordTextView.setText(password);
        }
            if(v.getId() == R.id.copy){
                Log.d("app_tag", "click button");
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("password", password);
                clipboardManager.setPrimaryClip(clipData);

                Toast.makeText(this, "Пароль скопирован в буфер обмена", Toast.LENGTH_SHORT).show();
            }



    }


    }