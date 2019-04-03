package com.example.model;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProjectsUsers {

    @SerializedName("id")
    public int id;

    @SerializedName("occurrence")
    public int occurrence;

    @Nullable
    @SerializedName("final_mark")
    public Integer finalMark;

    @SerializedName("status")
    public String status;

    @Nullable
    @SerializedName("validated?")
    public Boolean validated;

    @Nullable
    @SerializedName("current_team_id")
    public Integer currentTeamId;

   @SerializedName("project")
   public Project project;

    @SerializedName("cursus_ids")
    public List<Integer> cursusIds;

    @SerializedName("marked_at")
    public String markedAt;

    @SerializedName("marked")
    public boolean marked;

//    @Nullable
//    @SerializedName("user")
//    public UserInfo user;

//    @Nullable
//    @SerializedName("teams")
//    public List<Teams> teams;

    public static class Project {
        @SerializedName("id")
        public int id;

        @SerializedName("name")
        public String name;

        @SerializedName("slug")
        public String slug;

        @SerializedName("parent_id")
        @Nullable
        public Integer parentId;
    }
}
