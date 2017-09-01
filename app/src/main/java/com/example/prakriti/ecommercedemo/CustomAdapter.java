package com.example.prakriti.ecommercedemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;


import java.util.List;

/**
 * Created by Prakriti on 8/30/2017.
 */

class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private Context  context;
    private List<MyData> my_data;

    public CustomAdapter(Context context, List<MyData> my_data) {
        this.context = context;
        this.my_data = my_data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show();
             //   context.startActivity(new Intent(context,DetailsActivity.class));
            }
        });


        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        MyData productObject = my_data.get(position);
      //  int imageRes = getResourceId(context, productObject.getImage(), "drawable", context.getPackageName());
       // holder.imageview.setImageResource(imageRes);
        holder.name.setText(productObject.getName());
        Picasso.with(context).load(my_data.get(position).getImage()).into(holder.imageview);
       // Picasso.with(context).load("/files/my_image.jpg").into(holder.imageview);
      //  Glide.with(context).load(my_data.get(position).getImage()).into(holder.imageview);
      //Picasso.with(context).load(productObject.getImage()).into(holder.imageview);
      //  Picasso.with(context).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTPDB05lENAMmxU0hqxvthB4ClQjchd3QsFllGoFD8XDpu_RlOi").into(holder.imageview);
       // Glide.with(context).load(productObject.getImage()).into(holder.imageview);
      // Glide.with(context).load("https://images-na.ssl-images-amazon.com//images//G//01//aplusautomation//vendorimages//79ed73a8-a371-4b0d-9b52-54070bbc5b88.JPG._CB311162797_.jpg").into(holder.imageview);
    }

    @Override
    public int getItemCount() {

        return my_data.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder{
         TextView name;
         ImageView imageview;


        public ViewHolder(View itemView) {
            super(itemView);
            name =  itemView.findViewById(R.id.description);
            imageview = itemView.findViewById(R.id.imageview);

        }
    }

    public static int getResourceId(Context context, String pVariableName, String pResourcename, String pPackageName) throws RuntimeException {
        try {
            return context.getResources().getIdentifier(pVariableName, pResourcename, pPackageName);
        } catch (Exception e) {
            throw new RuntimeException("Error getting Resource ID.", e);
        }
    }


}
