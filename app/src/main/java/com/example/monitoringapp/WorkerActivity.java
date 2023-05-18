package com.example.monitoringapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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

public class WorkerActivity extends AppCompatActivity {
    private Handler Handler = new Handler();
    private Runnable mRunnable;
    private AppAPI appAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.worker);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:5000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TextView tvName = (TextView) findViewById(R.id.tv_name);
        TextView tvPlaceName = (TextView) findViewById(R.id.tv_place_name);

        ImageView imageViewHealth = findViewById(R.id.iv_first_image);
        ImageView imageViewHumidity = findViewById(R.id.iv_second_image);
        TextView tvStatus = (TextView) findViewById(R.id.tv_text);
        ImageView imageDevice = findViewById(R.id.iv_device);

        appAPI = retrofit.create(AppAPI.class);

        mRunnable = new Runnable() {
            @Override
            public void run() {
                Call<WorkerResponse> call = appAPI.getWorkerData();
                call.enqueue(new Callback<WorkerResponse>() {
                    @Override
                    public void onResponse(Call<WorkerResponse> call, Response<WorkerResponse> response) {
                        if (response.isSuccessful()) {
                            WorkerResponse workerResponse = response.body();
                            if (workerResponse != null) {
                                String name = workerResponse.getName() + " " + workerResponse.getSurname();
                                String placeName = workerResponse.getWorkshopName();

                                int predictionInt = workerResponse.getPrediction_worker().intValue();
                                int imageHealth = getResources().getIdentifier("percent_" + predictionInt, "drawable", getPackageName());
                                int humidityInt = workerResponse.getHumidity_worker().intValue();
                                int imageHumidity = getResources().getIdentifier("percent_" + humidityInt, "drawable", getPackageName());

                                int statusDevice = workerResponse.getDevice_worker();
                                if (statusDevice == 1){
                                    statusDevice = getResources().getIdentifier("mask", "drawable", getPackageName());
                                }
                                else {
                                    statusDevice = getResources().getIdentifier("no_mask", "drawable", getPackageName());
                                }
                                imageDevice.setImageResource(statusDevice);


                                imageViewHealth.setImageResource(imageHealth);
                                imageViewHumidity.setImageResource(imageHumidity);
                                String statusWorker2 = workerResponse.getStatus_worker();
                                if (statusWorker2.equals("SAFE")) {
                                    tvStatus.setText("SAFE");
                                    tvStatus.setTextColor(0xFF00FFAA);
                                } else if (statusWorker2.equals("GOOD")) {
                                    tvStatus.setText("GOOD");
                                    tvStatus.setTextColor(0xFFFFCC00);
                                } else if (statusWorker2.equals("BAD")) {
                                    tvStatus.setText("BAD");
                                    tvStatus.setTextColor(0xFFFF2400);
                                }

                                tvName.setText(name);
                                tvPlaceName.setText(placeName);
                            }
                        } else {
                            // код для обработки ошибок при отправке запроса
                            Toast.makeText(WorkerActivity.this, "Ошибка сети. Проверьте подключение к Интернету и попробуйте снова", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<WorkerResponse> call, Throwable t) {
                        // код для обработки ошибок при отправке запроса
                        Toast.makeText(WorkerActivity.this, "Ошибка сети. Проверьте подключение к Интернету и попробуйте снова", Toast.LENGTH_LONG).show();
                    }
                });
                Handler.postDelayed(this, 1000); // Повторяем через 1 секунду
            }
        };
        Handler.post(mRunnable); // Начинаем повторение

        Button btnLogout = findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppAPI apiInterface = retrofit.create(AppAPI.class);
                Call<ResponseBody> call = apiInterface.logout();
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Intent intent = new Intent(WorkerActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        // код для обработки ошибки при отправке запроса
                        Toast.makeText(WorkerActivity.this, "Ошибка сети. Проверьте подключение к Интернету и попробуйте снова", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Handler.removeCallbacks(mRunnable); // Остановка повторения, когда активность закрывается
    }
}

