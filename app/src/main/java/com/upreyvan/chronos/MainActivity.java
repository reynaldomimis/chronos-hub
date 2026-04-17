package com.upreyvan.chronos;

import android.content.Intent;
import android.os.Bundle;

import com.upreyvan.chronos.base.BaseActivity;
import com.upreyvan.chronos.ui.home.HomeActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnLogin).setOnClickListener(v -> {
            startActivity(new Intent(this, HomeActivity.class));
        });
    }
}