package com.mirea.kt.android.kyrsovaya_shandirov;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Poe extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poe);

        Button button = findViewById(R.id.generateButton);

        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.generateButton) {
            Log.d("app_tag", "Click button");
            EditText cat = findViewById(R.id.etCat);
            EditText voltage = findViewById(R.id.etVoltage);
            EditText length = findViewById(R.id.etLength);
            EditText devices = findViewById(R.id.etDevices);

            String catStr = cat.getText().toString();
            String voltageStr = voltage.getText().toString();
            String lengthStr = length.getText().toString();
            String devicesStr = devices.getText().toString();

            Log.i("simple_app_tag", catStr);


            if (!catStr.isEmpty() || !voltageStr.isEmpty() || !lengthStr.isEmpty() || !devicesStr.isEmpty()) {

                String value1 = "5";
                String value2 = "5a";
                String value3 = "6";
                String value4 = "6a";
                String value5 = "7";


                if (catStr.equals(value1)){

                    int voltageInt = Integer.parseInt(voltageStr);
                    int lengthInt = Integer.parseInt(lengthStr);
                    int devicesInt = Integer.parseInt(devicesStr);

                    int answer = (int) (0.8 * voltageInt * lengthInt * devicesInt);

                    Log.i("simple_app_tag", String.valueOf(voltageInt));
                    Log.i("simple_app_tag", String.valueOf(lengthInt));
                    Log.i("simple_app_tag", String.valueOf(devicesInt));

                    TextView resultView = findViewById(R.id.result);

                    String resultStr = new StringBuilder().append(getString(R.string.power)).append(" ").append(answer).append(" ").append(getString(R.string.vatt)).toString();
                    Log.i("simple_app_tag", resultStr);

                    resultView.setText(resultStr);

                }if (catStr.equals(value2)){
                    int voltageInt = Integer.parseInt(voltageStr);
                    int lengthInt = Integer.parseInt(lengthStr);
                    int devicesInt = Integer.parseInt(devicesStr);


                    int answer = (int) (0.9 * voltageInt * lengthInt * devicesInt);

                    TextView resultView = findViewById(R.id.result);

                    String resultStr = new StringBuilder().append(getString(R.string.power)).append(answer).append(getString(R.string.vatt)).toString();

                    resultView.setText(resultStr);
                    Log.i("simple_app_tag", resultStr);

                }if (catStr.equals(value3)){
                    int voltageInt = Integer.parseInt(voltageStr);
                    int lengthInt = Integer.parseInt(lengthStr);
                    int devicesInt = Integer.parseInt(devicesStr);


                    int answer = (int) (0.9 * voltageInt * lengthInt * devicesInt);

                    TextView resultView = findViewById(R.id.result);

                    String resultStr = new StringBuilder().append(getString(R.string.power)).append(answer).append(getString(R.string.vatt)).toString();

                    resultView.setText(resultStr);

                }if (catStr.equals(value4)){
                    int voltageInt = Integer.parseInt(voltageStr);
                    int lengthInt = Integer.parseInt(lengthStr);
                    int devicesInt = Integer.parseInt(devicesStr);


                    int answer = (int) (0.98 * voltageInt * lengthInt * devicesInt);

                    TextView resultView = findViewById(R.id.result);

                    String resultStr = new StringBuilder().append(getString(R.string.power)).append(answer).append(getString(R.string.vatt)).toString();

                    resultView.setText(resultStr);

                }if (catStr.equals(value5)){
                    int voltageInt = Integer.parseInt(voltageStr);
                    int lengthInt = Integer.parseInt(lengthStr);
                    int devicesInt = Integer.parseInt(devicesStr);


                    int answer = (int) (0.9 * voltageInt * lengthInt * devicesInt);

                    TextView resultView = findViewById(R.id.result);

                    String resultStr = new StringBuilder().append(getString(R.string.power)).append(answer).append(getString(R.string.vatt)).toString();

                    resultView.setText(resultStr);

                }






            }else{
                Toast.makeText(getApplicationContext(), "Введите все значения!", Toast.LENGTH_LONG).show();
            }
        }

    }
}