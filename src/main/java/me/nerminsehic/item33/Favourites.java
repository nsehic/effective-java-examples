package me.nerminsehic.item33;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
    * When a class literal is passed among methods to communicate
    * both compile-time and runtime type information, it is called
    * a type token [Bracha04]
    * */
public class Favourites {

    private Map<Class<?>, Object> favourites = new HashMap<>();

    public <T> void putFavourite(Class<T> type, T instance) {
        favourites.put(Objects.requireNonNull(type), instance);
    }

    public <T> T getFavourite(Class<T> type) {
        return type.cast(favourites.get(type));
    }

    public static void main(String[] args) {
        Favourites f = new Favourites();
        f.putFavourite(String.class, "Java");
        f.putFavourite(Integer.class, 5);

        String firstFavourite = f.getFavourite(String.class);
        Integer secondFavourite = f.getFavourite(Integer.class);

        System.out.println(firstFavourite);
        System.out.println(secondFavourite);
    }
}
