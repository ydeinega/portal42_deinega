package com.example.model;

import com.google.gson.annotations.SerializedName;

public class Partnerships {

    @SerializedName("id")
    public int id;

    @SerializedName("name")
    public String name;

    @SerializedName("slug")
    public String slug;

    @SerializedName("tier")
    public int tier;

    @SerializedName("url")
    public String url;

    @SerializedName("partnerships_users_url")
    public String partnershipsUsersUrl;
}
