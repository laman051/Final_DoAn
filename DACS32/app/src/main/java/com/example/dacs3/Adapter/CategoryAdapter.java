package com.example.dacs3.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.dacs3.Activity.PizzaActivity;
import com.example.dacs3.Domain.CategoryDomain;
import com.example.dacs3.R;

import java.util.List;

import static android.content.Context.*;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder>  {
    Context context;
    List<CategoryDomain> arrayCate;


    public CategoryAdapter(Context context, List< CategoryDomain > arrayCate) {
        this.context = context;
        this.arrayCate = arrayCate;
    }

    // chay dau
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_catefory,parent,false);
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.view_catefory,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    //chay 3
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CategoryDomain categoryDomain=arrayCate.get(position);
        holder.namecate.setText(categoryDomain.getName_cate());
//        Picasso.with(context).load(categoryDomain.getImage_cate()).into(holder.imgcate);
     Glide.with(context).load(categoryDomain.getImage_cate()).into(holder.imgcate);
holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
//            Log.d("Click",categoryDomain.getId_cate()+"-"+ categoryDomain.getName_cate());
        Intent intent = new Intent(context, PizzaActivity.class);
        intent.putExtra("id_cate",categoryDomain.getId_cate());
        intent.putExtra("name_cate",categoryDomain.getName_cate());
        context.startActivity(intent);
    }
});


    }

    @Override
    public int getItemCount() {
        return arrayCate.size();
    }



    // chay 2
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView namecate;
        ImageView imgcate;
        ConstraintLayout constraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            constraintLayout=itemView.findViewById(R.id.layout_item);
            namecate = itemView.findViewById(R.id.item_name_cate);
            imgcate = itemView.findViewById(R.id.item_image_cate);

        }
    }

}
