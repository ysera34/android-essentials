package com.example.android.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by yoon on 2017. 2. 1..
 */

public class TwoFragment extends Fragment {

    public static TwoFragment newInstance() {

        Bundle args = new Bundle();

        TwoFragment fragment = new TwoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private TextView mTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        mTextView = (TextView) view.findViewById(R.id.text_view);
        return view;
    }

    public void changeTextProperties(int fontSize, String text) {
        mTextView.setTextSize(fontSize);
        mTextView.setText(text);
    }
}
