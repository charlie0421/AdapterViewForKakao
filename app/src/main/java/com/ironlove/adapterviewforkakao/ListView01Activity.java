package com.ironlove.adapterviewforkakao;

import android.os.Bundle;
import android.widget.ListView;

public class ListView01Activity extends BaseActivity {
    public final static String TAG = "ListView01Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view01);

        ImageParseFromGettyImageTask task = new ImageParseFromGettyImageTask(this);
        task.execute("http://www.gettyimagesgallery.com/collections/archive/slim-aarons.aspx");

        mAdapterView = (ListView) findViewById(R.id.listView);
        mAdapter = new ListView01Adapter(
                this, R.layout.layout_listview01,
                mListData);
        mAdapterView.setAdapter(mAdapter);

    }

}
