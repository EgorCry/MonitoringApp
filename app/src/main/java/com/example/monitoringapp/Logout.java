package com.example.monitoringapp;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Logout {
    @POST("/logout")
    Call<ResponseBody> logout();
}