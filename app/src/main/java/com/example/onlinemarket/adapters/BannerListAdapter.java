package com.example.onlinemarket.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlinemarket.R;
import com.example.onlinemarket.models.Banner;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BannerListAdapter extends  RecyclerView.Adapter<BannerListAdapter.ViewHolder>{

    private List<Banner> banners ;
    private Context context;

    public BannerListAdapter(Context context){

        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_banner,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Banner p = banners.get(position);

        Picasso.with(context).load(p.getImage()).into(holder.bannerImageView);
    }

    @Override
    public int getItemCount() {
        return banners.size();
    }

    public void setBannerList(List<Banner> bannerList){
        this.banners = bannerList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView bannerImageView;

        public ViewHolder (View itemView){
            super(itemView);
            bannerImageView = itemView.findViewById(R.id.imageBanner);
        }

    }
}
