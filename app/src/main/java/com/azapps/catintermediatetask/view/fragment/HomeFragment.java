package com.azapps.catintermediatetask.view.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.azapps.catintermediatetask.R;
import com.azapps.catintermediatetask.adapter.OnFavouriteImageClickListener;
import com.azapps.catintermediatetask.adapter.RepoAdapter;
import com.azapps.catintermediatetask.data.Repo;
import com.azapps.catintermediatetask.retrofit.DataApi;
import com.azapps.catintermediatetask.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment implements OnFavouriteImageClickListener {
    public static final String TAG = "HomeFragment";

    private RecyclerView recyclerView;
    private EditText searchEditText;
    private List<Repo> repoListResult;
    private RepoAdapter adapter;
    private DataApi dataApi;

    public HomeFragment() {
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Log.e(TAG, "onCreateView: ");
        intiViews(view);
        buildRetrofit();
        initEditTextSearchFunction();
//        getResultsFromRetrofit("omarzer0");

        return view;
    }

    private void intiViews(View view) {
        Log.e(TAG, "intiViews: ");
        recyclerView = view.findViewById(R.id.fragment_home_repo_recycler_view);
        searchEditText = view.findViewById(R.id.fragment_home_ed_search_edit_text);
    }

    private void initEditTextSearchFunction() {

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                getResultsFromRetrofit(s.toString());
            }
        });
    }

    private void buildRetrofit() {
        Log.e(TAG, "buildRetrofit: ");
        dataApi = RetrofitClient.getClient().create(DataApi.class);
    }

    private void getResultsFromRetrofit(String userName) {
        Log.e(TAG, "getResultsFromRetrofit: ");
        Call<List<Repo>> call = dataApi.getRepoByUserName(userName);
        call.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                List<Repo> repoList = response.body();
                initRecyclerView(repoList);
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    private void initRecyclerView(List<Repo> repoList) {
        Log.e(TAG, "initRecyclerView: ");
        repoListResult = repoList;
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.hasFixedSize();
        adapter = new RepoAdapter(getContext(), this);
        adapter.submitList(repoListResult);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onFavouriteImageClick(int position) {

    }
}
