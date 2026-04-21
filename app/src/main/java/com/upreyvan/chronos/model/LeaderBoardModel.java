package com.upreyvan.chronos.model;

import java.util.Objects;

public class LeaderBoardModel {
    private int id;
    private String title;
    private int coins;
    private int imageIcon;
    private int rank;

    public LeaderBoardModel(int id, int rank, String title, int coins, int imageIcon) {
        this.id = id;
        this.rank = rank;
        this.title = title;
        this.coins = coins;
        this.imageIcon = imageIcon;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCoins() {
        return coins;
    }

    public int getImageIcon() {
        return imageIcon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeaderBoardModel that = (LeaderBoardModel) o;
        return id == that.id &&
                rank == that.rank &&
                coins == that.coins &&
                imageIcon == that.imageIcon &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rank, title, coins, imageIcon);
    }
}