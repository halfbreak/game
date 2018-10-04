package com.hlbk.game.world.monsters;

import java.util.Objects;

public class Zombie implements Monster {

    private final String name = "Zombie";
    private final int experience = 1;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getExperience() {
        return experience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monster monster = (Monster) o;
        return experience == monster.getExperience() &&
                Objects.equals(name, monster.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, experience);
    }
}
