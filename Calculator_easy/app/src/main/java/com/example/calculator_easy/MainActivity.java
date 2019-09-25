package com.example.calculator_easy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    public EditText edtxt_1st;
    public EditText edtxt_2nd;
    public TextView txt_rslt;
    public Button btn_sub,btn_add;
    public Button btn_mul,btn_div,btn_adv,btn_history;
    //int a,b,c;
    double div,add,sub,mul;
   //calculatoreasy Calculator_insert;
   DatabaseReference reff;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtxt_1st=findViewById(R.id.edttxt_1);
        edtxt_2nd=findViewById(R.id.edttxt_2);
        txt_rslt=findViewById(R.id.edttxt_rslt);
        btn_add=findViewById(R.id.add_btn);
        btn_sub=findViewById(R.id.sub_btn);
        btn_mul=findViewById(R.id.mul_btn);
        btn_div=findViewById(R.id.div_btn);
        btn_adv=findViewById(R.id.adv_btn);
        btn_history=findViewById(R.id.insert_btn);
        //
         //
       // Calculator_insert.setValue1(a);
        //Calculator_insert.setValue2(b);
        reff=FirebaseDatabase.getInstance().getReference("Calculator");



        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add=Integer.valueOf(edtxt_1st.getText().toString())+Integer.parseInt(edtxt_2nd.getText().toString());
                txt_rslt.setText(String.valueOf(add));
                saveData(add);

            }

        }
        );
        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sub=Integer.valueOf(edtxt_1st.getText().toString())-Integer.parseInt(edtxt_2nd.getText().toString());
                txt_rslt.setText(String.valueOf(sub));
                saveData(sub);
            }
        }
        );


        btn_mul.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           mul=Integer.valueOf(edtxt_1st.getText().toString())*Integer.parseInt(edtxt_2nd.getText().toString());
                                           txt_rslt.setText(String.valueOf(mul));
                                           saveData(mul);
                                       }
                                   }
        );
        btn_div.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           div=Float.valueOf(edtxt_1st.getText().toString())/Float.valueOf(edtxt_2nd.getText().toString());

                                           txt_rslt.setText(String.valueOf(div));
                                           saveData(div);

                                       }
                                   }
        );
        btn_adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_advanced();
            }
        });
        btn_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,HistoryActiviity.class);
                startActivity(intent);
            }
        });







    }
    public void open_advanced()
    {
   Intent intent=new Intent(this,Calculator_part.class);
   startActivity(intent);

    }


    public void saveData(double rslt)
    {
        int a=Integer.valueOf(edtxt_1st.getText().toString());
        int b=Integer.parseInt(edtxt_2nd.getText().toString());
        calculatoreasy calc=new calculatoreasy(a,b,rslt);
        String key=reff.push().getKey();
        reff.child(key).setValue(calc);
        Toast.makeText(getApplicationContext(),"Data Added Successfully",Toast.LENGTH_LONG).show();
    }
}
