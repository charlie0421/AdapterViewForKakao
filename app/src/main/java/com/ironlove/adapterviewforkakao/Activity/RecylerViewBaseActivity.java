package com.ironlove.adapterviewforkakao.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.AbsListView;

import com.ironlove.adapterviewforkakao.Item.GettyImage;

import java.util.ArrayList;

public class RecylerViewBaseActivity extends AppCompatActivity {

    public final ArrayList<GettyImage> mListData = new ArrayList<>();
    public RecyclerView.Adapter mAdapter;
    protected RecyclerView mRecyclerView;
    protected RecyclerView.LayoutManager mLayoutManager;
    AbsListView mListView;
    RecylerViewBaseActivity mActivity;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        mContext = this;

    }


}
