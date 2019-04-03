package com.example.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Campus {

    @SerializedName("id")
    public int id;

    @SerializedName("name")
    public String name;

    @SerializedName("time_zone")
    public String timeZone;

    @SerializedName("language")
    public Language language;

    @SerializedName("users_count")
    public int userCount;

    @SerializedName("vogsphere_id")
    public int vogsphereId;

    @SerializedName("country")
    public String country;

    @SerializedName("address")
    public String address;

    @SerializedName("zip")
    public String zip;

    @SerializedName("city")
    public String city;

    @SerializedName("website")
    public String website;

    @SerializedName("facebook")
    public String facebook;

    @SerializedName("twitter")
    public String twitter;

}
