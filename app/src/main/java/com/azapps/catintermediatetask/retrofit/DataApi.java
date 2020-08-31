package com.azapps.catintermediatetask.retrofit;

import com.azapps.catintermediatetask.data.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import static com.azapps.catintermediatetask.utils.Constant.RELATIVE_URL_SEARCH_BY_USER_REPO;

public interface DataApi {
    //  https://api.github.com/users/omarzer0/repos
    @GET("users/{user_name}/repos")
    Call<List<Repo>> getRepoByUserName(@Path(value = "user_name" , encoded = true) String userName);
}
