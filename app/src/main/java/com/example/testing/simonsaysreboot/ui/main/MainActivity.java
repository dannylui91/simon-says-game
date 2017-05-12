package com.example.testing.simonsaysreboot.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.testing.simonsaysreboot.R;
import com.example.testing.simonsaysreboot.ui.main.home.HomeFragment;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, new HomeFragment())
                .commit();
    }
}
