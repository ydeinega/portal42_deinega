package com.example.model;

import com.google.gson.annotations.SerializedName;

public class TitlesUsers {

    @SerializedName("id")
    public int id;

    @SerializedName("user_id")
    public int userId;

    @SerializedName("title_id")
    public int titleId;

    @SerializedName("selected")
    public boolean selected;
}
