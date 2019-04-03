package com.example.model;

import com.google.gson.annotations.SerializedName;

public class Patron {

    @SerializedName("id")
    public int id;

    @SerializedName("user_id")
    public int userId;

    @SerializedName("godfather_id")
    public int godfatherId;

    @SerializedName("ongoing")
    public boolean ongoing;

    @SerializedName("created_at")
    public String createdAt;

    @SerializedName("updated_at")
    public String updatedAt;
}
