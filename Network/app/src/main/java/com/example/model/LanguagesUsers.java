package com.example.model;

import com.google.gson.annotations.SerializedName;


public class LanguagesUsers {

    @SerializedName("id")
    public int id;

    @SerializedName("language_id")
    public int languageId;

    @SerializedName("user_id")
    public int userId;

    @SerializedName("position")
    public int position;

    @SerializedName("created_at")
    public String createdAt;
}
