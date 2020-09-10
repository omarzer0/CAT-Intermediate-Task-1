package com.azapps.catintermediatetask.data;


import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "repo_table")
public class RepoItem {
    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private String repo;
    private String userName;
    private String imageUrl;

    public RepoItem(int id, String repo, String userName, String imageUrl) {
        this.id = id;
        this.repo = repo;
        this.userName = userName;
        this.imageUrl = imageUrl;
    }

    @Ignore
    public RepoItem(String repo, String userName, String imageUrl) {
        this.repo = repo;
        this.userName = userName;
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRepo() {
        return repo;
    }

    public void setRepo(String repo) {
        this.repo = repo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
