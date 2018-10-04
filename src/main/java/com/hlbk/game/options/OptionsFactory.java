package com.hlbk.game.options;

import com.hlbk.game.character.CharacterCodec;
import com.hlbk.game.character.CharacterContainer;
import com.hlbk.game.options.game.ExploreOption;
import com.hlbk.game.options.game.FightOption;
import com.hlbk.game.options.game.SaveOption;
import com.hlbk.game.options.game.WhoAmIOption;
import com.hlbk.game.options.general.ExitGameOption;
import com.hlbk.game.options.login.CreateCharacterOption;
import com.hlbk.game.options.login.LoadCharacterOption;
import com.hlbk.game.story.Exploring;
import com.hlbk.game.world.Fighting;

import java.util.ArrayList;
import java.util.List;

public class OptionsFactory {

    private final Exploring exploring;
    private final CharacterContainer characterContainer;
    private final Fighting fighting;
    private final CharacterCodec characterCodec;

    public OptionsFactory(Exploring exploring,
                          CharacterContainer characterContainer,
                          Fighting fighting, CharacterCodec characterCodec) {
        this.exploring = exploring;
        this.characterContainer = characterContainer;
        this.fighting = fighting;
        this.characterCodec = characterCodec;
    }

    public List<Option> getLoginOptions() {
        List<Option> options = new ArrayList<>();
        options.add(new CreateCharacterOption(characterContainer));
        options.add(new LoadCharacterOption(characterContainer, characterCodec));
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
        options.add(new SaveOption(characterContainer, characterCodec));
        options.add(new ExitGameOption());
        return options;
    }
}
