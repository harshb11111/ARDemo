package com.online.vegas.demo.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.online.vegas.demo.R;
import com.online.vegas.demo.databinding.RowFeedListBinding;
import com.online.vegas.demo.model.FeedListData;

import java.util.ArrayList;

public class FeedListAdapter extends RecyclerView.Adapter<FeedListAdapter.ViewHolder> {

    private ArrayList<FeedListData> feedList;
    private Context context;

    public FeedListAdapter(ArrayList<FeedListData> list, Context context) {
        this.feedList = list;
        this.context = context;
    }

    @Override
    public FeedListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RowFeedListBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.row_feed_list, parent, false);

        ViewHolder viewHolder = new ViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final FeedListData data = feedList.get(position);
        holder.itemBinding.setFeedlist(data);
        holder.itemBinding.executePendingBindings();

        if (data.getTitle() == null) {
            holder.itemBinding.txtTitle.setText(context.getResources().getText(R.string.strNoData));
        }

        if (data.getDescription() == null) {
            holder.itemBinding.txtDesc.setText(context.getResources().getText(R.string.strNoData));
        }
        if (data.getImageHref() == null) {
            holder.itemBinding.imgLogo.setImageResource(R.drawable.noimg);
        }

        holder.itemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (data.getTitle() != null) {
                    Toast.makeText(context, data.getTitle().toString(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return feedList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public RowFeedListBinding itemBinding;

        public ViewHolder(RowFeedListBinding binding) {
            super(binding.getRoot());
            itemBinding = binding;
        }
    }

}