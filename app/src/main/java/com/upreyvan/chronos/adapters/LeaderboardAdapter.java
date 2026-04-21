package com.upreyvan.chronos.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.upreyvan.chronos.base.BaseAdapter;
import com.upreyvan.chronos.databinding.ActivityLeaderboardBinding;
import com.upreyvan.chronos.databinding.ItemGameCardBinding;
import com.upreyvan.chronos.databinding.ItemLeaderboardUserBinding;
import com.upreyvan.chronos.model.LeaderBoardModel;
import com.upreyvan.chronos.model.TopGamesModel;
import com.upreyvan.chronos.util.Utils;

public class LeaderboardAdapter extends BaseAdapter<LeaderBoardModel, ItemLeaderboardUserBinding> {

    public LeaderboardAdapter() {
        super(new DiffUtil.ItemCallback<LeaderBoardModel>() {
            @Override
            public boolean areItemsTheSame(@NonNull LeaderBoardModel oldItem, @NonNull LeaderBoardModel newItem) {
                return oldItem.getId() == newItem.getId();
            }

            @Override
            public boolean areContentsTheSame(@NonNull LeaderBoardModel oldItem, @NonNull LeaderBoardModel newItem) {
                return oldItem.equals(newItem);
            }
        });
    }

    @Override
    protected ItemLeaderboardUserBinding createBinding(LayoutInflater inflater, ViewGroup parent, int viewType) {
        return ItemLeaderboardUserBinding.inflate(inflater, parent, false);
    }

    @Override
    protected void bind(ItemLeaderboardUserBinding binding, LeaderBoardModel item, int position) {
        binding.rank.setText(String.valueOf(item.getRank()));
        binding.name.setText(item.getTitle());
        binding.points.setText(Utils.getFormattedCoins(item.getCoins()));
        binding.avatar.setImageResource(item.getImageIcon());

    }
}