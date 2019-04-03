package com.example.model;

import com.google.gson.annotations.SerializedName;

public class ExpertiseUsers {

    @SerializedName("id")
    public int id;

    @SerializedName("expertise_id")
    public int expertiseId;

    @SerializedName("interested")
    public boolean interested;

    @SerializedName("value")
    public int value;

    @SerializedName("contact_me")
    public boolean contactMe;

    @SerializedName("created_at")
    public String createdAt;

    @SerializedName("user_id")
    public int userId;

}
