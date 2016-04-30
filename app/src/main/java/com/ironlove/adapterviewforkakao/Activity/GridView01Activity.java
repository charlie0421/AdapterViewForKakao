package com.ironlove.adapterviewforkakao.Activity;

import android.os.Bundle;
import android.widget.GridView;

import com.ironlove.adapterviewforkakao.Adapter.AdapterView01Adapter;
import com.ironlove.adapterviewforkakao.R;
import com.ironlove.adapterviewforkakao.Task.ImageParseFromGettyImageTask;

public class GridView01Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view01);

        ImageParseFromGettyImageTask task = new ImageParseFromGettyImageTask(this);
        task.execute("http://www.gettyimagesgallery.com/collections/archive/slim-aarons.aspx");

        mAdapterView = (GridView) findViewById(R.id.gridview);
        mAdapter = new AdapterView01Adapter(
                this, R.layout.layout_gridview01,
                mListData);
        mAdapterView.setAdapter(mAdapter);

    }
}
