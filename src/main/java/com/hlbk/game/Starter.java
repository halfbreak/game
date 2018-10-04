package com.hlbk.game;

import com.hlbk.game.character.Character;
import com.hlbk.game.character.CharacterContainer;
import com.hlbk.game.options.OptionChoicesPrinter;
import com.hlbk.game.options.OptionExecutor;
import com.hlbk.game.options.OptionsFactory;
import com.hlbk.game.options.OptionsPrinter;
import com.hlbk.game.printer.BlueChoicePrinter;
import com.hlbk.game.printer.RedPrinter;
import com.hlbk.game.story.ChapterPrinter;
import com.hlbk.game.story.Exploration;

public class Starter {

    public static void main(String[] args) {
        CharacterContainer characterContainer = new CharacterContainer();
        ChapterPrinter chapterPrinter = new ChapterPrinter();
        Exploration exploration = new Exploration(characterContainer, new RedPrinter<>(chapterPrinter));
        OptionsFactory optionsFactory = new OptionsFactory(exploration, characterContainer);
        OptionsPrinter optionsPrinter = new OptionsPrinter();
        OptionChoicesPrinter optionChoicesPrinter = new OptionChoicesPrinter();
        OptionExecutor optionExecutor = new OptionExecutor(optionsPrinter,
                new BlueChoicePrinter<>(optionChoicesPrinter));

        Player player = new Player(characterContainer, optionsFactory, optionExecutor);
        Character character = player.login();
        Game game = new Game(optionsFactory, optionExecutor, character);
        game.start();
    }
}
