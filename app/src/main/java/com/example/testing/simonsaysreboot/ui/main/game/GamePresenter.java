package com.example.testing.simonsaysreboot.ui.main.game;

import com.example.testing.simonsaysreboot.model.ButtonLoc;
import com.example.testing.simonsaysreboot.model.GameEngine;

import static com.example.testing.simonsaysreboot.model.ButtonLoc.BOTLEFT;
import static com.example.testing.simonsaysreboot.model.ButtonLoc.BOTRIGHT;
import static com.example.testing.simonsaysreboot.model.ButtonLoc.TOPLEFT;
import static com.example.testing.simonsaysreboot.model.ButtonLoc.TOPRIGHT;

/**
 * Created by dannylui on 5/11/17.
 */

public class GamePresenter {
    private GameEngine gameEngine;
    private GameView view;
    private int currentIndex;

    public GamePresenter(GameView view) {
        gameEngine = new GameEngine();
        this.view = view;
        currentIndex = 0;
    }

    public void loopGame() {
        gameEngine.addRandomButtonLocToList();
        view.flashButtons(gameEngine.getButtonLocList());

    }

    public void finishFlashing(int index) {
        if (index == gameEngine.getButtonLocList().size() - 1) {
            System.out.println("FINISHED FLASHING");
            view.enableButtons();
        }
    }

    public void startFlashing() {
        view.disableButtons();
    }

    public void onTopLeftButtonClicked() {
        checkCorrectButtonClicked(TOPLEFT);
    }

    public void onTopRightButtonClicked() {
        checkCorrectButtonClicked(TOPRIGHT);
    }

    public void onBotLeftButtonClicked() {
        checkCorrectButtonClicked(BOTLEFT);
    }

    public void onBotRightButtonClicked() {
        checkCorrectButtonClicked(BOTRIGHT);
    }

    public void checkCorrectButtonClicked(ButtonLoc button) {
        if (gameEngine.getButtonLocList().get(currentIndex) == button) {
            System.out.println("TRUE");
            currentIndex++;
            if (currentIndex == gameEngine.getButtonLocList().size()) {
                loopGame();
                return;
            }
        } else {
            view.showLoserPopup();
        }
    }
}
