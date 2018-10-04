package com.hlbk.game.story.chapters;

import com.hlbk.game.character.Character;
import com.hlbk.game.story.chapters.requirements.Requirement;

import java.util.List;

public class RequirementValidator {

    public boolean validate(List<Requirement> requirements, Character character) {
        return requirements
                .stream()
                .allMatch(requirement -> requirement.isSatisfied(character));
    }
}
