package com.ironlove.adapterviewforkakao.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.ironlove.adapterviewforkakao.Adapter.ArrayAdapter01Adapter;
import com.ironlove.adapterviewforkakao.R;
import com.ironlove.adapterviewforkakao.Task.ImageParseFromGettyImageTask;

public class GridView01Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view01);

        ImageParseFromGettyImageTask task = new ImageParseFromGettyImageTask(this);
        task.execute("http://www.gettyimagesgallery.com/collections/archive/slim-aarons.aspx");

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
        mAbsListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (mIsScrolling = (scrollState != SCROLL_STATE_IDLE))
                    return;
                else {
                    mIsScrolling = true;
                    mArrayAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

    }
}
