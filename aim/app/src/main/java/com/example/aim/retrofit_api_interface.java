package com.example.aim;

import org.json.JSONArray;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface retrofit_api_interface
{

    Call<List<Object>> GetGroupList();
}
