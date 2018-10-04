package com.hlbk.game.story.chapters;

import com.hlbk.game.story.chapters.requirements.Requirement;

import java.util.Collections;
import java.util.List;

public interface Chapter {
    List<String> execution();

    default List<Requirement> getRequirements() {
        return Collections.emptyList();
    }

    default String getFailedRequirementsMessage() {
        return "";
    }
}
