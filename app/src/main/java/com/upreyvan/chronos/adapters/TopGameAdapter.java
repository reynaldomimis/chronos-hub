package com.upreyvan.chronos.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.upreyvan.chronos.base.BaseAdapter;
import com.upreyvan.chronos.databinding.ItemGameCardBinding;
import com.upreyvan.chronos.model.TopGamesModel;
import com.upreyvan.chronos.util.Utils;

public class TopGameAdapter extends BaseAdapter<TopGamesModel, ItemGameCardBinding> {

    public TopGameAdapter() {
        super(new DiffUtil.ItemCallback<TopGamesModel>() {
            @Override
            public boolean areItemsTheSame(@NonNull TopGamesModel oldItem, @NonNull TopGamesModel newItem) {
                return oldItem.getId() == newItem.getId();
            }

            @Override
            public boolean areContentsTheSame(@NonNull TopGamesModel oldItem, @NonNull TopGamesModel newItem) {
                return oldItem.equals(newItem);
            }
        });
    }

    @Override
    protected ItemGameCardBinding createBinding(LayoutInflater inflater, ViewGroup parent, int viewType) {
        return ItemGameCardBinding.inflate(inflater, parent, false);
    }

    @Override
    protected void bind(ItemGameCardBinding binding, TopGamesModel item, int position) {
        binding.title.setText(item.getTitle());
        binding.coins.setText(Utils.getFormattedCoins(item.getCoins()));
        binding.icon.setImageResource(item.getImageIcon());
    }
}