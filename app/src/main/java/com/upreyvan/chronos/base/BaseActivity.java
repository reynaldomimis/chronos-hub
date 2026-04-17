package com.upreyvan.chronos.base;

import android.content.Context;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.ref.WeakReference;

public class BaseActivity extends AppCompatActivity {

    private static BaseActivity sIstance;
    private WeakReference<Context> ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EdgeToEdge.enable(this);
        super.onCreate(savedInstanceState);
        sIstance = this;
        ctx = new WeakReference<>(this);
    }

    public static BaseActivity getInstance() {
        return sIstance;
    }

    @Override
    protected void onDestroy() {
        ctx.clear();
        super.onDestroy();
    }
}
