package com.upreyvan.chronos.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.upreyvan.chronos.base.BaseAdapter;
import com.upreyvan.chronos.databinding.ItemCheckinCardBinding;
import com.upreyvan.chronos.databinding.ItemDailyRewardsCardBinding;
import com.upreyvan.chronos.model.ActivitiesModel;
import com.upreyvan.chronos.util.Utils;

public class DailyRewardsAdapter extends BaseAdapter<ActivitiesModel, ItemDailyRewardsCardBinding> {

    public DailyRewardsAdapter() {
        super(new DiffUtil.ItemCallback<ActivitiesModel>() {
            @Override
            public boolean areItemsTheSame(@NonNull ActivitiesModel oldItem, @NonNull ActivitiesModel newItem) {
                return oldItem.getId() == newItem.getId();
            }

            @Override
            public boolean areContentsTheSame(@NonNull ActivitiesModel oldItem, @NonNull ActivitiesModel newItem) {
                return oldItem.equals(newItem);
            }
        });
    }

    @Override
    protected ItemDailyRewardsCardBinding createBinding(LayoutInflater inflater, ViewGroup parent, int viewType) {
        return ItemDailyRewardsCardBinding.inflate(inflater, parent, false);
    }

    @Override
    protected void bind(ItemDailyRewardsCardBinding binding, ActivitiesModel item, int position) {
        String formattedCoins = Utils.getFormattedCoins(item.getCoins());
        String label = (item.getCoins() <= 1) ? "point" : "points";

        binding.coins.setText(String.format("+ %s %s", formattedCoins, label));
        binding.title.setText(item.getTitle());
        binding.icon.setImageResource(item.getImageIcon());
        binding.watch.setText(item.getDescription());

        binding.watch.setOnClickListener(v -> {
            if (getOnItemClickListener() != null) {
                getOnItemClickListener().onClick(item, position);
            }
        });

    }

    //Avoid card clicking
//    @Override
//    public void onBindViewHolder(@NonNull BaseViewHolder<ItemCheckinCardBinding> holder, int position) {
//        bind(holder.binding, getItem(position), position);
//        holder.itemView.setOnClickListener(null);
//    }
}