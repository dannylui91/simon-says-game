package com.example.testing.simonsaysreboot.ui.main;

/**
 * Created by dannylui on 5/11/17.
 */

public class MainPresenter {
    private MainView view;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    public void initialize() {
        view.showHomeFragment();
    }


}
