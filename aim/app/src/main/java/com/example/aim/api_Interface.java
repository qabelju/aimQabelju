package com.example.aim;
import android.media.Image;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class api_Interface
{


    public class ResultWebservice
    {
        public int ErrorCode ;
        public String ErrorMessage;
        public String ExceptionMessage;
        public String Result_Json;

    }


    public static ResultWebservice Webservice(android.content.Context context, String url, int method, JSONObject json)
    {

        /////////////////////////////////////////////
        ///////                              ////////
        ///////           var Result         ////////
        ///////                              ////////
        /////////////////////////////////////////////



        final String[] StringResult = {""};
        final JSONObject[] jsonResult = {new JSONObject()};

        final ResultWebservice resultWebservice = null;

        try {

            /////////////////////////////////////////////
            ///////                              ////////
            ///////        Type Result           ////////
            ///////                              ////////
            /////////////////////////////////////////////


            RequestQueue queue = Volley.newRequestQueue(context);

            /////////////////////////////////////////////
            ///////                              ////////
            ///////        JsonObjectRequest     ////////
            ///////                              ////////
            /////////////////////////////////////////////




                JsonObjectRequest request = new JsonObjectRequest(method, url, json, new Response.Listener<JSONObject>() {


                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            resultWebservice.ErrorCode = 0;
                            resultWebservice.ErrorMessage = "اجرای وب سرویس با موفقیت انجام شد";
                           resultWebservice.Result_Json =  new Gson().toJson(response );

                        } catch (Exception ex) {
                            resultWebservice.ErrorCode = 1;
                            resultWebservice.ExceptionMessage = ex.getMessage();
                            resultWebservice.ErrorMessage = "خطا در پاسخ دریافتی از وب سرویس";
                        }


                    }
                },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                                try {

                                    resultWebservice.ErrorCode=2;
                                    resultWebservice.ExceptionMessage = error.getMessage();
                                    resultWebservice.ErrorMessage="خطا در  فراخوانی وب سرویس ";


                                } catch (Exception ex) {
                                    resultWebservice.ErrorCode=3;
                                    resultWebservice.ExceptionMessage = ex.getMessage();
                                    resultWebservice.ErrorMessage="خطا در تحلیل خطای وب سرویس ";
                                }

                            }
                        });

                queue.add(request);


            //================================================================================
            //||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
            //================================================================================








            return resultWebservice;


        }
        catch (Exception ex)
        {
            resultWebservice.ErrorCode=4;
            resultWebservice.ExceptionMessage = ex.getMessage();
            resultWebservice.ErrorMessage="خطا در اجرای کد وب سرویس";
            return resultWebservice;
        }


    }



}



