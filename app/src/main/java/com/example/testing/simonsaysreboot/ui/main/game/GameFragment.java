package com.example.testing.simonsaysreboot.ui.main.game;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.testing.simonsaysreboot.R;
import com.example.testing.simonsaysreboot.model.ButtonLoc;
import com.example.testing.simonsaysreboot.ui.main.home.HomeFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dannylui on 5/11/17.
 */

public class GameFragment extends Fragment implements GameView, View.OnClickListener{
    @BindView(R.id.game_btn_top_left) Button topLeftButton;
    @BindView(R.id.game_btn_top_right) Button topRightButton;
    @BindView(R.id.game_btn_bot_left) Button botLeftButton;
    @BindView(R.id.game_btn_bot_right) Button botRightButton;
    @BindView(R.id.game_cv_popup) CardView popupWindow;
    @BindView(R.id.game_btn_retry) Button retryButton;
    @BindView(R.id.game_btn_go_back) Button goBackButton;

    private GamePresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_game, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        topLeftButton.setOnClickListener(this);
        topRightButton.setOnClickListener(this);
        botLeftButton.setOnClickListener(this);
        botRightButton.setOnClickListener(this);
        retryButton.setOnClickListener(this);
        goBackButton.setOnClickListener(this);

        presenter = new GamePresenter(this);
        presenter.loopGame();
    }

    @Override
    public void flashButtons(List<ButtonLoc> buttonLocList) {
        presenter.startFlashing();
        for (int i = 0; i < buttonLocList.size(); i++) {
            switch (buttonLocList.get(i)) {
                case TOPLEFT:
                    flashButton(topLeftButton, i);
                    break;
                case TOPRIGHT:
                    flashButton(topRightButton, i);
                    break;
                case BOTLEFT:
                    flashButton(botLeftButton, i);
                    break;
                case BOTRIGHT:
                    flashButton(botRightButton, i);
                    break;
            }
        }
    }

    public void flashButton(final Button button, final int index) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                button.animate().alpha(0).setDuration(100);
            }
        }, (index * 500 + 250)); // 250 250 750 1250

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                button.animate().alpha(1).setDuration(100);
                presenter.finishFlashing(index);
            }
        }, ((index + 1)*500)); // 500 1000 1500
    }

    @Override
    public void enableButtons() {
        topLeftButton.setClickable(true);
        topRightButton.setClickable(true);
        botLeftButton.setClickable(true);
        botRightButton.setClickable(true);
    }

    @Override
    public void disableButtons() {
        topLeftButton.setClickable(false);
        topRightButton.setClickable(false);
        botLeftButton.setClickable(false);
        botRightButton.setClickable(false);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.game_btn_top_left:
                presenter.onTopLeftButtonClicked();
                break;
            case R.id.game_btn_top_right:
                presenter.onTopRightButtonClicked();
                break;
            case R.id.game_btn_bot_left:
                presenter.onBotLeftButtonClicked();
                break;
            case R.id.game_btn_bot_right:
                presenter.onBotRightButtonClicked();
                break;
            case R.id.game_btn_retry:
                presenter.onPlayAgainButtonClicked();
                break;
            case R.id.game_btn_go_back:
                presenter.onGoBackButtonClicked();
                break;
        }
    }

    @Override
    public void showHomeFragment() {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, new HomeFragment())
                .commit();
    }

    @Override
    public void showPopupWindow() {
        popupWindow.setVisibility(View.VISIBLE);
    }

    @Override
    public void hidePopupWindow() {
        popupWindow.setVisibility(View.GONE);
    }
}
