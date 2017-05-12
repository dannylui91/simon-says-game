package com.example.testing.simonsaysreboot.ui.main.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.testing.simonsaysreboot.R;
import com.example.testing.simonsaysreboot.ui.main.game.GameFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dannylui on 5/11/17.
 */

public class HomeFragment extends Fragment implements HomeView {
    @BindView(R.id.main_btn_start) Button startButton;
    @BindView(R.id.main_btn_quit) Button quitButton;

    private HomePresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        presenter = new HomePresenter(this);


        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onStartClicked();
            }
        });

        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onQuitClicked();
            }
        });
    }

    @Override
    public void showGameFragment() {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, new GameFragment())
                .commit();
    }
}
