package com.ironlove.adapterviewforkakao.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.ironlove.adapterviewforkakao.Data.GettyImage;

import java.util.ArrayList;

public class BaseActivity extends AppCompatActivity {
    public ArrayList<GettyImage> mListData = new ArrayList<GettyImage>();
    public ArrayAdapter<GettyImage> mAdapter;
    public AdapterView mAdapterView;
    public Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;

    }


}
