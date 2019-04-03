package com.example.model;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class Achievements {

    @SerializedName("id")
    public int id;

    @SerializedName("name")
    public String name;

    @SerializedName("description")
    public String description;

    @SerializedName("tier")
    public String tier;

    @SerializedName("kind")
    public String kind;

    @SerializedName("visible")
    public boolean visible;

    @SerializedName("image")
    public String imageUrl;

    @SerializedName("nbr_of_success")
    @Nullable
    public Integer nbrOfSuccess;

    @SerializedName("users_url")
    public String usersUrl;

}
