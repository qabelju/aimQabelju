package com.example.aim.Webservice;


import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.aim.Webservice.ResultWebservice;
import com.example.aim.Webservice.Webservice;
import com.google.gson.Gson;

import org.json.JSONObject;





public class Vollay_Method
{





    public static ResultWebservice call(Webservice.MethodHttp methodHttp, String Url, JSONObject json)
    {

        /////////////////////////////////////////////
        ///////                              ////////
        ///////           var Result         ////////
        ///////                              ////////
        /////////////////////////////////////////////




        try {


            Log.e("MehrdadQabelju_WebserviceLog", "Start Volley Library");

            /////////////////////////////////////////////
            ///////                              ////////
            ///////        Type Result           ////////
            ///////                              ////////
            /////////////////////////////////////////////


            //RequestQueue queue = Volley.newRequestQueue(context);

            /////////////////////////////////////////////
            ///////                              ////////
            ///////        JsonObjectRequest     ////////
            ///////                              ////////
            /////////////////////////////////////////////



            Response.Listener<org.json.JSONObject> jsonObjectListener = new Response.Listener<org.json.JSONObject>() {


                @Override
                public void onResponse(org.json.JSONObject  response)
                {
                    try
                    {
                        Log.e("MehrdadQabelju_WebserviceLog", "onResponse = "+response.toString() );


                        Webservice.resultWebservice.ErrorCode = 0;
                        Webservice.resultWebservice.ErrorMessage = "اجرای وب سرویس با موفقیت انجام شد";
                        Webservice.resultWebservice.Result_Json =  new Gson().toJson(response );
                    }
                    catch (Exception ex)
                    {
                        Log.e("MehrdadQabelju_WebserviceLog", "onResponseException = "+ex.getMessage() );

                        Webservice.resultWebservice.ErrorCode = 1;
                        Webservice.resultWebservice.ErrorMessage = "اطلاعات در یافت شد ولی با خطا در خواندن آن";
                        Webservice.resultWebservice.Result_Json =  "";
                    }




                }
            };


            Response.ErrorListener errorListener =  new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    try {

                        Log.e("MehrdadQabelju_WebserviceLog", "onErrorResponse = "+error.getMessage() );


                        Webservice.resultWebservice.ErrorCode=2;
                        Webservice.resultWebservice.ExceptionMessage = error.getMessage();
                        Webservice.resultWebservice.ErrorMessage="خطا در  فراخوانی وب سرویس ";


                    } catch (Exception ex)
                    {

                        Log.e("MehrdadQabelju_WebserviceLog", "onErrorResponseException = "+ex.getMessage() );
                        Webservice.resultWebservice.ErrorCode=3;
                        Webservice.resultWebservice.ExceptionMessage = ex.getMessage();
                        Webservice.resultWebservice.ErrorMessage="خطا در خواندن پاسخ خطای وب سرویس";
                    }

                }
            };


            if (methodHttp == Webservice.MethodHttp.Get)
            {
                Log.e("MehrdadQabelju_WebserviceLog", "Vollay Call Get  " );
                com.android.volley.Request<org.json.JSONObject> request = new JsonObjectRequest(Request.Method.GET, Url, json, jsonObjectListener, errorListener);

                Log.e("MehrdadQabelju_WebserviceLog", "Vollay Call Getgffg  " +request.toString());
            }


            if (methodHttp == Webservice.MethodHttp.Post)
            {
                Log.e("MehrdadQabelju_WebserviceLog", "Vollay Call Post  " );
                com.android.volley.Request<org.json.JSONObject> request = new JsonObjectRequest(Request.Method.POST, Url, json, jsonObjectListener, errorListener);


            }
            //queue.add(request);


            //================================================================================
            //||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
            //================================================================================








            return Webservice.resultWebservice;


        }
        catch (Exception ex)
        {

            Log.e("MehrdadQabelju_WebserviceLog", "Vollay_Method_Exception" );
            Webservice.resultWebservice.ErrorCode=4;
            Webservice.resultWebservice.ExceptionMessage = ex.getMessage();
            Webservice.resultWebservice.ErrorMessage="خطا در اجرای کد وب سرویس";
            return Webservice.resultWebservice;
        }


    }



}



