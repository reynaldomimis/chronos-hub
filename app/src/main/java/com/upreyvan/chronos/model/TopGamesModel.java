package com.upreyvan.chronos.model;

import java.util.Objects;

public class TopGamesModel {
    private int id;
    private String title;
    private int coins;
    private int imageIcon;

    public TopGamesModel(int id, String title, int coins, int imageIcon) {
        this.id = id;
        this.title = title;
        this.coins = coins;
        this.imageIcon = imageIcon;
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
        TopGamesModel that = (TopGamesModel) o;
        return id == that.id &&
                coins == that.coins &&
                imageIcon == that.imageIcon &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, coins, imageIcon);
    }
}