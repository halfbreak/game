package com.hlbk.game.world.items;

public class Fists implements Weapon {
    @Override
    public String getDescription() {
        return "only your fists";
    }

    @Override
    public String getName() {
        return "punch";
    }

    @Override
    public String toString() {
        return "Fists";
    }
}
