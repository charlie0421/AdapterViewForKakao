package com.ironlove.adapterviewforkakao.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ironlove.adapterviewforkakao.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final String TAG = getClass().getName();
    private EditText etURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnListView01 = (Button) findViewById(R.id.btnAdapterListView);
        Button btnListView02 = (Button) findViewById(R.id.btnRecylerListView);
        Button btnGridView01 = (Button) findViewById(R.id.btnAdapterGridView);
        Button btnGridView02 = (Button) findViewById(R.id.btnRecylerGridView);
        etURL = (EditText) findViewById(R.id.etURL);

        if (btnListView01 != null)
            btnListView01.setOnClickListener(this);
        if (btnListView02 != null)
            btnListView02.setOnClickListener(this);
        if (btnGridView01 != null)
            btnGridView01.setOnClickListener(this);
        if (btnGridView02 != null)
            btnGridView02.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String strURL = etURL.getText().toString();
        Log.d(TAG, "URL:" + strURL);

        Intent intent;
        switch (v.getId())

        {
            case R.id.btnAdapterListView:
                intent = new Intent(this, AdapterListViewActivity.class);
                intent.putExtra("URL", strURL);
                startActivity(intent);
                break;
            case R.id.btnRecylerListView:
                intent = new Intent(this, RecyclerListViewActivity.class);
                intent.putExtra("URL", strURL);
                startActivity(intent);
                break;
            case R.id.btnAdapterGridView:
                intent = new Intent(this, AdapterGridViewActivity.class);
                intent.putExtra("URL", strURL);
                startActivity(intent);
                break;
            case R.id.btnRecylerGridView:
                intent = new Intent(this, RecyclerGridViewActivity.class);
                intent.putExtra("URL", strURL);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

}
