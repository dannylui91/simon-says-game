package com.example.testing.simonsaysreboot.di;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.testing.simonsaysreboot.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dannylui on 5/11/17.
 */

@Module
public class AppModule {
    private final App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return app;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(App app) {
        return PreferenceManager.getDefaultSharedPreferences(app);
    }
}
