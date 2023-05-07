package com.example.monitoringapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Response;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private WorkerService workerService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:5000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        workerService = retrofit.create(WorkerService.class);
        Call<List<Worker>> call = workerService.getWorkers();
        call.enqueue(new Callback<List<Worker>>() {
            @Override
            public void onResponse(Call<List<Worker>> call, Response<List<Worker>> response) {
                if (response.isSuccessful()) {
                    List<Worker> workers = response.body();
                    for (Worker worker : workers) {
                        if (worker != null) {
                            Log.d("WORKER", "First name: " + worker.getFirst_name());
                        } else {
                            Log.e("WORKER", "Worker is null");
                        }

                    }
                } else {
                    Log.e("WORKER", "Error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Worker>> call, Throwable t) {
                Log.e("WORKER", "Error: " + t.getMessage());
            }
        });
    }
}
