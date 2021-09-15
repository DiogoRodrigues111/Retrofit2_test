package br.io.opensource.retrofit_test;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RepositoryWeb {
    @GET("https://api.github.com/{events}")
    Call<List<API_GitHub>> listRepositoryWeb(@Path("events") String events);
}
