package me.nerminsehic.item89;

import java.util.Arrays;

// Enum singleton - the preferred approach
public enum EnumElvis {
    INSTANCE;

    private String[] favoriteSongs = {
            "Hound Dog", "Heartbreak Hotel"
    };

    public void printFavourites() {
        System.out.println(Arrays.toString(favoriteSongs));
    }
}
