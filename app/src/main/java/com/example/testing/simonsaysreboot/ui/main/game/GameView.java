package com.example.testing.simonsaysreboot.ui.main.game;

import com.example.testing.simonsaysreboot.model.ButtonLoc;

import java.util.List;

/**
 * Created by dannylui on 5/11/17.
 */

public interface GameView {
    void flashButtons(List<ButtonLoc> buttonLocList);

    void enableButtons();

    void disableButtons();

    void showHomeFragment();

    void showPopupWindow();

    void hidePopupWindow();
}
