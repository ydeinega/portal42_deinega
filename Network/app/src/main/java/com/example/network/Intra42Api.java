package com.example.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Intra42Api {

    @POST("/oauth/token")
    public Call<Token> getToken(@Query("grant_type") String grantType, @Query("client_id") String uid, @Query("client_secret") String secret);

}
