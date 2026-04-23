package com.upreyvan.chronos.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.upreyvan.chronos.R;
import com.upreyvan.chronos.adapters.DailyCheckInAdapter;
import com.upreyvan.chronos.adapters.DailyRewardsAdapter;
import com.upreyvan.chronos.base.BaseActivity;
import com.upreyvan.chronos.databinding.ActivityDailytaskBinding;
import com.upreyvan.chronos.model.ActivitiesModel;
import com.upreyvan.chronos.util.RewardManager;
import com.upreyvan.chronos.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class DailyActivity extends BaseActivity {

    private RewardManager rewardManager;
    private int totals;
    private ActivityDailytaskBinding binding;
    private DailyCheckInAdapter dailyAdapter;
    private DailyRewardsAdapter rewardsAdapter;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDailytaskBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        rewardManager = new RewardManager(this);

        Utils.addSystemWindowInsetToPadding(binding.headerSection.getRoot(), true, true, true, false);
        binding.headerSection.btnBack.setOnClickListener(v -> finish());
        binding.headerSection.tvHeaderTitle.setText(R.string.daily_task);

//        getSharedPreferences("DailyPrefs", MODE_PRIVATE).edit().clear().apply();

        setupRecyclerView();
        loadData();
        setDataUI();
    }

    private void setupRecyclerView() {
        dailyAdapter = new DailyCheckInAdapter();
        rewardsAdapter = new DailyRewardsAdapter();

        binding.checkinRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.rewardsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        binding.checkinRecyclerView.setNestedScrollingEnabled(false);
        binding.rewardsRecyclerView.setNestedScrollingEnabled(false);

        binding.checkinRecyclerView.setAdapter(dailyAdapter);
        binding.rewardsRecyclerView.setAdapter(rewardsAdapter);
    }

    private void loadData() {
        List<ActivitiesModel> tasksCheckin = new ArrayList<>();
        int[] dailyCoins = {10, 20, 30, 40, 50, 80, 100};

        for (int i = 0; i < dailyCoins.length; i++) {
            int id = i + 1;
            String status = rewardManager.getStatusForTask(id, "Day " + id);
            tasksCheckin.add(new ActivitiesModel(id, status, "", dailyCoins[i], R.drawable.ic_coin));
        }
        dailyAdapter.submitList(tasksCheckin);

        List<ActivitiesModel> tasksRewards = new ArrayList<>();
        tasksRewards.add(new ActivitiesModel(101, "Watch Ads", rewardManager.getStatusForTask(101, "Watch"), 10, R.drawable.ic_coin));
        tasksRewards.add(new ActivitiesModel(102, "Follow on Youtube", rewardManager.getStatusForTask(102, "Follow"), 20, R.drawable.ic_coin));
        tasksRewards.add(new ActivitiesModel(103, "Follow on Facebook", rewardManager.getStatusForTask(103, "Follow"), 30, R.drawable.ic_coin));
        tasksRewards.add(new ActivitiesModel(104, "Watch Movies", rewardManager.getStatusForTask(104, "Watch"), 40, R.drawable.ic_coin));
        tasksRewards.add(new ActivitiesModel(105, "Login account", rewardManager.getStatusForTask(105, "Login"), 50, R.drawable.ic_coin));
        tasksRewards.add(new ActivitiesModel(106, "Turn push notification", rewardManager.getStatusForTask(106, "Enable"), 50, R.drawable.ic_coin));
        tasksRewards.add(new ActivitiesModel(107, "Claim daily", rewardManager.getStatusForTask(107, "Claim"), 50, R.drawable.ic_coin));

        rewardsAdapter.submitList(tasksRewards);

        updateDaysCountUI();
    }

    private void setDataUI() {
        totals = rewardManager.getPoints();
        binding.totalPoints.setText(String.format("+%d %s", totals, totals > 1 ? "points" : "point"));

        dailyAdapter.setOnItemClickListener((item, position) -> {
            List<ActivitiesModel> currentList = dailyAdapter.getCurrentList();

            if (!rewardManager.canClaim(item.getId())) {
                Toast.makeText(this, "Already Claimed!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (rewardManager.hasClaimedAnyToday(currentList)) {
                Toast.makeText(this, "Bukas na ulit ang ibang check-in!", Toast.LENGTH_SHORT).show();
                return;
            }

            totals += item.getCoins();
            rewardManager.savePoints(totals);
            rewardManager.markAsClaimed(item.getId());

            List<ActivitiesModel> updatedList = new ArrayList<>(currentList);
            ActivitiesModel updatedItem = new ActivitiesModel(item.getId(), item.getTitle(), "Claimed", item.getCoins(), item.getImageIcon());

            updatedList.set(position, updatedItem);
            dailyAdapter.submitList(updatedList);

            binding.totalPoints.setText(String.format("+%d %s", totals, totals > 1 ? "points" : "point"));
        });

        rewardsAdapter.setOnItemClickListener((item, position) -> {
            if (!rewardManager.canClaim(item.getId())) {
                return;
            }

            totals += item.getCoins();
            rewardManager.savePoints(totals);
            rewardManager.markAsClaimed(item.getId());

            loadData();

            binding.totalPoints.setText(String.format("+%d %s", totals, totals > 1 ? "points" : "point"));
        });
    }

    private void updateDaysCountUI() {
        int count = rewardManager.getClaimedDaysCount();
        String displayMessage = getString(R.string.you_ve_checkd_in_for) + " " + count + (count > 1 ? " days!" : " day!");
        binding.daysCount.setText(displayMessage);
    }
}