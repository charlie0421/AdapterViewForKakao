package com.ironlove.adapterviewforkakao.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ironlove.adapterviewforkakao.Item.GettyImage;
import com.ironlove.adapterviewforkakao.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnListView01;
    Button btnGridView01;
    private ArrayList<GettyImage> mGettyImageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnListView01 = (Button) findViewById(R.id.btnListView01);
        btnGridView01 = (Button) findViewById(R.id.btnGridView01);
        btnListView01.setOnClickListener(this);
        btnGridView01.setOnClickListener(this);


    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId())

        {
            case R.id.btnListView01:
                intent = new Intent(this, ListView01Activity.class);
                startActivity(intent);
                break;
            case R.id.btnGridView01:
                intent = new Intent(this, GridView01Activity.class);
                startActivity(intent);
                break;
        }
    }

}
