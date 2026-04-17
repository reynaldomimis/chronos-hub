package com.upreyvan.chronos.ui.rewards;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.upreyvan.chronos.R;
import com.upreyvan.chronos.model.RewardItem;

import java.util.ArrayList;
import java.util.List;

public class RewardsActivity extends AppCompatActivity {

    private RecyclerView recyclerRewards;
    private RewardsAdapter adapter;
    private List<RewardItem> rewardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewards);

        recyclerRewards = findViewById(R.id.recycler_rewards);

        // Sample Data
        rewardList = new ArrayList<>();
        rewardList.add(new RewardItem(
                R.drawable.diamond_24,
                "Play 8 Games",
                300,
                45,
                0xFF00E5FF));

        rewardList.add(new RewardItem(
                R.drawable.ic_coin,
                "Daily Streak",
                1000,
                100,
                0xFFBB86FC));

        adapter = new RewardsAdapter(this, rewardList);
        recyclerRewards.setLayoutManager(new LinearLayoutManager(this));
        recyclerRewards.setAdapter(adapter);

        findViewById(R.id.btn_back).setOnClickListener(v -> finish());
    }
}