package com.upreyvan.chronos.activities;

import android.content.Intent;
import android.os.Bundle;

import com.upreyvan.chronos.base.BaseActivity;
import com.upreyvan.chronos.databinding.ActivityStartBinding;
import com.upreyvan.chronos.MainActivity;
import com.upreyvan.chronos.util.Utils;

public class StartActivity extends BaseActivity {

    private ActivityStartBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Utils.addSystemWindowInsetToMargin(binding.start, true, false, true, true);
        binding.btnLogin.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
}
