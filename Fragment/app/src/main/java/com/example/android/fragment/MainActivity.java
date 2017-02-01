package com.example.android.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OneFragment.ActivityListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onPassData(int size, String text) {

        TwoFragment twoFragment = (TwoFragment)
                getSupportFragmentManager().findFragmentById(R.id.two_fragment);

        twoFragment.changeTextProperties(size, text);
    }
}
