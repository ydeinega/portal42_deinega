package com.example.network;

import com.example.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface Api42 {

    @GET("/v2/users/{login}")
    public Call<User> getUser(@Path("login") String login);

}
