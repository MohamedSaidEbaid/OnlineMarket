package com.example.onlinemarket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.onlinemarket.adapters.BannerListAdapter;
import com.example.onlinemarket.adapters.CategoriesListAdapter;
import com.example.onlinemarket.adapters.OffersListAdapter;
import com.example.onlinemarket.adapters.ProductsListAdapter;
import com.example.onlinemarket.models.Home;
import com.example.onlinemarket.network.ApiClient;
import com.example.onlinemarket.viewmodel.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getName();

    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    private RecyclerView recyclerView3;
    private RecyclerView recyclerView4;
    private MainActivityViewModel mMainActivityViewModel;

    private CategoriesListAdapter categoriesListAdapter;
    private ProductsListAdapter productsListAdapter;
    private OffersListAdapter offersListAdapter;
    private BannerListAdapter bannerListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mMainActivityViewModel.getHome();

        recyclerView1 = findViewById(R.id.recyclerView1);
        bannerListAdapter = new BannerListAdapter(this);
        recyclerView1.setHasFixedSize(true);
        LinearLayoutManager horizontalLayoutManagaer1 = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView1.setLayoutManager(horizontalLayoutManagaer1);

        recyclerView2 = findViewById(R.id.recyclerView2);
        categoriesListAdapter = new CategoriesListAdapter(this);
        recyclerView2.setHasFixedSize(true);
        LinearLayoutManager horizontalLayoutManagaer2 = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);

        recyclerView2.setLayoutManager(horizontalLayoutManagaer2);


        recyclerView3 = findViewById(R.id.recyclerView3);
        productsListAdapter = new ProductsListAdapter(this);
        recyclerView3.setHasFixedSize(true);
        LinearLayoutManager horizontalLayoutManagaer3 = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView3.setLayoutManager(horizontalLayoutManagaer3);

        recyclerView4 = findViewById(R.id.recyclerView4);
        offersListAdapter = new OffersListAdapter(this);
        recyclerView4.setHasFixedSize(true);
        LinearLayoutManager horizontalLayoutManagaer4 = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView4.setLayoutManager(horizontalLayoutManagaer4);



        mMainActivityViewModel.mHome.observe(this, new Observer<Home>(

        ) {
            @Override
            public void onChanged(Home home) {
                bannerListAdapter.setBannerList(home.getData().getBanner());
                recyclerView1.setAdapter(bannerListAdapter);

                categoriesListAdapter.setCategoryList(home.getData().getCategories());
                recyclerView2.setAdapter(categoriesListAdapter);

                productsListAdapter.setProductList(home.getData().getProducts());
                recyclerView3.setAdapter(productsListAdapter);

                offersListAdapter.setOfferList(home.getData().getOffers());
                recyclerView4.setAdapter(offersListAdapter);

            }
        });
    }
}
