package com.example.android.transition3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Created by yoon on 2017. 2. 2..
 */

public class Main2Activity extends AppCompatActivity {

    private ViewGroup mViewGroup;
    private Button mButton;
    private Transition mTransition;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mViewGroup = (ViewGroup) findViewById(R.id.activity_main);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleTouch();
            }
        });

        mTransition = TransitionInflater.from(this)
                .inflateTransition(R.transition.button_transition);
    }

    public void handleTouch() {
        View view = findViewById(R.id.button);

        Transition changeBoundsTransition = new ChangeBounds();
        changeBoundsTransition.setDuration(3000);
        changeBoundsTransition.setInterpolator(new BounceInterpolator());

//        way1:
//        TransitionManager.beginDelayedTransition(mViewGroup, changeBoundsTransition);

//        way2:
        TransitionManager.beginDelayedTransition(mViewGroup, mTransition);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, DetailFragment.newInstance())
                .commit();

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        view.setLayoutParams(params);

        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = 500;
        layoutParams.height = 350;
        view.setLayoutParams(layoutParams);
    }

}
