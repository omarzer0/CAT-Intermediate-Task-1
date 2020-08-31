package com.azapps.catintermediatetask.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.azapps.catintermediatetask.data.Repo;


public class DiffUtilRepoCallback extends DiffUtil.ItemCallback<Repo> {

    @Override
    public boolean areItemsTheSame(@NonNull Repo oldItem, @NonNull Repo newItem) {
        return oldItem.getId().equals(newItem.getId());
    }

    @Override
    public boolean areContentsTheSame(@NonNull Repo oldItem, @NonNull Repo newItem) {
        return (oldItem.getName().equals(newItem.getName()));
    }
}
