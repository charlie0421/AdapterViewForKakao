package com.ironlove.adapterviewforkakao.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ironlove.adapterviewforkakao.Adapter.RecylerAdapter;
import com.ironlove.adapterviewforkakao.R;
import com.ironlove.adapterviewforkakao.Task.ImageParseFromGettyImageTask;

public class GridView02Activity extends RecylerViewBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view02);

        Intent intent = getIntent();
        String strURL = intent.getStringExtra("URL");
        ImageParseFromGettyImageTask task = new ImageParseFromGettyImageTask(this);
        task.execute(strURL);

        mRecyclerView = (RecyclerView) findViewById(R.id.recylerview);

        if (mRecyclerView != null) {
            mRecyclerView.setHasFixedSize(false);


            mLayoutManager = new GridLayoutManager(this, 5);
            mRecyclerView.setLayoutManager(mLayoutManager);

            mAdapter = new RecylerAdapter(mListData);
            mRecyclerView.setAdapter(mAdapter);
        }
    }
}
