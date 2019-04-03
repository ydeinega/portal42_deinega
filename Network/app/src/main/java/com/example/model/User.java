package com.example.model;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class User
{
    @SerializedName("id")
    public int id;

    @SerializedName("email")
    public String email;

    @SerializedName("login")
    public String login;

    @SerializedName("first_name")
    public String firstName;

    @SerializedName("last_name")
    public String lastName;

    @SerializedName("url")
    public String url;

    @SerializedName("phone")
    @Nullable
    public String phone;

    @SerializedName("displayname")
    public String displayName;

    @SerializedName("image_url")
    public String imageUrl;

    @SerializedName("staff?")
    public boolean staff;

    @SerializedName("correction_point")
    public int correctionPoint;

    @SerializedName("pool_month")
    public String poolMonth;

    @SerializedName("pool_year")
    public String poolYear;

    @SerializedName("location")
    @Nullable
    public String location;

    @SerializedName("wallet")
    public int wallet;

    @SerializedName("groups")
    public List<UserGroups> groups;//not checked

    @SerializedName("cursus_users")
    public List<CursusUsers> cursusUsers;

    @SerializedName("project_users")
    public List<ProjectsUsers> projectUsers;

    @SerializedName("languages_users")
    public List<LanguagesUsers> languagesUsers;

    @SerializedName("achievements")
    public List<Achievements> achievements;

    @SerializedName("titles")
    public List<Titles> titles;

    @SerializedName("titles_users")
    public List<TitlesUsers> titlesUsers;

    @SerializedName("partnerships")
    public List<Partnerships> partnerships;

    @SerializedName("patroned")
    public List<Patron> patroned;

    @SerializedName("patroning")
    public List<Patron> patroning;

    @SerializedName("expertises_users")
    public List<ExpertiseUsers> expertiseUsers;

    @SerializedName("campus")
    public List<Campus> campus;

    @SerializedName("campus_users")
    public List<CampusUsers> campusUsers;

}


