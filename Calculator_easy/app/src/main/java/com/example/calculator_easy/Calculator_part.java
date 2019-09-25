package com.example.calculator_easy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Calculator_part extends AppCompatActivity {
public EditText edtxtt_cal_1;
public EditText edtxtt_cal_2;
public EditText edtxt_cal_rslt;
public Button btn_sine;
public Button btn_cos;
public Button btn_pow;
public Button btn_root;
int power;
int number_1;
int power_rslt;
double pi=3.1428571;
    double req_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_part);
        edtxtt_cal_1=findViewById(R.id.edtxt_cal_1);
        edtxtt_cal_2=findViewById(R.id.edtxt_cal_2);
        edtxt_cal_rslt=findViewById(R.id.edtxt_cal_rslt);
        btn_pow=findViewById(R.id.btn_pow);
        btn_root=findViewById(R.id.btn_root);
        btn_cos=findViewById(R.id.btn_cos);
        btn_sine=findViewById(R.id.btn_sine);

        btn_pow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String snum1=edtxtt_cal_1.getText().toString();
                if(snum1.isEmpty())
                {
                    Toast.makeText(Calculator_part.this,"Enter Number pls",Toast.LENGTH_SHORT).show();
                    return;

                }
                String snum2=edtxtt_cal_2.getText().toString();
                if(snum2.isEmpty())
                {
                    Toast.makeText(Calculator_part.this,"Enter Number pls",Toast.LENGTH_SHORT).show();
                    return;

                }
             power= Integer.valueOf(edtxtt_cal_2.getText().toString());
             number_1=Integer.valueOf(edtxtt_cal_1.getText().toString());
             power_rslt=1;
             for(int i=1;i<=power;i++)
             {
                power_rslt=power_rslt*number_1;
             }
             edtxt_cal_rslt.setText(String.valueOf(power_rslt));
            }
        });
        btn_sine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String snum1=edtxtt_cal_1.getText().toString();
                if(snum1.isEmpty())
                {
                    Toast.makeText(Calculator_part.this,"Enter Number pls",Toast.LENGTH_SHORT).show();
                    return;

                }
                String snum2=edtxtt_cal_2.getText().toString();
                if(snum2.isEmpty())
                {

                }
                double num1=Double.valueOf(edtxtt_cal_1.getText().toString());
                double num2=num1/180;
                num2=num2*pi;
                double value=num2-((num2*num2*num2)/6)+((num2*num2*num2*num2*num2)/120)-((num2*num2*num2*num2*num2*num2*num2)/5040);
                edtxt_cal_rslt.setText(String.valueOf(value));
            }
        });
        btn_cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String snum1=edtxtt_cal_1.getText().toString();
                if(snum1.isEmpty())
                {
                    Toast.makeText(Calculator_part.this,"Enter Number pls",Toast.LENGTH_SHORT).show();
                    return;

                }
                String snum2=edtxtt_cal_2.getText().toString();
                if(snum2.isEmpty())
                {

                }
                double num1=Double.valueOf(edtxtt_cal_1.getText().toString());
                double num2=num1/180;
                num2=num2*pi;
                double value=num2-((num2*num2)/2)+((num2*num2*num2*num2)/24)-((num2*num2*num2*num2*num2*num2)/720);
                edtxt_cal_rslt.setText(String.valueOf(value));

            }
        });

        btn_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String snum1=edtxtt_cal_1.getText().toString();
                if(snum1.isEmpty())
                {
                    Toast.makeText(Calculator_part.this,"Enter Number pls",Toast.LENGTH_SHORT).show();
                    return;

                }


                int n1=Integer.valueOf(edtxtt_cal_1.getText().toString());
                String snum2=edtxtt_cal_2.getText().toString();

                if(snum2.isEmpty())
                {

                }

                int i;
                for( i=1;i<n1;i++)
                {
                    if((n1 >= (i * i)) && (n1 < ((i + 1) * (i + 1))))
                    {
                        req_num=Double.valueOf(String.valueOf(i));
                        break;
                    }
                }
               double d=Double.valueOf(String.valueOf(n1-i*i));
                double sq_root=req_num*(1+ d/(2*(req_num*req_num))-(d*d/(8*req_num*req_num*req_num*req_num))+(d*d*d/(16*req_num*req_num*req_num*req_num*req_num*req_num)));

                edtxt_cal_rslt.setText(String.valueOf(sq_root));

            }
        });




    }
}
