package com.example.aim;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class api_Interface {


    public static JSONObject Webservice(android.content.Context context, String url, int method, JSONObject json)
    {
        /////////////////////////////////////////////
        ///////                              ////////
        //////////  پاسخ وب سرویس در موارد خطا  /////
        ///////                              ////////
        /////////////////////////////////////////////

        final JSONObject[] jsonResult = {new JSONObject()};




            RequestQueue queue = Volley.newRequestQueue(context);



            JsonObjectRequest request = new JsonObjectRequest(method, url, json, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {

                    jsonResult[0] = response;


                }
            },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            try {
                                jsonResult[0].put("message", "خطا در فراخوانی وب سرویس");
                                jsonResult[0].put("exception", error.getMessage());
                            } catch (JSONException ex) {

                            }

                        }
                    });
            queue.add(request);

            return jsonResult[0];



    }
}



