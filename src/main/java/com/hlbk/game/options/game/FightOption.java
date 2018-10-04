package com.hlbk.game.options.game;

import com.hlbk.game.character.Character;
import com.hlbk.game.options.Option;
import com.hlbk.game.world.Fighting;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class FightOption implements Option {

    private final Supplier<Character> characterContainer;
    private final Fighting fighting;

    public FightOption(Supplier<Character> characterContainer,
                       Fighting fighting) {
        this.characterContainer = characterContainer;
        this.fighting = fighting;
    }

    @Override
    public String choice() {
        return "Fight!";
    }

    @Override
    public List<String> present() {
        List<String> list = new ArrayList<>();
        list.add("Again with the footsteps...");
        list.add("You turn around and face them.");
        return list;
    }

    @Override
    public void call() {
        fighting.run();
    }
}
