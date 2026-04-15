package com.upreyvan.chronos.model;

public class RewardItem {
    private int iconRes;
    private String title;
    private int coins;
    private int progress;
    private int progressColor;

    public RewardItem(int iconRes, String title, int coins, int progress, int progressColor) {
        this.iconRes = iconRes;
        this.title = title;
        this.coins = coins;
        this.progress = progress;
        this.progressColor = progressColor;
    }

    // Getters
    public int getIconRes() { return iconRes; }
    public String getTitle() { return title; }
    public int getCoins() { return coins; }
    public int getProgress() { return progress; }
    public int getProgressColor() { return progressColor; }
}