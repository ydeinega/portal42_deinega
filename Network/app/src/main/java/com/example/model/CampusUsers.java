package com.example.model;

import com.google.gson.annotations.SerializedName;

public class CampusUsers {

    @SerializedName("id")
    public int id;

    @SerializedName("user_id")
    public int userId;

    @SerializedName("campus_id")
    public int campusId;

    @SerializedName("is_primary")
    public boolean isPrimary;
}
