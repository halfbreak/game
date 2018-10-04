package com.hlbk.game.world.monsters;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class RandomMonsterFactory implements Supplier<Monster> {

    private final Random random;
    private final List<Monster> monsters;

    public RandomMonsterFactory(Random random) {
        this.random = random;
        monsters = new ArrayList<>();
    }

    @Override
    public Monster get() {
        if (monsters.size() == 0) {
            throw new IllegalArgumentException("No monsters were registered.");
        }

        int index = random.nextInt(monsters.size());
        return monsters.get(index);
    }

    public void register(Monster monster) {
        monsters.add(monster);
    }
}
