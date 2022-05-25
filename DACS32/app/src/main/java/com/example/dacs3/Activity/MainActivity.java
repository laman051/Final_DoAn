package com.example.dacs3.Activity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dacs3.Adapter.CategoryAdapter;
import com.example.dacs3.Adapter.FoodAdapter;
import com.example.dacs3.Domain.CategoryDomain;
import com.example.dacs3.Domain.CategoryModel;
import com.example.dacs3.Domain.FoodDomain;
import com.example.dacs3.R;
import com.example.dacs3.retrofit.ApiAppfood;
import com.example.dacs3.retrofit.RetrofitClient;
import com.example.dacs3.util.Utils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    RecyclerView.Adapter adapter,adapter2;
    RecyclerView recyclerViewCate,recyclerViewFood;
    CategoryAdapter categoryAdapter;
    List<CategoryDomain>  categoryDomainList;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    ApiAppfood apiAppfood;
    List< FoodDomain>  foodDomainList;
    FoodAdapter foodAdapter;
    ConstraintLayout constraintLayout;
    ImageView addBtn;

//    List< CategoryModel >  categoryModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiAppfood = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiAppfood.class);
        Category();
        Food();
        if (isConnect(this)){
            getListCategory();
            getListFood();
            getEventClick();
        } else {
            Toast.makeText(getApplicationContext(),"ko có internet",Toast.LENGTH_LONG).show();
        }
    }

    private void getEventClick() {
     

//                    recyclerViewCate.setOnClickListener( (adapterView,view,  i,  l) -> {
//     switch (i){
//                            case 0:
//                    Intent pizza = new Intent(getApplicationContext(),PizzaActivity.class);
//                    startActivity(pizza);
//                    break;
//                case 1:
//                    Intent burger = new Intent(getApplicationContext(),BurgerActivity.class);
//                    startActivity(burger);
//                    break;
//                case 2:
//                    Intent drink = new Intent(getApplicationContext(),DrinkActivity.class);
//                    startActivity(drink);
//                    break;
//            }
//        });
//        recyclerViewCate.setOnClickListener(new AdapterView.OnItemClickListener(){
//
//            @Override
//        public void onItemClick(AdapterView< ? > adapterView, View view, int i, long l) {
//            switch (i){
//                case 0:
//                    Intent pizza = new Intent(getApplicationContext(),PizzaActivity.class);
//                    startActivity(pizza);
//                    break;
//                case 1:
//                    Intent burger = new Intent(getApplicationContext(),BurgerActivity.class);
//                    startActivity(burger);
//                    break;
//                case 2:
//                    Intent drink = new Intent(getApplicationContext(),DrinkActivity.class);
//                    startActivity(drink);
//                    break;
//            }
//        }
//    });
}

    private void getListFood() {
        compositeDisposable.add(apiAppfood.getListFood()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        foodModel -> {
                            if (foodModel.isSuccess()){
                                foodDomainList = foodModel.getListfood();
                                //tao adapter
                                foodAdapter  =  new FoodAdapter(getApplicationContext(),foodDomainList);
                                recyclerViewFood.setAdapter(foodAdapter);
                            }

                        },
                        throwable -> {
                            Toast.makeText(getApplicationContext(),"ko keets noois toi sever"+throwable.getMessage(),Toast.LENGTH_LONG).show();
                        }
                ));
    }
    private void getListCategory() {
        compositeDisposable.add(apiAppfood.getListCategory()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        categoryModel -> {
                            if (categoryModel.isSuccess()){
                                categoryDomainList = categoryModel.getListcategory();
                                //tao adapter
                                categoryAdapter  =  new CategoryAdapter(getApplicationContext(),categoryDomainList);
                                recyclerViewCate.setAdapter(categoryAdapter);
                            }
                        },
                        throwable -> {
                            Toast.makeText(getApplicationContext(),"không kết nối được với sever"+throwable.getMessage(),Toast.LENGTH_LONG).show();
                        }
                ));

    }


    private void Category() {
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCate = findViewById(R.id.view1);
        RecyclerView.LayoutManager layoutManager= new GridLayoutManager(this,2);
        recyclerViewCate.setLayoutManager(layoutManager);
        recyclerViewCate.setLayoutManager(linearLayoutManager);
        recyclerViewCate.setHasFixedSize(true);
        // tao list
    categoryDomainList = new ArrayList<>();
    }
        private void Food() {
            LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
            recyclerViewFood = findViewById(R.id.view2);
            RecyclerView.LayoutManager layoutManager= new GridLayoutManager(this,2);
            recyclerViewFood .setLayoutManager(linearLayoutManager);
            recyclerViewFood .setHasFixedSize(true);
        // tao list
        foodDomainList= new ArrayList<>();

    }




    private boolean isConnect (Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi =connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobile =connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if ((wifi != null && wifi.isConnected())|| (mobile!=null && mobile.isConnected())){
            return true;
        }else {
            return false;
        }
    }

}