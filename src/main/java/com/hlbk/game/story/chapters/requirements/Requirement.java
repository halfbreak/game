package com.hlbk.game.story.chapters.requirements;

import com.hlbk.game.character.Character;

public interface Requirement {
    boolean isSatisfied(Character character);
}
