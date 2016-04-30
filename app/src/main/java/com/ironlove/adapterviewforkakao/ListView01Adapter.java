package com.ironlove.adapterviewforkakao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

public class ListView01Adapter extends ArrayAdapter<GettyImage> {
    private final Context context;
    private final int resource;
    private ArrayList<GettyImage> items;


    public ListView01Adapter(Context context, int resource, ArrayList<GettyImage> items) {
        super(context, resource, items);
        this.context = context;
        this.resource = resource;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(resource, null);

            holder = new ViewHolder();
            holder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            holder.ivImage = (ImageView) convertView.findViewById(R.id.ivImage);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.position = position;

        final GettyImage list_data = items.get(position);

        if (list_data != null) {

            holder.tvTitle.setText(list_data.strCaption);

            ImageLoader.getInstance().displayImage(list_data.strURL, holder.ivImage);

        }

        return convertView;
    }

    private static class ViewHolder {
        public int position;
        public ImageView ivImage;
        public TextView tvTitle;
    }

}
