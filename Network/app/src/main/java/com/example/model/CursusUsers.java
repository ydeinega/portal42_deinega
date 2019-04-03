package com.example.model;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CursusUsers {

    @SerializedName("id")
    public int id;

    @SerializedName("begin_at")
    public String begin_at;

    @SerializedName("end_at")
    @Nullable
    public String end_at;

    @SerializedName("grade")
    @Nullable
    public String grade;

    @SerializedName("level")
    public float level;

    @SerializedName("skills")
    public List<Skills> skills;

    @SerializedName("cursus_id")
    public int cursusId;

    @SerializedName("has_coalition")
    public boolean hasCoalition;

    @SerializedName("user")
    public UserInfo user;

    @SerializedName("cursus")
    public Cursus cursus;

    public static class Skills {

        @SerializedName("id")
        public int id;

        @SerializedName("name")
        public String name;

        @SerializedName("level")
        public float level;
    }

    public static class UserInfo {

        @SerializedName("id")
        public int id;

        @SerializedName("login")
        public String login;

        @SerializedName("url")
        public String url;
    }

    public static class Cursus {

        @SerializedName("id")
        public int id;

        @SerializedName("created_at")
        public String createdAt;

        @SerializedName("name")
        public String name;

        @SerializedName("slug")
        public String slug;
    }
}
