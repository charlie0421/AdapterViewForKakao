package com.ironlove.adapterviewforkakao.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.ironlove.adapterviewforkakao.Adapter.AdapterView01Adapter;
import com.ironlove.adapterviewforkakao.R;
import com.ironlove.adapterviewforkakao.Task.ImageParseFromGettyImageTask;

public class ListView01Activity extends BaseActivity {
    public final static String TAG = "ListView01Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view01);
        ImageParseFromGettyImageTask task = new ImageParseFromGettyImageTask(this);
        task.execute("http://www.gettyimagesgallery.com/collections/archive/slim-aarons.aspx");

        mAdapterView = (ListView) findViewById(R.id.listView);
        mAdapter = new AdapterView01Adapter(
                this, R.layout.layout_listview01,
                mListData);
        mAdapterView.setAdapter(mAdapter);

        mAdapterView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext, mListData.get(position).strCaption, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
