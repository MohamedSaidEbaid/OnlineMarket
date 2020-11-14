package com.example.onlinemarket.viewmodel;

import android.nfc.Tag;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.onlinemarket.models.Home;
import com.example.onlinemarket.models.productmodels.ProductDetails;
import com.example.onlinemarket.network.ApiClient;
import com.example.onlinemarket.network.OnlineMarketApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends ViewModel {

    public MutableLiveData<Home> mHome = new MutableLiveData<>();
    public MutableLiveData<ProductDetails> mProductDetails = new MutableLiveData<>();

    public void getHome() {

        ApiClient.getClient().create(OnlineMarketApiService.class).getProducts().enqueue(new Callback<Home>() {
            @Override
            public void onResponse(Call<Home> call, Response<Home> response) {
                Log.d("TAG", "onResponse: " + response.body());
                mHome.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Home> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void getProductDetails(int id) {

        ApiClient.getClient().create(OnlineMarketApiService.class).getProductDetail(id).enqueue(new Callback<ProductDetails>() {
            @Override
            public void onResponse(Call<ProductDetails> call, Response<ProductDetails> response) {
                Log.i("ProductDetails",response.body().toString());
                mProductDetails.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ProductDetails> call, Throwable t) {

            }


        });
    }
}
