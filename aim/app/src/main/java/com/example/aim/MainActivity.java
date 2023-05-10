package com.example.aim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        api_Interface.Webservice(this,"http://localhost:5018/api/Bank/GetListGroup", Request.Method.GET,null);



    }

public void Enginee()
{
    List<ItemList> bgList=new ArrayList<ItemList>();

    ItemList bg=new ItemList();
    bg.Value=1;
    bg.Text="هزینه اول";

    bgList.add(bg);

    ItemList bg2=new  ItemList();
    bg2.Value=2;
    bg2.Text="هزینه دوم";

    bgList.add(bg2);


    ItemList bg3=new  ItemList();
    bg3.Value=3;
    bg3.Text="هزینه سوم";

    bgList.add(bg3);

    Spinner spinner=new Spinner(this);

    ArrayAdapter<ItemList> dataAdapter=
            new ArrayAdapter<ItemList> (this,android.R.layout.simple_spinner_dropdown_item,bgList);
    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner.setAdapter(dataAdapter);
    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
        @Override
        public void onItemSelected(AdapterView<?>adapterView,View view,int i,long l){
            Toast.makeText(MainActivity.this,spinner.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
        }
        @Override
        public void onNothingSelected(AdapterView<?>adapterView){
            Toast.makeText(MainActivity.this,"Hello",Toast.LENGTH_SHORT).show();
        }
    });
}

    public void onclick_EnterPrice(View view)
    {
        setContentView(R.layout.enter_price);
        //Enginee();
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