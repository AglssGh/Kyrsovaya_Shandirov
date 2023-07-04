package com.mirea.kt.android.kyrsovaya_shandirov;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Networq extends AppCompatActivity {

    private EditText ip1, ip2, ip3, ip4, ip1s, ip2s, ip3s, ip4s;
    private Button goButton;
    private TextView answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_networq);
        ip1s = findViewById(R.id.t192S);
        ip2s = findViewById(R.id.t168S);
        ip3s = findViewById(R.id.t0S);
        ip4s = findViewById(R.id.t1S);

        ip1 = findViewById(R.id.t192);
        ip2 = findViewById(R.id.t168);
        ip3 = findViewById(R.id.t0);
        ip4 = findViewById(R.id.t1);
        answer = findViewById(R.id.answer);
        goButton = findViewById(R.id.goButton);
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("app_tag", "click button");
                String mask1 = ip1s.getText().toString();
                String mask2 = ip2s.getText().toString();
                String mask3 = ip3s.getText().toString();
                String mask4 = ip4s.getText().toString();


                String adress1 = ip1.getText().toString();
                String adress2 = ip2.getText().toString();
                String adress3 = ip3.getText().toString();
                String adress4 = ip4.getText().toString();



                    if ((mask1.isEmpty()) || (mask2.isEmpty()) || (mask3.isEmpty()) || (mask4.isEmpty()) || (adress1.isEmpty()) || (adress2.isEmpty()) || (adress3.isEmpty()) || (adress4.isEmpty()) || (mask1.isEmpty())) {
                        Toast.makeText(getApplicationContext(), "Введите все значения!", Toast.LENGTH_LONG).show();
                    } else {


                        int maskInt1 = Integer.parseInt(mask1);
                        int maskInt2 = Integer.parseInt(mask2);
                        int maskInt3 = Integer.parseInt(mask3);
                        int maskInt4 = Integer.parseInt(mask4);

                        int adressInt1 = Integer.parseInt(adress1);
                        int adressInt2 = Integer.parseInt(adress2);
                        int adressInt3 = Integer.parseInt(adress3);
                        int adressInt4 = Integer.parseInt(adress4);

                    if ((maskInt1 > 255) || (maskInt2 > 255) || (maskInt3 > 255) || (maskInt4 > 254) || (adressInt1 > 255) || (adressInt2 > 255) || (adressInt3 > 255) || (adressInt4 > 254)) {

                        Toast.makeText(getApplicationContext(), "Impossible values", Toast.LENGTH_LONG).show();
                    } else {


                        int binaryAns1 = maskInt1 & adressInt1;
                        int binaryAns2 = maskInt2 & adressInt2;
                        int binaryAns3 = maskInt3 & adressInt3;
                        int binaryAns4 = maskInt4 & adressInt4;

                        String answerStr = new StringBuilder().append(binaryAns1).append(".").append(binaryAns2).append(".").append(binaryAns3).append(".").append(binaryAns4).toString();

                        TextView answer = findViewById(R.id.answer);

                        answer.setText("Addresses number = " + answerStr);


                        int[] numbers = {maskInt1, maskInt2, maskInt3, maskInt4};
                        int totalCounter = 0;

                        for (int n : numbers) {
                            totalCounter += Integer.bitCount(n);
                            Log.i("simple_app_tag", String.valueOf(totalCounter));
                            int hosts = (int) (Math.pow(2, 32 - totalCounter)) - 2;


                            String hostsStr = String.valueOf(new StringBuilder().append(getString(R.string.hosts)).append(hosts));
                            TextView hostsView = findViewById(R.id.hosts);
                            hostsView.setText(hostsStr);
                        }

                    }


                    }
                }

        });
    }
}