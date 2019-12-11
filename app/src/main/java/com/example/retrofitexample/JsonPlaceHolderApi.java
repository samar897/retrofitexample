package com.example.retrofitexample;



import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

  @GET("logins")
  Call<List<post>> getPosts();
}
