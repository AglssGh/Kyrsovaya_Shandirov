package com.mirea.kt.android.kyrsovaya_shandirov;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DataTransfer extends AppCompatActivity {

    private EditText speed, total;
    private Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_transfer);
        TextView ansTime = findViewById(R.id.ansTime);
        speed = findViewById(R.id.speed);
        total = findViewById(R.id.total);
        button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("app_tag", "click button");
                float s = Float.parseFloat(total.getText().toString());
                float v = Float.parseFloat(speed.getText().toString());
                if ((v!=0) && (v*1 == v) && (s*1 == s)){
                    float a = v / s;
                    ansTime.setText("Answer = " + String.valueOf(a));
                }
                else {
                    Toast.makeText(getApplicationContext(), "Impossible values", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}