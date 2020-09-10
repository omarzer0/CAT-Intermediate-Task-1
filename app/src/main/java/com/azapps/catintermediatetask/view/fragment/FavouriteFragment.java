package com.azapps.catintermediatetask.view.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.azapps.catintermediatetask.R;
import com.azapps.catintermediatetask.adapter.OnFavouriteImageClickListener;
import com.azapps.catintermediatetask.adapter.RepoDbAdapter;
import com.azapps.catintermediatetask.data.RepoItem;

import java.util.List;

public class FavouriteFragment extends Fragment implements OnFavouriteImageClickListener {
    public static final String TAG = "FavouriteFragment";
    private RepoViewModel repoViewModel;
    private RecyclerView recyclerView;
    private RepoDbAdapter adapter;
    private List<RepoItem> repoItems;

    public FavouriteFragment() {
    }

    public static FavouriteFragment newInstance() {
        return new FavouriteFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favourite, container, false);
        initRecyclerView(view);
        setObservers();
        return view;
    }


    private void initRecyclerView(View view) {
        Log.e(TAG, "initRecyclerView: ");
        recyclerView = view.findViewById(R.id.fragment_favourite_recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        recyclerView.hasFixedSize();
        adapter = new RepoDbAdapter(getContext(), this);
        recyclerView.setAdapter(adapter);
    }

    private void setObservers() {
        repoViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.
                getInstance(getActivity().getApplication())).get(RepoViewModel.class);

        repoViewModel.getAllRepos().observe(getActivity(), new Observer<List<RepoItem>>() {
            @Override
            public void onChanged(List<RepoItem> repoList) {
                repoItems = repoList;
                adapter.submitList(repoItems);
            }
        });
    }


    @Override
    public void onFavouriteImageClick(int position) {
        RepoItem repoItem = repoItems.get(position);
        repoViewModel.delete(repoItem);
        Toast.makeText(getActivity(), "Removed from favourite", Toast.LENGTH_SHORT).show();
    }
}
