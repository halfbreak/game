package com.hlbk.game.options;

import com.hlbk.game.character.CharacterContainer;
import com.hlbk.game.story.Exploration;

import java.util.ArrayList;
import java.util.List;

public class OptionsFactory {

    private final Exploration exploration;
    private final CharacterContainer characterContainer;

    public OptionsFactory(Exploration exploration, CharacterContainer characterContainer) {
        this.exploration = exploration;
        this.characterContainer = characterContainer;
    }

    public List<Option> getLoginOptions() {
        List<Option> options = new ArrayList<>();
        options.add(new CreateCharacterOption(characterContainer));
        options.add(new ExitGameOption());
        return options;
    }

    public List<Option> getGameOptions() {
        List<Option> options = new ArrayList<>();
        options.add(new ExploreOption(exploration));
        options.add(new ExitGameOption());
        return options;
    }
}
