package com.example.listfood_recycler;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Detail_Activity extends AppCompatActivity {
    public static final String name = "nama";
    public static String preps, cooks , ready ;
    //public static final String details = "detail";

    TextView tvNama, tvDetail, tvPreps, tvCooks, tvReady;
    ImageView imgPhoto;
    String name2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imgPhoto = findViewById(R.id.img_photos);
        tvNama = findViewById(R.id.tv_names);
        tvDetail = findViewById(R.id.tv_details);
        tvPreps = findViewById(R.id.tv_preps);
        tvCooks = findViewById(R.id.tv_cooks);
        tvReady = findViewById(R.id.tv_ready);

        name2 = getIntent().getStringExtra(name);

        Bundle bundle = this.getIntent().getExtras();
        int photo = bundle.getInt("photo");
        int detail2 = bundle.getInt("detail");

        Toast.makeText(this, String.valueOf(detail2), Toast.LENGTH_SHORT).show();
        showPreps();
        imgPhoto.setImageResource(photo);
        tvNama.setText(name2);
        tvDetail.setText(detail2);
        tvPreps.setText(preps);
        tvCooks.setText(cooks);
        tvReady.setText(ready);


    }

       public void showPreps(){
           if(name2.equalsIgnoreCase("Panna Cotta")){
               preps = "5 Min";
               cooks = "10 Min";
               ready = "4H 15 Min";
           }else if(name2.equalsIgnoreCase("Cookies")){
               preps = "30 Min";
               cooks = "10 Min";
               ready = "40 Min";
           }else if(name2.equalsIgnoreCase("Bread")){
               preps = "20 Min";
               cooks = "30 Min";
               ready = "3 Min";
           }else if(name2.equalsIgnoreCase("Ice Cream")){
               preps = "10 Min";
               cooks = "45 Min";
               ready = "55 Min";
           }else if(name2.equalsIgnoreCase("Salad")){
               preps = "15 Min";
               cooks = "15 Min";
               ready = "30 Min";
           }else if(name2.equalsIgnoreCase("Pie")){
               preps = "30 Min";
               cooks = "1H";
               ready = "1H 30 Min";
           }else if(name2.equalsIgnoreCase("Cream")){
               preps = "5 Min";
               cooks = "5 Min";
               ready = "10 Min";
           }else if(name2.equalsIgnoreCase("Chocolate")){
               preps = "10 Min";
               cooks = "1H ";
               ready = "1H 10 Min";
           }else if(name2.equalsIgnoreCase("cake")){
               preps = "15 Min";
               cooks = "45 Min";
               ready = "1H";
           }else if(name2.equalsIgnoreCase("gelato")){
               preps = "10 Min";
               cooks = "15 Min";
               ready = "3H";
           }else{
               preps = cooks = ready = null;
           }


       }
    }

