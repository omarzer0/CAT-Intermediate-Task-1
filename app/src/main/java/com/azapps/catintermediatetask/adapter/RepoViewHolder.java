package com.azapps.catintermediatetask.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.azapps.catintermediatetask.R;

public class RepoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView repoNameTV, userNameTV;
    ImageView repoImageView, favouriteImageView;
    OnFavouriteImageClickListener listener;

    public RepoViewHolder(@NonNull View itemView, OnFavouriteImageClickListener onFavouriteImageClickListener) {
        super(itemView);
        repoNameTV = itemView.findViewById(R.id.item_repo_item_repo_name_ed);
        userNameTV = itemView.findViewById(R.id.item_repo_item_user_name_ed);
        repoImageView = itemView.findViewById(R.id.item_repo_item_img_image_view);
        favouriteImageView = itemView.findViewById(R.id.item_repo_item_repo_favourite);
        favouriteImageView.setOnClickListener(this);
        listener = onFavouriteImageClickListener;
    }

    @Override
    public void onClick(View v) {
        listener.onFavouriteImageClick(getAdapterPosition());
    }
}
