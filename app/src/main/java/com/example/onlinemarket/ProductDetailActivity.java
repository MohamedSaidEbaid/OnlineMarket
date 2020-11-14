package com.example.onlinemarket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.onlinemarket.adapters.CategoriesListAdapter;
import com.example.onlinemarket.adapters.ImageListAdapter;
import com.example.onlinemarket.models.Home;
import com.example.onlinemarket.models.productmodels.ProductDetails;
import com.example.onlinemarket.viewmodel.MainActivityViewModel;

public class ProductDetailActivity extends AppCompatActivity {


    public static final String TAG = ProductDetailActivity.class.getName();

    private RecyclerView recyclerView;
    private MainActivityViewModel mMainActivityViewModel;
    private ImageListAdapter imageListAdapter;

    private TextView nameTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        Intent mIntent = getIntent();
        final int id = mIntent.getIntExtra("productId", 0);

        mMainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        mMainActivityViewModel.getProductDetails(id);

        recyclerView = findViewById(R.id.image_recycler);
        imageListAdapter = new ImageListAdapter(this);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(ProductDetailActivity.this, LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(horizontalLayoutManager);

        nameTextView = findViewById(R.id.pNameTV);

        mMainActivityViewModel.mProductDetails.observe(this, new Observer<ProductDetails>(

        ) {
            @Override
            public void onChanged(ProductDetails productDetails) {
                Log.i(TAG,"123211113331");

                Log.i(TAG,productDetails.getData().getProductInfo().getName());
//                imageListAdapter.setProductList(productDetails.getData().getProductInfo().getImages());
//                recyclerView.setAdapter(imageListAdapter);

                nameTextView.setText(productDetails.getData().getProductInfo().getName());
            }

        });
    }
}
