package com.example.testing.simonsaysreboot.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.example.testing.simonsaysreboot.model.ButtonLoc.*;

/**
 * Created by dannylui on 5/11/17.
 */

public class GameEngine {
    private int highestRound;
    private int currentRound;

    private List<ButtonLoc> buttonLocList;

    public GameEngine() {
        this.highestRound = 0;
        this.currentRound = 0;
        this.buttonLocList = new ArrayList<>();
    }

    public void addRandomButtonLocToList() {
        Random random = new Random();
        int randNum = random.nextInt(4);
        switch (randNum) {
            case 0:
                buttonLocList.add(TOPLEFT);
                break;
            case 1:
                buttonLocList.add(TOPRIGHT);
                break;
            case 2:
                buttonLocList.add(BOTLEFT);
                break;
            case 3:
                buttonLocList.add(BOTRIGHT);
                break;

        }
    }

    public List<ButtonLoc> getButtonLocList() {
        return buttonLocList;
    }
}
