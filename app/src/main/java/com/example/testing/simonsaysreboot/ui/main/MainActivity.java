package com.example.testing.simonsaysreboot.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.testing.simonsaysreboot.R;
import com.example.testing.simonsaysreboot.ui.main.game.GameFragment;
import com.example.testing.simonsaysreboot.ui.main.home.HomeFragment;

public class MainActivity extends AppCompatActivity implements MainView {
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);
        presenter.initialize();
    }


    @Override
    public void onStartClicked() {

    }

    @Override
    public void onQuitClicked() {

    }

    @Override
    public void showHomeFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, new HomeFragment())
                .commit();
    }

    @Override
    public void showGameFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, new GameFragment())
                .commit();
    }
}
