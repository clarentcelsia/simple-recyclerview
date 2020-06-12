package com.example.listfood_recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvFood;
    private ArrayList<food> list = new ArrayList<>();
    private String title = "Food List";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBar(title);
        //get the reference of recyclerView

        rvFood = findViewById(R.id.rv_Food);
        rvFood.setHasFixedSize(true);

        list.addAll(listFood.getListFood());
        showListFood();

    }

    private void showDetail(food food){

        Intent intent = new Intent(this, Detail_Activity.class); //calling detail_act

        Bundle bundle = new Bundle();
        bundle.putInt("photo" , food.getPhoto());
        bundle.putInt("detail", food.getDetail());

        intent.putExtra(Detail_Activity.name, food.getName());

//        String fprep = food.getPrep(), fcook = food.getCook(), fready = food.getReady();

//        intent.putExtra(Detail_Activity.preps, food.getPrep());
//        intent.putExtra(Detail_Activity.cooks, food.getCook());
//        intent.putExtra(Detail_Activity.ready, food.getReady());

        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void showAbout(){
        Intent intent = new Intent(MainActivity.this, activity_about.class);
        startActivity(intent);
    }

    private void showListFood() {
        rvFood.setLayoutManager(new LinearLayoutManager(this)); //bentukLayout
        CustomAdaptor listFoodAdapter = new CustomAdaptor(list);
        rvFood.setAdapter(listFoodAdapter);

        listFoodAdapter.setOnItemClickCallback(new CustomAdaptor.OnItemClickCallBack() {
            @Override
            public void onItemClicked(food data) {
                showDetail(data);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.about, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode){
        switch (selectedMode){
            case R.id.home:
                showAbout();
                break;
        }
    }

    private void setActionBar(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }
}
