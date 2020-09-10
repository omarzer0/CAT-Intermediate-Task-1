package com.azapps.catintermediatetask.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.azapps.catintermediatetask.data.RepoItem;


@Database(entities = {RepoItem.class}, version = 1)
public abstract class RepoDatabase extends RoomDatabase {

    private static RepoDatabase INSTANCE;

    public abstract RepoDao repoDao();

    public static synchronized RepoDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), RepoDatabase.class, "song_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return INSTANCE;
    }
}
