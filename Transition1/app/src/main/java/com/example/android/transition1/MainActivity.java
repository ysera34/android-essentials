package com.example.android.transition1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.Explode;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mMainLinearLayout;
    private Button mButton;
    private Scene scene1;
    private TransitionSet mTransitionSet;
    private Transition mTransitionExplode;
    private Transition mTransitionChangeBounds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainLinearLayout = (LinearLayout) findViewById(R.id.activity_main_layout);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);
        scene1 = Scene.getSceneForLayout(mMainLinearLayout, R.layout.scene1_layout, this);

        mTransitionExplode = new Explode();
        mTransitionChangeBounds = new ChangeBounds();

        mTransitionSet = new TransitionSet();
//        mTransitionSet.addTransition(mTransitionExplode);
        mTransitionSet.addTransition(mTransitionChangeBounds);
    }

    @Override
    public void onClick(View v) {
//        scene1.enter();
        TransitionManager.go(scene1, mTransitionSet);
    }
}
