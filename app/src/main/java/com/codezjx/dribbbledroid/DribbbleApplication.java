package com.codezjx.dribbbledroid;

import android.app.Application;

import com.facebook.stetho.Stetho;


/**
 * Created by codezjx on 2016/6/14.<br/>
 * Dribble base application.
 */
public class DribbbleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initStetho();
    }

    private void initStetho() {
        // Enable stetho just in debug mode
        if (BuildConfig.DEBUG) {
            Stetho.initialize(Stetho.newInitializerBuilder(this)
                    .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                    .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                    .build());
        }
    }
}
