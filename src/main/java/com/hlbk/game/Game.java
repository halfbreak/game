package com.hlbk.game;

import com.hlbk.game.character.Character;
import com.hlbk.game.options.Option;
import com.hlbk.game.options.OptionExecutor;
import com.hlbk.game.options.OptionsFactory;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class Game {

    private final OptionsFactory optionsFactory;
    private final OptionExecutor optionExecutor;
    private final Character character;
    //TODO character should follow the state pattern and have things in (CharacterState)?

    public Game(OptionsFactory optionsFactory, OptionExecutor optionExecutor, Character character) {
        this.optionsFactory = optionsFactory;
        this.optionExecutor = optionExecutor;
        this.character = requireNonNull(character, "A character must always be created for a game.");
    }

    public void start() {
        System.out.println("The adventure continues...");

        List<Option> options = optionsFactory.getGameOptions();
        while (true) {
            optionExecutor.execute(options);
        }
    }
}
