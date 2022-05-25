package com.example.dacs3.retrofit;

import com.example.dacs3.Domain.CategoryModel;
import com.example.dacs3.Domain.FoodModel;

import io.reactivex.rxjava3.core.Observable;
        import retrofit2.http.GET;

public interface ApiAppfood {
    @GET("getloaisp.php")
    Observable<CategoryModel> getListCategory();
    @GET("getrecoment.php")
    Observable< FoodModel > getListFood();
}
