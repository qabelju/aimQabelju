package com.example.aim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
    }



    public void onclick_EnterPrice(View view)
    {
        setContentView(R.layout.enter_price);
    }

    public void onclick_ReportList(View view)
    {
        setContentView(R.layout.enter_price);
    }

    public void onclick(View view)
    {
        setContentView(R.layout.enter_price);
    }



}