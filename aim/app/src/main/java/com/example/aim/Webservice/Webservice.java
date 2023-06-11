package com.example.aim.Webservice;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.aim.ItemList;
import com.example.aim.MainActivity;
import com.example.aim.Model.bank_group;
import com.example.aim.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

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

    public static ResultWebservice Call(VarLibrary varLibrary, MethodHttp methodHttp, String Url, JSONObject json, Context context)
    {
        try
        {
            Log.e("MehrdadQabelju_WebserviceLog", "Start Call Webservice");
            if (varLibrary == VarLibrary.Volley)
            {
                Log.e("MehrdadQabelju_WebserviceLog", "Call Volley Library");

                return  Vollay_Method.call(methodHttp,Url,json,context);

            }

            return resultWebservice;
        }
        catch (Exception ex)
        {
            Log.e("MehrdadQabelju_WebserviceLog", "Exception= " + ex.getMessage());
            return resultWebservice;
        }
    }

    public static void GetList_GroupBank(Context context)
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


            RequestQueue queue = Volley.newRequestQueue(context);

            /////////////////////////////////////////////
            ///////                              ////////
            ///////        JsonObjectRequest     ////////
            ///////                              ////////
            /////////////////////////////////////////////


            final List<bank_group> listarr = null;

            Response.Listener<org.json.JSONArray> jsonObjectListener = new Response.Listener<org.json.JSONArray>() {


                @Override
                public void onResponse(org.json.JSONArray  response)
                {
                    try
                    {
                        Log.e("MehrdadQabelju_WebserviceLog", "TTTonResponse = "+response.toString() );



                        Activity activity = (Activity) context;

                        Spinner spinner =  (Spinner)(activity.findViewById(R.id.planets_spinner));


                        List<ItemList> bgList = new ArrayList<ItemList>();

                        for (int i = 0; i < response.length(); i++)
                        {
                            JSONObject jsonobject = response.getJSONObject(i);

                            ItemList bg = new ItemList();
                            bg.Value = jsonobject.getInt("value");
                            bg.Text =  jsonobject.getString("text");
                            bgList.add(bg);

                        }

                        ArrayAdapter<ItemList> dataAdapter =
                                new ArrayAdapter<ItemList>(context, android.R.layout.simple_spinner_dropdown_item, bgList);
                        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner.setAdapter(dataAdapter);
                        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                Toast.makeText(context, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {
                                Toast.makeText(context, "Hello", Toast.LENGTH_SHORT).show();
                            }
                        });


                    }
                    catch (Exception ex)
                    {
                        Log.e("MehrdadQabelju_WebserviceLog", "onResponseException = "+ex.getMessage() );

                        Toast.makeText(context, "اطلاعات در یافت شد ولی با خطا در خواندن آن", Toast.LENGTH_SHORT).show();

                    }




                }
            };


            Response.ErrorListener errorListener =  new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    try {

                        Log.e("MehrdadQabelju_WebserviceLog", "onErrorResponse = "+error.getMessage() );

                        Toast.makeText(context, "خطا در  فراخوانی وب سرویس ", Toast.LENGTH_SHORT).show();



                    } catch (Exception ex)
                    {

                        Log.e("MehrdadQabelju_WebserviceLog", "onErrorResponseException = "+ex.getMessage() );

                        Toast.makeText(context, "خطا در خواندن پاسخ خطای وب سرویس", Toast.LENGTH_SHORT).show();


                    }

                }
            };


            String Url = "http://192.168.1.242:1363/api/Bank/GetListGroup";

                Log.e("MehrdadQabelju_WebserviceLog", "Vollay Call Get Start  " );
                com.android.volley.Request<org.json.JSONArray> request = new JsonArrayRequest(Request.Method.GET, Url, null, jsonObjectListener, errorListener);

                Log.e("MehrdadQabelju_WebserviceLog", "Vollay Call Get End  ");
                queue.add(request);





            //================================================================================
            //||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
            //================================================================================








            return ;


        }
        catch (Exception ex)
        {

            Log.e("MehrdadQabelju_WebserviceLog", "Vollay_Method_Exception" );
            Webservice.resultWebservice.ErrorCode=4;
            Webservice.resultWebservice.ExceptionMessage = ex.getMessage();
            Webservice.resultWebservice.ErrorMessage="خطا در اجرای کد وب سرویس";
            return ;
        }

    }

    public static void SendEnterPrice(Context context,)
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


            RequestQueue queue = Volley.newRequestQueue(context);

            /////////////////////////////////////////////
            ///////                              ////////
            ///////        JsonObjectRequest     ////////
            ///////                              ////////
            /////////////////////////////////////////////


            final List<bank_group> listarr = null;

            Response.Listener<org.json.JSONArray> jsonObjectListener = new Response.Listener<org.json.JSONArray>() {


                @Override
                public void onResponse(org.json.JSONArray  response)
                {
                    try
                    {
                        Log.e("MehrdadQabelju_WebserviceLog", "TTTonResponse = "+response.toString() );



                        Activity activity = (Activity) context;


                        try{

                            JSONObject json = new JSONObject();
                            json.put("Id", ((Spinner)(activity.findViewById(R.id.planets_spinner))).getSelectedItemId());
                            json.put("Price",Integer. parseInt(((EditText)(activity.findViewById(R.id.priceEditText))).getText()));
                            json.put("Title", "7777");
                            json.put("InputOutput", "0");
                            json.put("_Group", "1");
                            json.put("DatePersian_String", "1401/12/31");

                        }
                        catch (JSONException je)
                        {

                        }


                         =  ((Spinner)(activity.findViewById(R.id.planets_spinner))).getSelectedItemId();




                    }
                    catch (Exception ex)
                    {
                        Log.e("MehrdadQabelju_WebserviceLog", "onResponseException = "+ex.getMessage() );

                        Toast.makeText(context, "اطلاعات در یافت شد ولی با خطا در خواندن آن", Toast.LENGTH_SHORT).show();

                    }




                }
            };


            Response.ErrorListener errorListener =  new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    try {

                        Log.e("MehrdadQabelju_WebserviceLog", "onErrorResponse = "+error.getMessage() );

                        Toast.makeText(context, "خطا در  فراخوانی وب سرویس ", Toast.LENGTH_SHORT).show();



                    } catch (Exception ex)
                    {

                        Log.e("MehrdadQabelju_WebserviceLog", "onErrorResponseException = "+ex.getMessage() );

                        Toast.makeText(context, "خطا در خواندن پاسخ خطای وب سرویس", Toast.LENGTH_SHORT).show();


                    }

                }
            };


            String Url = "http://192.168.1.242:1363/api/Bank/GetListGroup";

            Log.e("MehrdadQabelju_WebserviceLog", "Vollay Call Get Start  " );
            com.android.volley.Request<org.json.JSONArray> request = new JsonArrayRequest(Request.Method.GET, Url, null, jsonObjectListener, errorListener);

            Log.e("MehrdadQabelju_WebserviceLog", "Vollay Call Get End  ");
            queue.add(request);





            //================================================================================
            //||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
            //================================================================================








            return ;


        }
        catch (Exception ex)
        {

            Log.e("MehrdadQabelju_WebserviceLog", "Vollay_Method_Exception" );
            Webservice.resultWebservice.ErrorCode=4;
            Webservice.resultWebservice.ExceptionMessage = ex.getMessage();
            Webservice.resultWebservice.ErrorMessage="خطا در اجرای کد وب سرویس";
            return ;
        }

    }
}
