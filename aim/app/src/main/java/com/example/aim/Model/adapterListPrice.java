package com.example.aim.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aim.R;

import org.json.JSONArray;

public class adapterListPrice extends RecyclerView.Adapter<adapterListPrice.MyViewHolde>
{
Context context;
    JSONArray  jsonArray;

    public adapterListPrice(Context context, JSONArray  jsonArray){
        this.jsonArray=jsonArray;
        this.context = context;



    }

    @NonNull
    @Override
    public adapterListPrice.MyViewHolde onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.recycleview_api,parent,false);

        return new MyViewHolde (view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapterListPrice.MyViewHolde holder, int position)
    {
holder.textp.setText(position);
    }

    @Override
    public int getItemCount() {
        return jsonArray.length();
    }

    public class MyViewHolde extends  RecyclerView.ViewHolder
    {
 TextView textp;
        public MyViewHolde(@NonNull View itemView)
        {
            super(itemView);

            textp = (TextView)itemView.findViewById(R.id.price);

        }
    }
}
