package com.example.businessapp.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CondtionActivity extends AppCompatActivity {
DatabaseReference mref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mref=FirebaseDatabase.getInstance().getReference("Profile_data");
        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
//                    String name_show= dataSnapshot.child("User").child("userName").getValue(String.class);
//                    String buisness_show=  dataSnapshot.child("User").child("shopName").getValue(String.class);
//                    String area_name_show=  dataSnapshot.child("User").child("area_name").getValue(String.class);
//                    String contact_show=  dataSnapshot.child("User").child("contact_number").getValue(String.class);
//                    Intent i=new Intent(CondtionActivity.this,ShowProfileActivity.class);
//                    i.putExtra("name",name_show);
//                    i.putExtra("buisness",buisness_show);
//                    i.putExtra("area",area_name_show);
//                    i.putExtra("contact",contact_show);
//                    startActivity(i);
                  startActivity(new Intent(CondtionActivity.this,ShowProfileActivity.class));
                }else
                {

                    startActivity(new Intent(CondtionActivity.this,AddRestaurantActivity.class));

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
