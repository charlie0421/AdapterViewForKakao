package com.ironlove.adapterviewforkakao.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.ironlove.adapterviewforkakao.Adapter.ArrayAdapter01Adapter;
import com.ironlove.adapterviewforkakao.R;
import com.ironlove.adapterviewforkakao.Task.ImageParseFromGettyImageTask;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.PauseOnScrollListener;

public class GridView01Activity extends AdapterViewBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view01);

        Intent intent = getIntent();
        String strURL = intent.getStringExtra("URL");
        ImageParseFromGettyImageTask task = new ImageParseFromGettyImageTask(this);
        task.execute(strURL);

        mAbsListView = (GridView) findViewById(R.id.gridview);
        mArrayAdapter = new ArrayAdapter01Adapter(
                mActivity, mContext, R.layout.layout_gridview01,
                mListData);
        mAbsListView.setAdapter(mArrayAdapter);
        mAbsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext, mListData.get(position).strCaption, Toast.LENGTH_SHORT).show();
            }
        });
        PauseOnScrollListener listener = new PauseOnScrollListener(ImageLoader.getInstance(), true, true);
        mAbsListView.setOnScrollListener(listener);

    }

}
