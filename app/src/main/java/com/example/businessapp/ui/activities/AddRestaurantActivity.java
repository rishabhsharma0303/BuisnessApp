package com.example.businessapp.ui.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.businessapp.R;

public class AddRestaurantActivity extends AppCompatActivity {
TextView addresturant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addrestaurant);
        addresturant=(TextView)findViewById(R.id.addrest);
        addresturant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               final String[] colors = {"INDIAN Food    >","NON INDIAN Food     >"};

                AlertDialog.Builder builder = new AlertDialog.Builder(AddRestaurantActivity.this);
                builder.setTitle("RESTAURANT TYPE");
                builder.setItems(colors, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(AddRestaurantActivity.this, MapsActivity.class);
                        startActivity(intent);
                        finish();
                        // the user clicked on colors[which]
                       /* double latitude = 40.714728;
                        double longitude = -73.998672;
                        String label = "I'm Here!";
                        String uriBegin = "geo:" + latitude + "," + longitude;
                        String query = latitude + "," + longitude + "(" + label + ")";
                        String encodedQuery = Uri.encode(query);
                        String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
                        Uri uri = Uri.parse(uriString);
                        Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, uri);
                        startActivity(mapIntent);*/

                    }
                });
                builder.show();
            }
        });
    }
}
