package com.example.onlinemarket.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlinemarket.ProductDetailActivity;
import com.example.onlinemarket.R;
import com.example.onlinemarket.models.Offer;
import com.squareup.picasso.Picasso;

import java.util.List;

public class OffersListAdapter extends  RecyclerView.Adapter<OffersListAdapter.ViewHolder>{

    private List<Offer> offers ;
    private Context context;

    public OffersListAdapter(Context context){

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
        final Offer o = offers.get(position);
        holder.pNameTextView.setText(o.getName());
        holder.pPriceTextView.setText(o.getPrice());
        holder.pNewPriceTextView.setText(o.getPrice());
        holder.productItemCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductDetailActivity.class);
                intent.putExtra("productId", o.getId());
                context.startActivity(intent);
            }
        }
        );

        Picasso.with(context).load(o.getImage()).into(holder.pImageView);
    }

    @Override
    public int getItemCount() {
        return offers.size();
    }

    public void setOfferList(List<Offer> offerList){
        this.offers = offerList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView pNameTextView;
        private TextView pPriceTextView;
        private TextView pNewPriceTextView;
        private ImageView pImageView;
        private CardView productItemCardView;

        public ViewHolder (View itemView){
            super(itemView);
            pNameTextView = itemView.findViewById(R.id.pNameTV);
            pPriceTextView = itemView.findViewById(R.id.pPriceTV);
            pNewPriceTextView = itemView.findViewById(R.id.pNewPriceTV);
            pImageView = itemView.findViewById(R.id.pImage);
            productItemCardView = itemView.findViewById(R.id.productItemCV);
        }

    }
}
