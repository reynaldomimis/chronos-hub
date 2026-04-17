package com.upreyvan.chronos.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.upreyvan.chronos.base.BaseFragment;
import com.upreyvan.chronos.databinding.FragmentGamesBinding;

public class GamesFragment extends BaseFragment<FragmentGamesBinding> {

    @Override
    protected FragmentGamesBinding onCreateViewBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return FragmentGamesBinding.inflate(inflater, container, false);
    }

    @Override
    protected void onViewBindingCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }
}
