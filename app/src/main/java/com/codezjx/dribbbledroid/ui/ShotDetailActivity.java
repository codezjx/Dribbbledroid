package com.codezjx.dribbbledroid.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.codezjx.dribbbledroid.R;
import com.codezjx.dribbbledroid.model.Shot;
import com.codezjx.dribbbledroid.presenter.ShotDetailPresenter;

/**
 * Created by codezjx on 2016/6/22.<br/>
 */
public class ShotDetailActivity extends AppCompatActivity {

    private static final String TAG = "ShotDetailActivity";
    public static final String INTENT_EXTRA_SHOT = "EXTRA_SHOT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_shot_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Shot shot = getIntent().getParcelableExtra(INTENT_EXTRA_SHOT);
        ShotDetailFragment fragment = (ShotDetailFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        // Create the presenter
        new ShotDetailPresenter(shot, fragment);
    }

}
