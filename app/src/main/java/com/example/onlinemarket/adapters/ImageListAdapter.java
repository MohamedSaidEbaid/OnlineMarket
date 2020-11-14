package com.example.onlinemarket.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlinemarket.R;
import com.example.onlinemarket.models.productmodels.Image;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ViewHolder>{

    private List<Image> images ;
    private Context context;

    public ImageListAdapter(Context context){

        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Image p = images.get(position);

        Picasso.with(context).load(p.getImage()).into(holder.pImageView);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public void setProductList(List<Image> imageList){
        this.images = imageList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView pImageView;

        public ViewHolder (View itemView){
            super(itemView);
            pImageView = itemView.findViewById(R.id.pInfoImage);
        }
    }
}

