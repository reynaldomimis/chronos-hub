package com.upreyvan.chronos.ui.start;

import android.content.Intent;
import android.os.Bundle;

import com.upreyvan.chronos.base.BaseActivity;
import com.upreyvan.chronos.databinding.ActivityMainBinding;
import com.upreyvan.chronos.databinding.ActivityStartBinding;
import com.upreyvan.chronos.ui.home.HomeActivity;
import com.upreyvan.chronos.util.Utils;

public class StartActivity extends BaseActivity {

    private ActivityStartBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Utils.addSystemWindowInsetToMargin(binding.btnCreateAccount, true, false, true, true);
        binding.btnLogin.setOnClickListener(v -> {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        });
    }
}
