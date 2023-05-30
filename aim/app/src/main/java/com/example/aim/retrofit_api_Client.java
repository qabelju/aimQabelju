package com.example.aim;


import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit;
public class retrofit_api_Client
{

    private static retrofit2.Retrofit retrofit;

    public static retrofit2.Retrofit getRetrofitInstance(String Url)
    {

        if (retrofit == null)
        {
            retrofit = new retrofit2.Retrofit.Builder().baseUrl(Url)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;

    }

}


