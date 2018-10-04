package com.hlbk.game;

import com.hlbk.game.character.CharacterCodec;
import com.hlbk.game.character.CharacterContainer;
import com.hlbk.game.options.OptionChoicesPrinter;
import com.hlbk.game.options.OptionExecutor;
import com.hlbk.game.options.OptionsFactory;
import com.hlbk.game.options.OptionsTextPrinter;
import com.hlbk.game.printer.BlueChoicePrinter;
import com.hlbk.game.printer.RedPrinter;
import com.hlbk.game.story.ChapterPrinter;
import com.hlbk.game.story.Exploring;
import com.hlbk.game.story.chapters.*;
import com.hlbk.game.world.Fighting;
import com.hlbk.game.world.monsters.Ghoul;
import com.hlbk.game.world.monsters.RandomMonsterFactory;
import com.hlbk.game.world.monsters.Zombie;

import java.util.Random;

public class Starter {

    public static void main(String[] args) {
        CharacterContainer characterContainer = new CharacterContainer();
        ChapterPrinter chapterPrinter = new ChapterPrinter();
        RequirementValidator requirementValidator = new RequirementValidator();
        RandomMonsterFactory randomMonsterFactory = initRandomMonsterFactory();
        OptionsTextPrinter optionsTextPrinter = new OptionsTextPrinter();
        OptionChoicesPrinter optionChoicesPrinter = new OptionChoicesPrinter();

        Exploring exploring = initExploring(characterContainer, chapterPrinter, requirementValidator);
        Fighting fighting = new Fighting(randomMonsterFactory, characterContainer);
        OptionsFactory optionsFactory = new OptionsFactory(exploring, characterContainer, fighting, new CharacterCodec());
        OptionExecutor optionExecutor = new OptionExecutor(optionsTextPrinter,
                new BlueChoicePrinter<>(optionChoicesPrinter));

        Player player = new Player(optionsFactory, optionExecutor);
        player.login();
        Game game = new Game(optionsFactory, optionExecutor);

        System.out.println("The adventure continues...");
        while (true) {
            game.step();
        }
    }

    private static Exploring initExploring(CharacterContainer characterContainer,
                                           ChapterPrinter chapterPrinter,
                                           RequirementValidator requirementValidator) {
        Exploring exploring = new Exploring(characterContainer,
                new RedPrinter<>(chapterPrinter),
                requirementValidator);
        exploring.register(new Chapter1());
        exploring.register(new Chapter2());
        exploring.register(new Chapter3());
        exploring.register(new Chapter4());
        return exploring;
    }

    private static RandomMonsterFactory initRandomMonsterFactory() {
        Random random = new Random();
        RandomMonsterFactory randomMonsterFactory = new RandomMonsterFactory(random);
        randomMonsterFactory.register(new Zombie());
        randomMonsterFactory.register(new Ghoul());
        return randomMonsterFactory;
    }
}
