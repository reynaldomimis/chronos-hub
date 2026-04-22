package com.upreyvan.chronos;

import android.os.Bundle;

import com.upreyvan.chronos.base.BaseActivity;
import com.upreyvan.chronos.databinding.ActivityMainBinding;
import com.upreyvan.chronos.fragments.games.GamesFragment;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if (savedInstanceState == null) {
            replaceFragment(new GamesFragment());
        }
    }
}