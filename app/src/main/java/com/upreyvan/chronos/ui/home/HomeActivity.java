package com.upreyvan.chronos.ui.home;

import android.os.Bundle;

import com.upreyvan.chronos.R;
import com.upreyvan.chronos.ui.BaseActivity;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        applySafeArea(R.id.home);
    }
}