package com.upreyvan.chronos.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.upreyvan.chronos.base.BaseAdapter;
import com.upreyvan.chronos.databinding.ItemDailyTaskCardBinding;
import com.upreyvan.chronos.model.ActivitiesModel;
import com.upreyvan.chronos.util.Utils;

public class TaskAdapter extends BaseAdapter<ActivitiesModel, ItemDailyTaskCardBinding> {

    public TaskAdapter() {
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
    protected ItemDailyTaskCardBinding createBinding(LayoutInflater inflater, ViewGroup parent, int viewType) {
        return ItemDailyTaskCardBinding.inflate(inflater, parent, false);
    }

    @Override
    protected void bind(ItemDailyTaskCardBinding binding, ActivitiesModel item, int position) {
        binding.title.setText(item.getTitle());
        binding.description.setText(item.getDescription());
        binding.coins.setText(Utils.getFormattedCoins(item.getCoins()));
        binding.icon.setImageResource(item.getImageIcon());
    }
}