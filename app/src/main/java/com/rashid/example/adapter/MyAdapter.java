package com.rashid.example.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rashid.example.R;
import com.rashid.example.model.Comments;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private static  ArrayList<Comments> itemsData;

    public MyAdapter(ArrayList<Comments> itemsData) {
        MyAdapter.itemsData = itemsData;
    }

    public MyAdapter() {

    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listlayout, null);
        return new ViewHolder(itemLayoutView);
    }

    public void updateRecyclerView(Comments comments) {
        itemsData.add(comments);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        viewHolder.txtViewTitle.setText(itemsData.get(position).getTitle());

    }

     static class ViewHolder extends RecyclerView.ViewHolder {
         TextView txtViewTitle;

         ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            txtViewTitle = itemLayoutView.findViewById(R.id.name);
        }
    }

    @Override
    public int getItemCount() {
        return itemsData.size();
    }
}