package me.nerminsehic.item37;

import java.util.*;
import java.util.stream.Collectors;

public class Plant {
    enum LifeCycle { ANNUAL, PERENNIAL, BIENNIAL };

    final String name;
    final LifeCycle lifeCycle;

    Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }

    private static Map<Plant.LifeCycle, Set<Plant>> arrangeGarden(Plant[] garden) {
         Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle =
                new EnumMap<>(Plant.LifeCycle.class);

        for(Plant.LifeCycle lc : Plant.LifeCycle.values())
            plantsByLifeCycle.put(lc, new HashSet<>());

        for(Plant p : garden)
            plantsByLifeCycle.get(p.lifeCycle).add(p);

        return plantsByLifeCycle;
    }

    private static Map<Plant.LifeCycle, Set<Plant>> arrangeGardenWithStream(Plant[] garden) {
        return Arrays.stream(garden)
                .collect(Collectors.groupingBy(p -> p.lifeCycle, () -> new EnumMap<>(LifeCycle.class), Collectors.toSet()));
    }

    public static void main(String[] args) {
        Plant[] garden = new Plant[] {
          new Plant("plant 1", LifeCycle.BIENNIAL),
          new Plant("plant 2", LifeCycle.ANNUAL),
          new Plant("plant 3", LifeCycle.PERENNIAL),
          new Plant("plant 4", LifeCycle.ANNUAL),
          new Plant("plant 5", LifeCycle.BIENNIAL),
          new Plant("plant 6", LifeCycle.PERENNIAL),
        };

        Map<Plant.LifeCycle, Set<Plant>> arrangedGarden = arrangeGarden(garden);

        System.out.println(arrangedGarden);
    }
}
