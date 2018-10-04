package com.hlbk.game.story.chapters.requirements;

import com.hlbk.game.character.Character;

public class ExperienceRequirement implements Requirement {

    private final long requiredExperience;

    public ExperienceRequirement(long requiredExperience) {
        this.requiredExperience = requiredExperience;
    }

    @Override
    public boolean isSatisfied(Character character) {
        return character.getExperience() >= requiredExperience;
    }
}
