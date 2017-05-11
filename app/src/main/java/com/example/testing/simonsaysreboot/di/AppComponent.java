package com.example.testing.simonsaysreboot.di;

import com.example.testing.simonsaysreboot.ui.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by dannylui on 5/11/17.
 */

@Singleton
@Component(modules = {AppModule.class,})
public interface AppComponent {
    void inject(MainActivity mainActivity);


}
