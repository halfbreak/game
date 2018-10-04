package com.hlbk.game;

import com.hlbk.game.character.Character;
import com.hlbk.game.options.Option;
import com.hlbk.game.options.OptionExecutor;
import com.hlbk.game.options.OptionsFactory;

import java.util.List;
import java.util.function.Supplier;

public class Player {

    private final Supplier<Character> characterContainer;
    private final OptionsFactory optionsFactory;
    private final OptionExecutor optionExecutor;

    public Player(Supplier<Character> characterContainer,
                  OptionsFactory optionsFactory,
                  OptionExecutor optionExecutor) {
        this.characterContainer = characterContainer;
        this.optionsFactory = optionsFactory;
        this.optionExecutor = optionExecutor;
    }

    public Character login() {
        System.out.println("Welcome!");
        System.out.println("What would you like to do?");
        System.out.println();

        List<Option> options = optionsFactory.getLoginOptions();
        optionExecutor.execute(options);

        return characterContainer.get();
    }
}
