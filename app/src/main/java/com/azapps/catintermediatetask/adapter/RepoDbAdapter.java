package com.azapps.catintermediatetask.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.azapps.catintermediatetask.R;
import com.azapps.catintermediatetask.data.RepoItem;
import com.bumptech.glide.Glide;

public class RepoDbAdapter extends ListAdapter<RepoItem, RepoViewHolder> {
    OnFavouriteImageClickListener listener;
    private Context context;
    private static final DiffUtil.ItemCallback<RepoItem> diffCallback = new DiffUtillRepoDbCallback();

    public RepoDbAdapter(Context context, OnFavouriteImageClickListener onFavouriteImageClickListener) {
        super(diffCallback);
        this.context = context;
        listener = onFavouriteImageClickListener;
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_repo_item, parent, false);

        return new RepoViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
        RepoItem currentRepo = getItem(position);
        holder.repoNameTV.setText(currentRepo.getRepo());
        String fullRepoOwner = currentRepo.getUserName();
        String[] repoOwnerName = fullRepoOwner.split("/");
        holder.userNameTV.setText(repoOwnerName[0]);
        Glide.with(context).load(currentRepo.getImageUrl()).into(holder.repoImageView);
    }
}
