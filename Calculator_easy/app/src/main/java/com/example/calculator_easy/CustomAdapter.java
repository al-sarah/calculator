package com.example.calculator_easy;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<calculatoreasy> {
    private Activity context;
    private List<calculatoreasy> calclist;

    public CustomAdapter(Activity context,List<calculatoreasy> calclist) {
        super(context, R.layout.sample_layout, calclist);
        this.context = context;
        this.calclist = calclist;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=context.getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.sample_layout,null,true);
        calculatoreasy calc=calclist.get(position);
        TextView t1=view.findViewById(R.id.Value1id);
        TextView t2=view.findViewById(R.id.Value2id);
        TextView t3=view.findViewById(R.id.resultid);
        t1.setText("Value1: "+calc.getValue1());
        t2.setText("Value2: "+calc.getValue2());
        t3.setText("Result:"+calc.getResult1());

        return view;
    }
}
