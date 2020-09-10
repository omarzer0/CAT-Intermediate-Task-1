package com.azapps.catintermediatetask.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.azapps.catintermediatetask.data.RepoItem;

import java.util.List;

@Dao
public interface RepoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(RepoItem RepoItem);

    @Delete
    void delete(RepoItem RepoItem);

    @Query("SELECT * FROM repo_table")
    LiveData<List<RepoItem>> getAllFavouriteRepos();
}
