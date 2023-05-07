package com.example.monitoringapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WorkerService {
    @GET("workers")
    Call<List<Worker>> getWorkers();
}
