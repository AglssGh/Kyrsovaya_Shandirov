package com.mirea.kt.android.kyrsovaya_shandirov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mirea.kt.android.kyrsovaya_shandirov.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityMainBinding binding;
    int result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.enterButton);
        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.enterButton) {
            EditText inpupLog = findViewById(R.id.login);
            EditText inputPswd = findViewById(R.id.password);

            String login = inpupLog.getText().toString();
            String pswd = inputPswd.getText().toString();

            if (!login.isEmpty() && !pswd.isEmpty()) {

                CalcApp.getServerApi().getCalcInfoAll(login, pswd, "RIBO-02-21").enqueue(new Callback<CalcInfoResponse>() {
                    @Override
                    public void onResponse(Call<CalcInfoResponse> call, Response<CalcInfoResponse> response) {
                        CalcInfoResponse sir = response.body();

                        int result = sir.getResult();
                        if (result == 1) {
                            Intent actIntent = new Intent(getApplicationContext(), MenuActivity.class);
                            startActivity(actIntent);

                        } else if (result == -1) {

                            Toast.makeText(getApplicationContext(), "Неверный пароль или логин", Toast.LENGTH_LONG).show();
                            Log.i("simple_app_tag", "Неверный пароль или логин");


                        }
                    }

                    @Override
                    public void onFailure(Call<CalcInfoResponse> call, Throwable t) {
                        Log.i("simple_app_tag", "error");
                    }
                });

            } else {
                Toast.makeText(getApplicationContext(), "Необходимо заполнить оба поля", Toast.LENGTH_LONG).show();
            }
        }
    }
}