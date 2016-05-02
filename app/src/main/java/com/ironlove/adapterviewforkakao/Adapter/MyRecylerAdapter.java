package com.ironlove.adapterviewforkakao.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ironlove.adapterviewforkakao.Item.GettyImage;
import com.ironlove.adapterviewforkakao.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

public class MyRecylerAdapter extends RecyclerView.Adapter<MyRecylerAdapter.ViewHolder> {
    private ArrayList<GettyImage> mDataset;

    public MyRecylerAdapter(ArrayList<GettyImage> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyRecylerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_recyler_listview_card, parent, false);
        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mDataset.get(position).strCaption);
        ImageLoader.getInstance().displayImage(mDataset.get(position).strURL, holder.mImageView);

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView mImageView;
        public TextView mTextView;

        public ViewHolder(View view) {
            super(view);
            mImageView = (ImageView) view.findViewById(R.id.ivImage);
            mTextView = (TextView) view.findViewById(R.id.tvTitle);
        }
    }
}

