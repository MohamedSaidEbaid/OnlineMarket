package com.example.onlinemarket.network;

import com.example.onlinemarket.models.Home;
import com.example.onlinemarket.models.productmodels.ProductDetails;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface OnlineMarketApiService {

    @GET("home")
    Call<Home> getProducts();

    @GET("product/{id}")
    Call<ProductDetails> getProductDetail(@Path("id") int groupId);


}
