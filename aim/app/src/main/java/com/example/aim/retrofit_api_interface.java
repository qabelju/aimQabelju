package com.example.aim;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface retrofit_api_interface
{
    @GET
    Call<Object> Get(@Url String url);

    @POST
    Call<Object> Post(@Url String url,@Body Object obj);

}

