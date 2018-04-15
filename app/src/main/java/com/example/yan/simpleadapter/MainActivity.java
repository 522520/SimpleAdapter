package com.example.yan.simpleadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private String[] names=new String[]
            {"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    private int[] imageIds=new int[]
            {R.drawable.lion,R.drawable.tiger,R.drawable.monkey
            ,R.drawable.dog,R.drawable.cat,R.drawable.elephant};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final List<Map<String,Object>> listItems=
                new ArrayList<Map<String,Object>>();
        for(int i=0;i<names.length;i++)
        {
            Map<String,Object> listItem=new HashMap<String, Object>();
            listItem.put("header",imageIds[i]);
            listItem.put("animalName",names[i]);
            listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,listItems,
                R.layout.simple_item,new String[]{"animalName","header"},
                new int[]{R.id.animalName,R.id.header});
       final ListView list=(ListView) findViewById(R.id.myList);
        list.setAdapter(simpleAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                list.setSelector(R.color.red);
                Toast toast=Toast.makeText(MainActivity.this,names[i],Toast.LENGTH_SHORT);
                view=toast.getView();
                view.setBackgroundResource(R.color.gray);


                toast.show();
            }
        });
    }



}
