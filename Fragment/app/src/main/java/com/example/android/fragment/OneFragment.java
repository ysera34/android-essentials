package com.example.android.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

/**
 * Created by yoon on 2017. 2. 1..
 */

public class OneFragment extends Fragment
        implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    public static OneFragment newInstance() {
        
        Bundle args = new Bundle();
        
        OneFragment fragment = new OneFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private EditText mEditText;
    private SeekBar mSeekBar;
    public int seekValue = 10;
    private Button mButton;

    ActivityListener mActivityListener;

    interface ActivityListener {
        void onPassData(int size, String text);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mActivityListener = (ActivityListener) context;
        } catch (ClassCastException e) {
            e.getMessage();
            throw new ClassCastException(context.toString()
                    + " must implement ActivityListener");
        }
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, 
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        mEditText = (EditText) view.findViewById(R.id.edit_text);
        mSeekBar = (SeekBar) view.findViewById(R.id.seek_bar);
        mSeekBar.setOnSeekBarChangeListener(this);
        mButton = (Button) view.findViewById(R.id.button);
        mButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.edit_text:
                break;
            case R.id.seek_bar:
                break;
            case R.id.button:
                mActivityListener.onPassData(seekValue, mEditText.getText().toString());
                break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        seekValue = progress;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
