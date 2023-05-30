package com.example.aim.Webservice;

import android.util.Log;

import org.json.JSONObject;

public class Webservice
{
    public  enum VarLibrary
    {
        Retrofit,
        Volley
    }


    public  enum MethodHttp
    {
        Get,
        Post
    }

    public static ResultWebservice resultWebservice = new ResultWebservice();

    public static ResultWebservice Call(VarLibrary varLibrary, MethodHttp methodHttp, String Url, JSONObject json)
    {
        try
        {
            Log.e("MehrdadQabelju_WebserviceLog", "Start Call Webservice");
            if (varLibrary == VarLibrary.Volley)
            {
                Log.e("MehrdadQabelju_WebserviceLog", "Call Volley Library");

                return  Vollay_Method.call(methodHttp,Url,json);

            }

            return resultWebservice;
        }
        catch (Exception ex)
        {
            Log.e("MehrdadQabelju_WebserviceLog", "Exception= " + ex.getMessage());
            return resultWebservice;
        }
    }
}
