package com.example.dacs3.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dacs3.Activity.ShowDetailActivity;
import com.example.dacs3.Domain.CategoryDomain;
import com.example.dacs3.Domain.FoodDomain;
import com.example.dacs3.R;

import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    Context context;
    List< FoodDomain > arrayFood;

    public FoodAdapter(Context context, List<FoodDomain> arrayFood) {
        this.context = context;
        this.arrayFood = arrayFood;
    }

    @NonNull
    @Override
    public FoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_recommended,parent,false);
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.viewholder_recommended,parent,false);
        FoodAdapter.ViewHolder viewHolder = new FoodAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FoodDomain foodDomain=arrayFood.get(position);
        holder.namefood.setText(foodDomain.getName_food());
        holder.price.setText(foodDomain.getPrice_food());
        Glide.with(context).load(foodDomain.getImage_food()).into(holder.imgfood);
        Glide.with(context).load(foodDomain.getImgAdd_food()).into(holder.addBtn);
//        holder.addBtn.setOnClickListener(v -> {
//            Intent intent = new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
//            intent.putExtra("object", FoodDomain.get(position));
//            holder.itemView.getContext().startActivity(intent);
//        });

    }

    @Override
    public int getItemCount() {
        return arrayFood.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView namefood,price;
        ImageView imgfood;
        ImageView addBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            price= itemView.findViewById(R.id.price);
            namefood = itemView.findViewById(R.id.namefood);
            imgfood = itemView.findViewById(R.id.imgfood);
            addBtn = itemView.findViewById(R.id.addBtn);
        }
    }
}
