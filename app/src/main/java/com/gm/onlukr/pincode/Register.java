package com.gm.onlukr.pincode;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Url;

public interface Register {

    @Headers("Content-Type:application/json")
    @GET()
    Call<ResponseData> CreateUser(@Url String url);
}