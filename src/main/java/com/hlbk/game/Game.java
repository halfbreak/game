package com.hlbk.game;

import com.hlbk.game.options.OptionExecutor;
import com.hlbk.game.options.OptionsFactory;

class Game {

    private final OptionsFactory optionsFactory;
    private final OptionExecutor optionExecutor;

    Game(OptionsFactory optionsFactory, OptionExecutor optionExecutor) {
        this.optionsFactory = optionsFactory;
        this.optionExecutor = optionExecutor;
    }

    void step() {
        optionExecutor.execute(optionsFactory.getGameOptions());
    }
}
