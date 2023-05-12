package com.example.monitoringapp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AdminAPI {
    @GET("/admin")
    Call<AdminResponse> getAdminData();
}
