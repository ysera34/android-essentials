package com.example.android.transition3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    private ViewGroup mRootContainerViewGroup;
    private Scene mScene1;
    private Scene mScene2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRootContainerViewGroup = (ViewGroup) findViewById(R.id.activity_main);
        mScene1 = Scene.getSceneForLayout(mRootContainerViewGroup,
                R.layout.scene1_layout, this);
        mScene1.enter();

        mScene2 = Scene.getSceneForLayout(mRootContainerViewGroup,
                R.layout.scene2_layout, this);
    }

    public void goToScene1(View view) {
        TransitionManager.go(mScene1);
    }

    public void goToScene2(View view) {
        TransitionManager.go(mScene2);
    }
}
