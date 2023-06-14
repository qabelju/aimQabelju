package com.example.aim.Model;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aim.R;

import org.json.JSONArray;
import org.json.JSONException;

public class adapterRecyclerView extends RecyclerView.Adapter<adapterRecyclerView.ViewHolder>
{
    private Context context;
    private  JSONArray  jsonArray;
    public adapterRecyclerView(Context context, JSONArray  jsonArray)
    {
        Log.e("MehrdadQabelju_WebserviceLog", "adapterRecyclerView = ");
        this.jsonArray=jsonArray;
        this.context = context;
    }

    @NonNull
    @Override
    public adapterRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        Log.e("MehrdadQabelju_WebserviceLog", "onCreateViewHolder ");
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.recycleview_api, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( adapterRecyclerView.ViewHolder holder, int position)
    {
        try {

            Log.e("MehrdadQabelju_WebserviceLog", "onBindViewHolder = "+jsonArray.getJSONObject(position).getString("Price"));

            String resgg= jsonArray.getJSONObject(position).getString("Price");
            holder.textprice.setText(resgg.toString());
            holder.textprice.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),"click on item: "+resgg,Toast.LENGTH_LONG).show();
                }
            });

        } catch (JSONException e) {

        }
    }

    @Override
    public int getItemCount() {

        Log.e("MehrdadQabelju_WebserviceLog", "getItemCount = "+jsonArray.length());
        return jsonArray.length();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public    TextView textprice;
        public ViewHolder(View itemView)
        {

            super(itemView);
            Log.e("MehrdadQabelju_WebserviceLog", "ViewHolder  ");

            textprice = (TextView)itemView.findViewById(R.id.price);

        }
    }
}
