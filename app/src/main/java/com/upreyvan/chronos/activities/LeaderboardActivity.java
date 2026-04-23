package com.upreyvan.chronos.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.upreyvan.chronos.R;
import com.upreyvan.chronos.adapters.LeaderboardAdapter;
import com.upreyvan.chronos.base.BaseActivity;
import com.upreyvan.chronos.databinding.ActivityLeaderboardBinding;
import com.upreyvan.chronos.model.LeaderBoardModel;
import com.upreyvan.chronos.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class LeaderboardActivity extends BaseActivity {

    private ActivityLeaderboardBinding binding;
    private LeaderboardAdapter leaderboardAdapter;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLeaderboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Utils.addSystemWindowInsetToPadding(binding.headerSection.getRoot(), true, true, true, false);

        binding.headerSection.btnBack.setOnClickListener(v -> finish());
        binding.headerSection.tvHeaderTitle.setText(R.string.leaderboard);

        //Floating card current user
        binding.currentUserCardFloat.name.setText(R.string.default_username);
        binding.currentUserCardFloat.rank.setText(String.valueOf(12));
        binding.currentUserCardFloat.points.setText(String.valueOf(Utils.getFormattedCoins(1000)));
        binding.currentUserCardFloat.avatar.setImageResource(R.drawable.neon_sky);


        //TOp 3 Badge
        binding.podiumRank1.tvPodiumName1.setText(R.string.user1);
        binding.podiumRank2.tvPodiumName.setText(R.string.user2);
        binding.podiumRank3.tvPodiumName.setText(R.string.user3);

        setupRecyclerView();
        loadData();
    }

    private void setupRecyclerView() {
        leaderboardAdapter = new LeaderboardAdapter();
        binding.leaderboardRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.leaderboardRecyclerView.addItemDecoration(new androidx.recyclerview.widget.DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        binding.leaderboardRecyclerView.setAdapter(leaderboardAdapter);
    }


    private void loadData() {
        List<LeaderBoardModel> users = new ArrayList<>();
        users.add(new LeaderBoardModel(1, 1, "Reynaldo", 3000, R.drawable.neon_sky));
        users.add(new LeaderBoardModel(2, 2, "Elmo", 2000, R.drawable.img));
        users.add(new LeaderBoardModel(3, 3, "Warlito", 1000, R.drawable.neon_sky));
        users.add(new LeaderBoardModel(4, 4, "Reynaldo", 3000, R.drawable.neon_sky));
        users.add(new LeaderBoardModel(5, 5, "Elmo1", 2000, R.drawable.img));
        users.add(new LeaderBoardModel(6, 6, "Warlito1", 1000, R.drawable.neon_sky));
        users.add(new LeaderBoardModel(7, 7, "Reynaldo1", 3000, R.drawable.neon_sky));
        users.add(new LeaderBoardModel(8, 8, "Elmo2", 2000, R.drawable.img));
        users.add(new LeaderBoardModel(9, 9, "Warlito2", 1000, R.drawable.neon_sky));
        users.add(new LeaderBoardModel(10, 10, "Warlito2", 1000, R.drawable.neon_sky));

        //Max 10 data
        List<LeaderBoardModel> limitedList = users.size() > 10
                ? users.subList(0, 10)
                : users;

        leaderboardAdapter.submitList(limitedList);
    }
}