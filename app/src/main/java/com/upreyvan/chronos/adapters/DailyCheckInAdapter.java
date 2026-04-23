package com.upreyvan.chronos.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.upreyvan.chronos.base.BaseAdapter;
import com.upreyvan.chronos.databinding.ItemCheckinCardBinding;
import com.upreyvan.chronos.model.ActivitiesModel;
import com.upreyvan.chronos.util.Utils;

public class DailyCheckInAdapter extends BaseAdapter<ActivitiesModel, ItemCheckinCardBinding> {

    public DailyCheckInAdapter() {
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
    protected ItemCheckinCardBinding createBinding(LayoutInflater inflater, ViewGroup parent, int viewType) {
        return ItemCheckinCardBinding.inflate(inflater, parent, false);
    }

    @Override
    protected void bind(ItemCheckinCardBinding binding, ActivitiesModel item, int position) {
        binding.day.setText(item.getTitle());
        binding.points.setText(String.format("+%s",  Utils.getFormattedCoins(item.getCoins())));
        binding.icon.setImageResource(item.getImageIcon());

        binding.checkinCard.setOnClickListener(v -> {
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