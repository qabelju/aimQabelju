package com.example.aim;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;


public class Webservice_Retrofit
{

    public static String  CallGet(Context cvvvv)
    {
        retrofit_api_interface request;
        request = retrofit_api_Client.getRetrofitInstance("http://192.168.1.242:1363/api/Bank/").create(retrofit_api_interface.class);


          String[] res=new String[10];
        res[0] = "Hello";

        request.GetGroupList().enqueue(new Callback<List<Object>>() {
            @Override
            public void onResponse(Call<List<Object>> call, Response<List<Object>> response)
            {



                //res = response.body().toString();
                //list = response.body();
                //Toast.makeText( c , response.body().toString(), Toast.LENGTH_SHORT).show();
                res[0]= response.body().toString();
                //((TextView)c.findViewById(R.id.textView222)).setText(response.body().toString());
                Log.e("ooooooooooooooo",response.body().toString());
            }

            @Override
            public void onFailure(Call<List<Object>> call, Throwable t)
            {

                Log.e("ooooooooooooooo",t.getMessage());
                //Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return  res[0];
    }

}



interface retrofit_api_interface
{
    @GET("GetGroupList")
    Call<List<Object>> GetGroupList();

}


class retrofit_api_Client
{

    private static retrofit2.Retrofit retrofit;

    public static retrofit2.Retrofit getRetrofitInstance(String Url)
    {
        if (retrofit == null)
        {
            retrofit = new retrofit2.Retrofit.Builder().baseUrl(Url).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

}

//============================================================================
//||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
//============================================================================
