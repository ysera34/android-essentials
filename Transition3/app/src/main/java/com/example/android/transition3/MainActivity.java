package com.example.android.transition3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewGroup mRootContainerViewGroup;
    private Button mButton1;
    private Button mButton2;
    private Scene mScene1;
    private Scene mScene2;
    private Transition mTransitionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRootContainerViewGroup = (ViewGroup) findViewById(R.id.activity_main);
        mButton1 = (Button) findViewById(R.id.button1);
        mButton1.setOnClickListener(this);
        mButton2 = (Button) findViewById(R.id.button2);
        mButton2.setOnClickListener(this);

        mTransitionManager = TransitionInflater.from(this)
                .inflateTransition(R.transition.transition);

        mScene1 = Scene.getSceneForLayout(mRootContainerViewGroup,
                R.layout.scene1_layout, this);

        mScene2 = Scene.getSceneForLayout(mRootContainerViewGroup,
                R.layout.scene2_layout, this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                startActivity(new Intent(this, Main2Activity.class));
                break;
            case R.id.button2:
                mScene1.enter();
                break;
        }
    }

    public void goToScene1(View view) {
//        TransitionManager.go(mScene1);
        TransitionManager.go(mScene1, mTransitionManager);
    }

    public void goToScene2(View view) {
//        TransitionManager.go(mScene2);
        TransitionManager.go(mScene2, mTransitionManager);
    }
}
