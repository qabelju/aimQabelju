package com.example.aim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
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

import retrofit2.http.Header;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);


        //CronetEngine.Builder myBuilder = new CronetEngine.Builder(this);
        //CronetEngine cronetEngine = myBuilder.build();

        //Executor executor = Executors.newSingleThreadExecutor();

        //UrlRequest.Builder requestBuilder = cronetEngine.newUrlRequestBuilder(
               // "http://192.168.1.242:1363/api/Bank/GetListGroup", new MyUrlRequestCallback(), executor);

        //UrlRequest request = requestBuilder.build();
        //request.start();


        JSONObject json = new JSONObject();
        try{

            json.put("Id", "0");
            json.put("Price", "2222");
            json.put("Title", "2222");
            json.put("InputOutput", "0");
            json.put("_Group", "1");
            json.put("DatePersian_String", "1401/12/31");

        }
        catch (JSONException je)
        {

        }



         api_Interface.ResultWebservice resultWebservice =
         api_Interface.Webservice(this, "http://192.168.1.242:1363/api/Bank/GetListGroup", Request.Method.GET, json);

       ((TextView)findViewById(R.id.textView222)).setText(resultWebservice.ErrorMessage.toString());



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

    public void Enginee() {
        List<ItemList> bgList = new ArrayList<ItemList>();

        ItemList bg = new ItemList();
        bg.Value = 1;
        bg.Text = "هزینه اول";

        bgList.add(bg);

        ItemList bg2 = new ItemList();
        bg2.Value = 2;
        bg2.Text = "هزینه دوم";

        bgList.add(bg2);


        ItemList bg3 = new ItemList();
        bg3.Value = 3;
        bg3.Text = "هزینه سوم";

        bgList.add(bg3);

        Spinner spinner = new Spinner(this);

        ArrayAdapter<ItemList> dataAdapter =
                new ArrayAdapter<ItemList>(this, android.R.layout.simple_spinner_dropdown_item, bgList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onclick_EnterPrice(View view) {
        setContentView(R.layout.enter_price);
        //Enginee();
    }

}