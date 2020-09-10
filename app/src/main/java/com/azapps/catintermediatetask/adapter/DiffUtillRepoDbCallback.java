package com.azapps.catintermediatetask.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.azapps.catintermediatetask.data.RepoItem;

public class DiffUtillRepoDbCallback extends DiffUtil.ItemCallback<RepoItem>{

    @Override
    public boolean areItemsTheSame(@NonNull RepoItem oldItem, @NonNull RepoItem newItem) {
        return oldItem.getId().equals(newItem.getId());
    }

    @Override
    public boolean areContentsTheSame(@NonNull RepoItem oldItem, @NonNull RepoItem newItem) {
        return (oldItem.getUserName().equals(newItem.getUserName()));
    }

}
