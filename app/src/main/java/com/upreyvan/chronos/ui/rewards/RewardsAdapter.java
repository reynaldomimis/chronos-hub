package com.upreyvan.chronos.ui.rewards;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;
import com.upreyvan.chronos.R;
import com.upreyvan.chronos.model.RewardItem;

import java.util.List;

public class RewardsAdapter extends RecyclerView.Adapter<RewardsAdapter.ViewHolder> {

    private Context context;
    private List<RewardItem> rewardList;

    public RewardsAdapter(Context context, List<RewardItem> rewardList) {
        this.context = context;
        this.rewardList = rewardList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_reward_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RewardItem item = rewardList.get(position);

        holder.icon.setImageResource(item.getIconRes());
        holder.tvTitle.setText(item.getTitle());
        holder.tvCoins.setText(String.valueOf(item.getCoins()));

        holder.progressBar.setProgress(item.getProgress());
        holder.progressBar.setProgressTintList(
                ColorStateList.valueOf(item.getProgressColor())
        );


        holder.progressBar.getProgressDrawable().setColorFilter(
                item.getProgressColor(), PorterDuff.Mode.SRC_IN);
    }

    @Override
    public int getItemCount() {
        return rewardList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView icon;
        TextView tvTitle, tvCoins;
        ProgressBar progressBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvCoins = itemView.findViewById(R.id.tv_coins);
            progressBar = itemView.findViewById(R.id.progress_bar);
        }
    }
}