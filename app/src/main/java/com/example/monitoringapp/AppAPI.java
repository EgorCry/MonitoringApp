package com.example.monitoringapp;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AppAPI {
    @GET("workers")
    Call<List<Worker>> getWorkers();
    @GET("/admin")
    Call<AdminResponse> getAdminData();

    @GET("/worker")
    Call<WorkerResponse> getWorkerData();

    @POST("/logout")
    Call<ResponseBody> logout();

    @FormUrlEncoded
    @POST("/registration")
    Call<ResponseBody> register(
            @Field("login") String login,
            @Field("password") String password
    );
}
