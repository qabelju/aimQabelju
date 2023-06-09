package com.example.aim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import android.util.Log;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;


import com.example.aim.Webservice.Vollay_Method;
import com.example.aim.Webservice.Webservice;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.chromium.net.CronetEngine;
import org.chromium.net.CronetException;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;
import org.json.JSONArray;



import org.json.JSONException;
import org.json.JSONObject;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.ByteBuffer;



import java.util.ArrayList;
import java.util.List;



import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.net.ssl.HttpsURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Header;


public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);


        //setContentView(R.layout.list_price);


        //RequestParams rp = new RequestParams();
        //rp.add("Id", "0");
        //rp.add("Price", "111");
        //rp.add("Title", "1111");
        //rp.add("InputOutput", "0");
        //rp.add("_Group", "1");
        //rp.add("DatePersian_String", "1401/12/30");

        //HttpUtils.post("http://192.168.1.242:1363/api/Bank/NewDec", rp, new JsonHttpResponseHandler() {
        //@Override
        //public void onSuccess(int statusCode, Header[] headers, JSONObject response) throws JSONException {
        // If the response is JSONObject instead of expected JSONArray
        // Log.d("asd", "---------------- this is response : " + response);
        //Toast.makeText(MainActivity.this, "---------------- this is response : " + response, Toast.LENGTH_SHORT).show();
        //JSONObject serverResp = new JSONObject(response.toString());
        //}

        //  @Override
        // public void onSuccess(int statusCode, Header[] headers, JSONArray timeline) {
        // Pull out the first event on the public timeline

        //}
        //});


    }


    public void onclick_EnterPrice(View view) {
        setContentView(R.layout.enter_price);
        Webservice.GetList_GroupBank(this);

    }

    public void onclick_SendEnterPrice(View view) {

        Webservice.SendEnterPrice(this);

    }

    //=========================================================================================
    //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    //=========================================================================================


    public void onclick_ReportList(View view)
    {
        setContentView(R.layout.list_price);

        Webservice.GetListPrice(this);

    }



    public void retrofit_Enginee() {
        try {

            retrofit_api_interface request;


            Log.e("Mehrdad Qabelju", "Start Retrofit");

            String Url = "http://192.168.1.242:1363/api/Bank/GetListGroup/";

            request = retrofit_api_Client.getRetrofitInstance(Url).create(retrofit_api_interface.class);

            Log.e("Mehrdad Qabelju", "111");
            request.Get(Url).enqueue(new Callback<Object>() {
                @Override
                public void onResponse(Call<Object> call, Response<Object> response) {

                    try {
                        Log.e("Mehrdad Qabelju", "Ok onResponse");
                        Log.e("Mehrdad Qabelju", "Ok onResponse = " + response);


                        Log.e("Mehrdad Qabelju", "onResponse=" + response.body().toString());
                    } catch (Exception ex) {
                        Log.e("Mehrdad Qabelju", "ErroronResponse=" + ex.getMessage());
                    }

                }

                @Override
                public void onFailure(Call<Object> call, Throwable t) {

                    Log.e("Mehrdad Qabelju", "onFailure=" + t.getMessage());

                }
            });


        } catch (Exception ex) {
            Log.e("Mehrdad Qabelju", "Exception= " + ex.getMessage());
        }
    }


    public void retrofit_Enginee2() {
        try {


            retrofit_api_interface request;
            Log.e("Mehrdad Qabelju", "Start Retrofit");

            String Url = "http://192.168.1.242:1363/api/Bank/NewDec/";

            request = retrofit_api_Client.getRetrofitInstance(Url).create(retrofit_api_interface.class);

            Log.e("Mehrdad Qabelju", "111");


            RequestParams rp = new RequestParams();
            rp.add("Id", "0");
            rp.add("Price", "222");
            rp.add("Title", "7777");
            rp.add("InputOutput", "0");
            rp.add("_Group", "1");
            rp.add("DatePersian_String", "1401/12/30");

            request.Post(Url, rp).enqueue(new Callback<Object>() {
                @Override
                public void onResponse(Call<Object> call, Response<Object> response) {

                    try {
                        Log.e("Mehrdad Qabelju", "Ok onResponse");
                        Log.e("Mehrdad Qabelju", "Ok onResponse = " + response);


                        Log.e("Mehrdad Qabelju", "onResponse=" + response.body().toString());
                    } catch (Exception ex) {
                        Log.e("Mehrdad Qabelju", "ErroronResponse=" + ex.getMessage());
                    }

                }

                @Override
                public void onFailure(Call<Object> call, Throwable t) {

                    Log.e("Mehrdad Qabelju", "onFailure=" + t.getMessage());

                }
            });


        } catch (Exception ex) {
            Log.e("Mehrdad Qabelju", "Exception= " + ex.getMessage());
        }
    }


    public enum Method {
        Get,
        Post
    }

    public static Object retrofit_Call_Result=null ;
    public Object retrofit_Call(Method method, String Url, RequestParams obj)
    {
        try {

            retrofit_api_interface request;


            Log.e("Mehrdad Qabelju", "Start Retrofit");

           // String Url = "http://192.168.1.242:1363/api/Bank/GetListGroup/";

            request = retrofit_api_Client.getRetrofitInstance(Url).create(retrofit_api_interface.class);

            Log.e("Mehrdad Qabelju", "111");


            Callback<Object> clo= new Callback<Object>() {
                @Override
                public void onResponse(Call<Object> call, Response<Object> response) {

                    try {
                        Log.e("Mehrdad Qabelju", "Ok onResponse");
                        Log.e("Mehrdad Qabelju", "Ok onResponse = " + response);

                        retrofit_Call_Result = response.body();


                        Log.e("Mehrdad Qabelju", "onResponse=" + response.body().toString());
                    } catch (Exception ex) {
                        Log.e("Mehrdad Qabelju", "ErroronResponse=" + ex.getMessage());
                    }

                }

                @Override
                public void onFailure(Call<Object> call, Throwable t) {

                    Log.e("Mehrdad Qabelju", "onFailure=" + t.getMessage());

                }
            };



            if (method == Method.Get)
            {
                request.Get(Url).enqueue(clo);
            }


            if (method == Method.Post)
            {
                request.Post(Url,obj).enqueue(clo);
            }

            return  retrofit_Call_Result ;
        } catch (Exception ex) {
            Log.e("Mehrdad Qabelju", "Exception= " + ex.getMessage());
            return  null;
        }

}




}