package com.example.businessapp.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.businessapp.R;

import java.util.ArrayList;

public class BrandActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    CheckBox idli_dosa, noodles, chole_bhature, yellow_chilli, tandori_platter;
    ArrayList<String> brands;
    Button done;
    TextView tv1, tv2, tv3, tv4, tv5;
    ArrayList<String> StringArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand);
        idli_dosa = (CheckBox) findViewById(R.id.idli);
        noodles = (CheckBox) findViewById(R.id.noodles);
        chole_bhature = (CheckBox) findViewById(R.id.chole);
        yellow_chilli = (CheckBox) findViewById(R.id.yellow_chilli);
        done = (Button) findViewById(R.id.done);
        tandori_platter = (CheckBox) findViewById(R.id.tandori_platters);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv5 = (TextView) findViewById(R.id.tv5);
        brands = new ArrayList<>();
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BrandActivity.this, ProfileActivity.class));
            }
        });

//
//    idli_dosa.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            String tx=idli_dosa.getText().toString();
//            brands.add(tx);
//        }
//    });
//    yellow_chilli.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            String txt=yellow_chilli.getText().toString();
//            brands.add(txt);
//        }
//    });
//        noodles.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String txttt=noodles.getText().toString();
//                brands.add(txttt);
//            }
//        });
//       chole_bhature.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String txtt=chole_bhature.getText().toString();
//                brands.add(txtt);
//            }
//        });
//        tandori_platter.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                    String txt=tandori_platter.getText().toString();
//                    brands.add(txt);
//
//
//            }
//        });
//
//
//done.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//        /*tv1.setText(brands.get(0));
//        tv2.setText(brands.get(1));
//        tv3.setText(brands.get(2));
//        tv4.setText(brands.get(3));
//        tv5.setText(brands.get(4));*/
//        if (idli_dosa.isChecked())
//        {
//            tv1.setText(brands.get(0));
//           // idli_dosa.setEnabled(false);
//        }
//
//        if (yellow_chilli.isChecked())
//        {
//            tv2.setText(brands.get(1));
//           // yellow_chilli.setEnabled(false);
//        }
//
//        if (noodles.isChecked())
//        {
//            tv3.setText(brands.get(2));
//          //  noodles.setEnabled(false);
//        }
//
//        if (chole_bhature.isChecked())
//        {
//            tv4.setText(brands.get(3));
//           // chole_bhature.setEnabled(false);
//        }
//
//        if (tandori_platter.isChecked())
//        {
//            tv5.setText(brands.get(4));
//         //   tandori_platter.setEnabled(false);
//        }
//
//        //if(idli_dosa.requestFocus())
//
//
//
//    }
//});

        idli_dosa.setOnCheckedChangeListener(this);
        yellow_chilli.setOnCheckedChangeListener(this);
        noodles.setOnCheckedChangeListener(this);
        chole_bhature.setOnCheckedChangeListener(this);
        tandori_platter.setOnCheckedChangeListener(this);

    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            StringArray.add("" + buttonView.getText().toString());
        } else {
            StringArray.remove(StringArray.indexOf(buttonView.getText().toString()));
        }
        setText();
    }

    private void setText() {
        tv1.setText("");
        for (int i = 0; i < StringArray.size(); i++) {
            tv1.append(StringArray.get(i));
            tv1.append(",");

        }
    }
}

