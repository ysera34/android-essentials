package com.android.sample.transition4;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by yoon on 2017. 7. 14..
 */

public class Fragment1 extends Fragment implements View.OnClickListener {

    public static Fragment1 newInstance() {

        Bundle args = new Bundle();

        Fragment1 fragment = new Fragment1();
        fragment.setArguments(args);
        return fragment;
    }

    private TextView mTransitionTextView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_1, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTransitionTextView = (TextView) view.findViewById(R.id.transition_text_view);
        mTransitionTextView .setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.transition_text_view:
                Intent intent = new Intent(getActivity(), Main2Activity.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                        getActivity(), mTransitionTextView, "transition_text_view");
                startActivity(intent, options.toBundle());
                break;
        }
    }
}
