package com.upreyvan.chronos.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.upreyvan.chronos.model.ActivitiesModel;

import java.util.Calendar;
import java.util.List;

public class RewardManager {
    private static final String PREF_NAME = "DailyPrefs";
    private static final String KEY_LAST_CLAIM = "last_claim_day_";
    private static final String KEY_TOTAL_POINTS = "total_points";
    private final SharedPreferences prefs;

    public RewardManager(Context context) {
        this.prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public boolean canClaim(int taskId) {
        int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
        int lastClaimedDay = prefs.getInt(KEY_LAST_CLAIM + taskId, -1);
        return currentDay != lastClaimedDay;
    }

    public boolean hasClaimedAnyToday(List<ActivitiesModel> tasks) {
        for (ActivitiesModel task : tasks) {
            if (!canClaim(task.getId())) {
                return true;
            }
        }
        return false;
    }

    public void markAsClaimed(int taskId) {
        int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
        prefs.edit().putInt(KEY_LAST_CLAIM + taskId, currentDay).apply();
    }

    public int getPoints() {
        return prefs.getInt(KEY_TOTAL_POINTS, 0);
    }
    public void savePoints(int currentPoints) {
        prefs.edit().putInt(KEY_TOTAL_POINTS, currentPoints).apply();
    }

    public String getStatusForTask(int taskId, String defaultStatus) {
        if (!canClaim(taskId)) {
            return "Claimed";
        }
        return defaultStatus;
    }

    public boolean isItemEnabled(int taskId) {
        return canClaim(taskId);
    }

    public int getClaimedDaysCount() {
        int count = 1;
        for (int i = 1; i <= 7; i++) {
            if (!canClaim(i)) {
                count++;
            }
        }
        return Math.min(count, 7);
    }
}