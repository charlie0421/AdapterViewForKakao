package com.ironlove.adapterviewforkakao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class BaseActivity extends AppCompatActivity {
    protected ArrayList<GettyImage> mListData = new ArrayList<GettyImage>();
    protected ArrayAdapter<GettyImage> mAdapter;
    protected AdapterView mAdapterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


}
