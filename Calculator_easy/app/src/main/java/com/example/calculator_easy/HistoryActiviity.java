package com.example.calculator_easy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HistoryActiviity extends AppCompatActivity {
private ListView listView;

DatabaseReference databaseReference;
    private List<calculatoreasy> calclist;
private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_activiity);
        databaseReference= FirebaseDatabase.getInstance().getReference("Calculator");
        calclist=new ArrayList<>();
        customAdapter=new CustomAdapter(HistoryActiviity.this,calclist);
        listView=findViewById(R.id.ListViewid);
    }

    @Override
    protected void onStart() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                calclist.clear();
                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                 calculatoreasy calc=dataSnapshot1.getValue(calculatoreasy.class);
                 calclist.add(calc);

                }
                listView.setAdapter(customAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        super.onStart();
    }
}
