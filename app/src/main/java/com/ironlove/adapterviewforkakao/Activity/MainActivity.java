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

        Button btnListView01 = (Button) findViewById(R.id.btnListView01);
        Button btnGridView01 = (Button) findViewById(R.id.btnGridView01);
        etURL = (EditText) findViewById(R.id.etURL);

        if (btnListView01 != null)
            btnListView01.setOnClickListener(this);
        if (btnGridView01 != null)
            btnGridView01.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId())

        {
            case R.id.btnListView01:
                intent = new Intent(this, ListView01Activity.class);
                intent.putExtra("URL", etURL.getText().toString());
                startActivity(intent);
                Log.d(TAG, "URL:" + etURL.getText());
                break;
            case R.id.btnGridView01:
                intent = new Intent(this, GridView01Activity.class);
                intent.putExtra("URL", etURL.getText().toString());
                startActivity(intent);
                Log.d(TAG, "URL:" + etURL.getText());
                break;
        }
    }

}
