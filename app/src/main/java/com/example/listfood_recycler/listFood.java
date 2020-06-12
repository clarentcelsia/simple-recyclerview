package com.example.listfood_recycler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class listFood extends AppCompatActivity {

    private static String[] name = {
            "Panna Cotta",
            "Cookies",
            "Bread",
            "Ice Cream",
            "Salad",
            "Pie",
            "Cream",
            "Chocolate",
            "Cake",
            "Gelato"
    };

    private static int[] images = {
            R.drawable.pudding
            , R.drawable.cookies
            , R.drawable.bread
            , R.drawable.icecream
            , R.drawable.salad
            , R.drawable.pie
            , R.drawable.cream
            , R.drawable.choco
            , R.drawable.cake
            , R.drawable.gelato
    };

    private static int[] detail = {
            R.string.pudding,
            R.string.cookies,
            R.string.bread,
            R.string.icecream,
            R.string.salad,
            R.string.pie,
            R.string.cream,
            R.string.choco,
            R.string.cake,
            R.string.gelato
    };


    static ArrayList<food> getListFood(){
        ArrayList<food> list = new ArrayList<>();
        for (int i = 0; i < name.length; i++){
            food food = new food();
            food.setName(name[i]);
            food.setDetail(detail[i]);
            food.setPhoto(images[i]);

            list.add(food);
        }
        return list;
    }


}
