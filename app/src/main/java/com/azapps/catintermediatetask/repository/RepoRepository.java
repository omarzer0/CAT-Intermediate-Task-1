package com.azapps.catintermediatetask.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.azapps.catintermediatetask.data.RepoItem;
import com.azapps.catintermediatetask.db.RepoDao;
import com.azapps.catintermediatetask.db.RepoDatabase;

import java.util.List;

public class RepoRepository {
    private RepoDao repoDao;
    private LiveData<List<RepoItem>> allRepos;

    public RepoRepository(Application application) {
        RepoDatabase songDatabase = RepoDatabase.getInstance(application);
        repoDao = songDatabase.repoDao();
        allRepos = repoDao.getAllFavouriteRepos();
    }


    public void insert(RepoItem repoItem) {
        new InsertRepoAsyncTask(repoDao).execute(repoItem);
    }

    public void delete(RepoItem repoItem) {
        new DeleteRepoAsyncTask(repoDao).execute(repoItem);
    }



    public LiveData<List<RepoItem>> getAllSongs() {
        return allRepos;
    }

    private static class InsertRepoAsyncTask extends AsyncTask<RepoItem,Void,Void>{
        private RepoDao repoDao;
        public InsertRepoAsyncTask(RepoDao repoDao){
            this.repoDao = repoDao;
        }

        @Override
        protected Void doInBackground(RepoItem... repoItems) {
            repoDao.insert(repoItems[0]);
            return null;
        }
    }

    private static class DeleteRepoAsyncTask extends AsyncTask<RepoItem,Void,Void>{
        private RepoDao repoDao;
        public DeleteRepoAsyncTask(RepoDao repoDao){
            this.repoDao = repoDao;
        }

        @Override
        protected Void doInBackground(RepoItem... repoItems) {
            repoDao.delete(repoItems[0]);
            return null;
        }
    }



}
