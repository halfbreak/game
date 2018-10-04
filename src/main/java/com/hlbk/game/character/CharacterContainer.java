package com.hlbk.game.character;

import java.util.function.Supplier;

public class CharacterContainer implements Supplier<Character> {

    private Character character;

    public void update(Character character) {
        this.character = character;
    }

    @Override
    public Character get() {
        return character;
    }
}
