package com.example.monitoringapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AdminActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:5000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TextView tvName = (TextView) findViewById(R.id.tv_name);
        TextView tvPlaceName = (TextView) findViewById(R.id.tv_place_name);

        AdminAPI adminAPI = retrofit.create(AdminAPI.class);

        Call<AdminResponse> call = adminAPI.getAdminData();
        call.enqueue(new Callback<AdminResponse>() {
            @Override
            public void onResponse(Call<AdminResponse> call, Response<AdminResponse> response) {
                if (response.isSuccessful()) {
                    AdminResponse adminResponse = response.body();
                    if (adminResponse != null) {
                        String name = adminResponse.getFirst_name() + " " + adminResponse.getSecond_name();
                        String placeName = adminResponse.getWorkshop_name();
                        tvName.setText(name);
                        tvPlaceName.setText(placeName);
                    }
                } else {
                    // код для обработки ошибок при отправке запроса
                    Toast.makeText(AdminActivity.this, "Ошибка сети. Проверьте подключение к Интернету и попробуйте снова", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<AdminResponse> call, Throwable t) {
                // код для обработки ошибок при отправке запроса
                Toast.makeText(AdminActivity.this, "Ошибка сети. Проверьте подключение к Интернету и попробуйте снова", Toast.LENGTH_LONG).show();
            }
        });

        Button btnLogout = findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logout apiInterface = retrofit.create(Logout.class);
                Call<ResponseBody> call = apiInterface.logout();
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Intent intent = new Intent(AdminActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        // код для обработки ошибки при отправке запроса
                        Toast.makeText(AdminActivity.this, "Ошибка сети. Проверьте подключение к Интернету и попробуйте снова", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }
}
