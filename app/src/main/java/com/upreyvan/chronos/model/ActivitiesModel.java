package com.upreyvan.chronos.model;

import java.util.Objects;

public class ActivitiesModel {
    private int id;
    private String title;
    private String description;
    private int coins;
    private int imageIcon;

    public ActivitiesModel(int id, String title, String description, int coins, int imageIcon) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.coins = coins;
        this.imageIcon = imageIcon;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
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
        ActivitiesModel that = (ActivitiesModel) o;
        return id == that.id &&
                coins == that.coins &&
                imageIcon == that.imageIcon &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, coins, imageIcon);
    }
}