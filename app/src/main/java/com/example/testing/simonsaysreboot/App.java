package com.example.testing.simonsaysreboot;

import android.app.Application;

import com.example.testing.simonsaysreboot.di.AppComponent;
import com.example.testing.simonsaysreboot.di.AppModule;
import com.example.testing.simonsaysreboot.di.DaggerAppComponent;

/**
 * Created by dannylui on 5/11/17.
 */

public class App extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
