package com.upreyvan.chronos;

import android.content.Intent;
import android.os.Bundle;

import com.upreyvan.chronos.base.BaseActivity;
import com.upreyvan.chronos.databinding.ActivityMainBinding;
import com.upreyvan.chronos.ui.home.HomeActivity;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnLogin.setOnClickListener(v -> {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        });
    }
}