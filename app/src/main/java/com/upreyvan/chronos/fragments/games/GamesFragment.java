package com.upreyvan.chronos.fragments.games;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.upreyvan.chronos.R;
import com.upreyvan.chronos.activities.LeaderboardActivity;
import com.upreyvan.chronos.adapters.TopGameAdapter;
import com.upreyvan.chronos.adapters.TaskAdapter;
import com.upreyvan.chronos.base.BaseFragment;
import com.upreyvan.chronos.databinding.FragmentGamesBinding;
import com.upreyvan.chronos.model.ActivitiesModel;
import com.upreyvan.chronos.model.TopGamesModel;
import com.upreyvan.chronos.util.GridSpacingItemDecoration;
import com.upreyvan.chronos.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class GamesFragment extends BaseFragment<FragmentGamesBinding> {

    private TaskAdapter taskAdapter;
    private TopGameAdapter topGameAdapter;

    @Override
    protected FragmentGamesBinding onCreateViewBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return FragmentGamesBinding.inflate(inflater, container, false);
    }

    @Override
    protected void onViewBindingCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Utils.addSystemWindowInsetToPadding(binding.headerSection.getRoot(), true, true, true, false);

        setupAdapters();
        loadData();
    }

    private void setupAdapters() {
        taskAdapter = new TaskAdapter();
        topGameAdapter = new TopGameAdapter();


        // Convert DP to PX
        int hGap = Utils.dpToPx(requireContext(), 10f);
        int vGap = Utils.dpToPx(requireContext(), 10f);

        // Decoration Cleanup
        if (binding.taskRecyclerView.getItemDecorationCount() > 0) {
            binding.taskRecyclerView.removeItemDecorationAt(0);
        }

        // Separate gaps
        binding.taskRecyclerView.addItemDecoration(
                new GridSpacingItemDecoration(2, hGap, vGap, false)
        );

        binding.taskRecyclerView.setAdapter(taskAdapter);
        binding.gameRecyclerView.setAdapter(topGameAdapter);

        binding.taskRecyclerView.setNestedScrollingEnabled(false);
        binding.gameRecyclerView.setNestedScrollingEnabled(false);

        taskAdapter.setOnItemClickListener((item, position) -> {
            Fragment selectedFragment = null;

            switch (position) {
                case 0:
                    break;

                case 1:
                    Intent intent = new Intent(requireContext(), LeaderboardActivity.class);
                    startActivity(intent);
                    break;

                case 2:
                    break;

                case 3:
                    break;
            }
        });
    }

    private void loadData() {
        //Activities Card Grid
        List<ActivitiesModel> tasks = new ArrayList<>();
        tasks.add(new ActivitiesModel(1, "Daily Task \nRewards", "Earn Daily Coins", 400, R.drawable.task));
        tasks.add(new ActivitiesModel(2, "Top Player", "bonus points \nRank up rewards + ", 500, R.drawable.rank));
        tasks.add(new ActivitiesModel(3, "Play Games", "Play a games to earn \nextra coins", 1000, R.drawable.games));
        tasks.add(new ActivitiesModel(4, "Watching Ads", "Play a games to earn \nextra coins", 1500, R.drawable.ads));
        taskAdapter.submitList(tasks);

        //Top 3 High Paying Games list
        List<TopGamesModel> games = new ArrayList<>();
        games.add(new TopGamesModel(1,  "Neon Skies: Warzone" ,3000, R.drawable.neon_sky));
        games.add(new TopGamesModel(2,  "GosPrazek", 2000, R.drawable.neon_sky));
        games.add(new TopGamesModel(3,  "Flappy Skies",  1000, R.drawable.neon_sky));
        topGameAdapter.submitList(games);
    }
}