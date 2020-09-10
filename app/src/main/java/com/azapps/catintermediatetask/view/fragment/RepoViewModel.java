package com.azapps.catintermediatetask.view.fragment;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.azapps.catintermediatetask.data.RepoItem;
import com.azapps.catintermediatetask.repository.RepoRepository;

import java.util.List;

public class RepoViewModel extends AndroidViewModel {
    private RepoRepository repository;
    private LiveData<List<RepoItem>> allRepos;

    public RepoViewModel(@NonNull Application application) {
        super(application);
        repository = new RepoRepository(application);
        allRepos = repository.getAllSongs();
    }

    public LiveData<List<RepoItem>> getAllRepos(){
        return allRepos;
    }

    public void insert(RepoItem repoItem){
        repository.insert(repoItem);
    }

    public void delete(RepoItem repoItem){
        repository.delete(repoItem);
    }
}
