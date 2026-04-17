package com.upreyvan.chronos.ui.start;

import android.content.Intent;
import android.os.Bundle;

import com.upreyvan.chronos.base.BaseActivity;
import com.upreyvan.chronos.databinding.ActivityMainBinding;
import com.upreyvan.chronos.ui.home.HomeActivity;
import com.upreyvan.chronos.util.Utils;

public class StartActivity extends BaseActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Utils.addSystemWindowInsetToPadding(binding.btnCreateAccount, true, false, true, true);
        binding.btnLogin.setOnClickListener(v -> {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        });
    }
}
