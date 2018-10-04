package com.hlbk.game.options;

import com.hlbk.game.character.CharacterContainer;
import com.hlbk.game.options.game.ExploreOption;
import com.hlbk.game.options.game.FightOption;
import com.hlbk.game.options.game.WhoAmIOption;
import com.hlbk.game.options.general.ExitGameOption;
import com.hlbk.game.options.login.CreateCharacterOption;
import com.hlbk.game.story.Exploring;
import com.hlbk.game.world.Fighting;

import java.util.ArrayList;
import java.util.List;

public class OptionsFactory {

    private final Exploring exploring;
    private final CharacterContainer characterContainer;
    private final Fighting fighting;

    public OptionsFactory(Exploring exploring,
                          CharacterContainer characterContainer,
                          Fighting fighting) {
        this.exploring = exploring;
        this.characterContainer = characterContainer;
        this.fighting = fighting;
    }

    public List<Option> getLoginOptions() {
        List<Option> options = new ArrayList<>();
        options.add(new CreateCharacterOption(characterContainer));
        options.add(new ExitGameOption());
        return options;
    }

    public List<Option> getGameOptions() {
        List<Option> options = new ArrayList<>();
        options.add(new ExploreOption(exploring));
        if (exploring.hasStartedExploration()) {
            options.add(new FightOption(characterContainer, fighting));
        }
        options.add(new WhoAmIOption(characterContainer));
        options.add(new ExitGameOption());
        return options;
    }
}
