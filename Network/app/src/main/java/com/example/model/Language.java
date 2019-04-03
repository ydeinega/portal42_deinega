package com.example.model;

import com.google.gson.annotations.SerializedName;

public class Language {

    @SerializedName("id")
    public int id;

    @SerializedName("name")
    public String name;

    @SerializedName("identifier")
    public String identifier;

    @SerializedName("created_at")
    public String createdAt;

    @SerializedName("updated_at")
    public String updatedAt;
}
