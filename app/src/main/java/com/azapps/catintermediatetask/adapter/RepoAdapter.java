package com.azapps.catintermediatetask.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.azapps.catintermediatetask.R;
import com.azapps.catintermediatetask.data.Repo;
import com.azapps.catintermediatetask.data.RepoOwner;
import com.bumptech.glide.Glide;

public class RepoAdapter extends ListAdapter<Repo,RepoViewHolder> {
    OnFavouriteImageClickListener listener;
    private Context context;
    private static final DiffUtil.ItemCallback<Repo> diffCallback = new DiffUtilRepoCallback();

    public RepoAdapter(Context context,OnFavouriteImageClickListener onFavouriteImageClickListener) {
        super(diffCallback);
        this.context = context;
        listener = onFavouriteImageClickListener;
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_repo_item, parent, false);

        return new RepoViewHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
        Repo currentRepo = getItem(position);
        RepoOwner currentRepoOwner = currentRepo.getRepoOwner();
        holder.repoNameTV.setText(currentRepo.getName());
        String fullRepoOwner = currentRepo.getFullName();
        String[] repoOwnerName = fullRepoOwner.split("/");
        holder.userNameTV.setText(repoOwnerName[0]);
        Glide.with(context).load(currentRepoOwner.getAvatarUrl()).into(holder.repoImageView);
    }
}
