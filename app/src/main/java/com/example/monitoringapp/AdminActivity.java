package com.example.monitoringapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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

        ImageView imageViewHealth2 = findViewById(R.id.iv_first_image);
        ImageView imageViewHumidity2 = findViewById(R.id.iv_second_image);
        TextView tvStatus2 = (TextView) findViewById(R.id.tv_text);

        ImageView imageViewHealth3 = findViewById(R.id.iv_first_image1);
        ImageView imageViewHumidity3 = findViewById(R.id.iv_second_image1);
        TextView tvStatus3 = (TextView) findViewById(R.id.tv_text1);

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

                        int predictionInt2 = adminResponse.getPrediction_worker2().intValue();
                        int imageHealth2 = getResources().getIdentifier("percent_" + predictionInt2, "drawable", getPackageName());
                        int humidityInt2 = adminResponse.getHumidity_worker2().intValue();
                        int imageHumidity2 = getResources().getIdentifier("percent_" + humidityInt2, "drawable", getPackageName());
                        imageViewHealth2.setImageResource(imageHealth2);
                        imageViewHumidity2.setImageResource(imageHumidity2);
                        String statusWorker2 = adminResponse.getStatus_worker2();
                        if (statusWorker2.equals("SAFE")) {
                            tvStatus2.setText("SAFE");
                            tvStatus2.setTextColor(0xFF00FFAA);
                        } else if (statusWorker2.equals("GOOD")) {
                            tvStatus2.setText("GOOD");
                            tvStatus2.setTextColor(0xFFFFCC00);
                        } else if (statusWorker2.equals("BAD")) {
                            tvStatus2.setText("BAD");
                            tvStatus2.setTextColor(0xFFFF2400);
                        }

                        int predictionInt3 = adminResponse.getPrediction_worker3().intValue();
                        int imageHealth3 = getResources().getIdentifier("percent_" + predictionInt3, "drawable", getPackageName());
                        int humidityInt3 = adminResponse.getHumidity_worker3().intValue();
                        int imageHumidity3 = getResources().getIdentifier("percent_" + humidityInt3, "drawable", getPackageName());
                        imageViewHealth3.setImageResource(imageHealth3);
                        imageViewHumidity3.setImageResource(imageHumidity3);
                        String statusWorker3 = adminResponse.getStatus_worker3();
                        if (statusWorker3.equals("SAFE")) {
                            tvStatus3.setText("SAFE");
                            tvStatus3.setTextColor(0xFF00FFAA);
                        } else if (statusWorker3.equals("GOOD")) {
                            tvStatus3.setText("GOOD");
                            tvStatus3.setTextColor(0xFFFFCC00);
                        } else if (statusWorker3.equals("BAD")) {
                            tvStatus3.setText("BAD");
                            tvStatus3.setTextColor(0xFFFF2400);
                        }

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
