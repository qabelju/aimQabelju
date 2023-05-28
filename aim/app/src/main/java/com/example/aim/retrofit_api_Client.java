package com.example.aim;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofit_api_Client
{

    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance(String Url)
    {
        if (retrofit == null)
        {
            retrofit = new Retrofit.Builder().baseUrl(Url).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

}
