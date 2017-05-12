package com.example.testing.simonsaysreboot.ui.main.home;

/**
 * Created by dannylui on 5/11/17.
 */

public class HomePresenter {
    private HomeView view;

    public HomePresenter(HomeView view) {
        this.view = view;
    }

    public void onStartClicked() {
        view.showGameFragment();
    }

    public void onQuitClicked() {

    }
}
