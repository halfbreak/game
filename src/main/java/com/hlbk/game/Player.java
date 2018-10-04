package com.hlbk.game;

import com.hlbk.game.options.Option;
import com.hlbk.game.options.OptionExecutor;
import com.hlbk.game.options.OptionsFactory;

import java.util.List;

class Player {

    private final OptionsFactory optionsFactory;
    private final OptionExecutor optionExecutor;

    Player(OptionsFactory optionsFactory,
           OptionExecutor optionExecutor) {
        this.optionsFactory = optionsFactory;
        this.optionExecutor = optionExecutor;
    }

    void login() {
        System.out.println("Welcome!");
        System.out.println("What would you like to do?");
        System.out.println();

        List<Option> options = optionsFactory.getLoginOptions();
        optionExecutor.execute(options);
    }
}
