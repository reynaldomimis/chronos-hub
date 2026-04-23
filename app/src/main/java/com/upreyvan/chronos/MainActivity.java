package com.upreyvan.chronos;

import android.content.Intent;
import android.os.Bundle;

import com.upreyvan.chronos.activities.LeaderboardActivity;
import com.upreyvan.chronos.base.BaseActivity;
import com.upreyvan.chronos.databinding.ActivityMainBinding;
import com.upreyvan.chronos.fragments.game.GameFragment;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        setupBottomNavigation();
        
        if (savedInstanceState == null) {
            replaceFragment(new GameFragment());
            binding.bottomNavigation.setSelectedItemId(R.id.menu_home);
        }
    }

    private void setupBottomNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.menu_home) {
                replaceFragment(new GameFragment());
                return true;
            }
//            } else if (itemId == R.id.menu_leaderboard) {
//                startActivity(new Intent(this, LeaderboardActivity.class));
//                return false;
//            }
            // Handle other menu items here
            return true;
        });
    }
}
