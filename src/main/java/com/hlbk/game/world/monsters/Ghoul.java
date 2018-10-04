package com.hlbk.game.world.monsters;

import java.util.Objects;

public class Ghoul implements Monster {

    private String name = "Ghoul";
    private int experience = 2;

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
        return getExperience() == monster.getExperience() &&
                Objects.equals(getName(), monster.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getExperience());
    }
}
