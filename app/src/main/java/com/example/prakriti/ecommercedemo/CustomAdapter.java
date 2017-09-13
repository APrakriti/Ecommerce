package com.example.prakriti.ecommercedemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private Context context;
    private List<MyData> my_data;


    public CustomAdapter(Context context, List<MyData> my_data) {
        this.context = context;
        this.my_data = my_data;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);


        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        MyData productObject = my_data.get(position);
        //  int imageRes = getResourceId(context, productObject.getImage(), "drawable", context.getPackageName());
        // holder.imageview.setImageResource(imageRes);
        holder.name1.setText(productObject.getName());
        holder.description1.setText(productObject.getDescription());


    }

    @Override
    public int getItemCount() {

        return my_data.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name1,description1;
        ImageView imageview1;


        public ViewHolder(View itemV) {
            super(itemV);
            name1 = (TextView) itemV.findViewById(R.id.name);
            description1 = (TextView) itemV.findViewById(R.id.description);
           // imageview1 = (ImageView)itemV.findViewById(R.id.imageview);

        }
    }}

  /*  public static int getResourceId(Context context, String pVariableName, String pResourcename, String pPackageName) throws RuntimeException {
        try {
            return context.getResources().getIdentifier(pVariableName, pResourcename, pPackageName);
        } catch (Exception e) {
            throw new RuntimeException("Error getting Resource ID.", e);
        }
    }


}*/