package com.example.aim;

import org.json.JSONArray;

import retrofit2.Call;
import retrofit2.http.GET;

public interface retrofit_api_interface
{
    @GET("GetListGroup")
    Call<JSONArray> GetGroupList();
}
