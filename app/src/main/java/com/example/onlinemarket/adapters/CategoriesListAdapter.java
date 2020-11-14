package com.example.onlinemarket.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlinemarket.R;
import com.example.onlinemarket.models.Category;

import java.util.List;


public class CategoriesListAdapter  extends  RecyclerView.Adapter<CategoriesListAdapter.ViewHolder>{

    private List<Category> categories ;
    private Context context;

    public CategoriesListAdapter(Context context){

        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category p = categories.get(position);
        holder.categoryTextView.setText(p.getName());

//        Picasso.with(context).load("https://www.pngonly.com/wp-content/uploads/2017/06/hd-pokemon-png-10203.png").into(holder.photoImageView);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public void setCategoryList(List<Category> categoryList){
        this.categories = categoryList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView categoryTextView;

        public ViewHolder (View itemView){
            super(itemView);
            categoryTextView = itemView.findViewById(R.id.categoryTV);
        }

    }
}
