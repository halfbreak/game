package com.hlbk.game.options.game;

import com.hlbk.game.character.Character;
import com.hlbk.game.options.Option;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class WhoAmIOption implements Option {

    private final Supplier<Character> characterSupplier;

    public WhoAmIOption(Supplier<Character> characterSupplier) {
        this.characterSupplier = characterSupplier;
    }

    @Override
    public String choice() {
        return "Who am I?";
    }

    @Override
    public List<String> present() {
        return Collections.singletonList(characterSupplier.get().toString());
    }

    @Override
    public void call() {

    }
}
