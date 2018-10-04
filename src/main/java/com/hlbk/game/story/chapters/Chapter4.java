package com.hlbk.game.story.chapters;

import com.hlbk.game.story.chapters.requirements.ExperienceRequirement;
import com.hlbk.game.story.chapters.requirements.Requirement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Chapter4 implements Chapter {
    @Override
    public List<String> execution() {
        List<String> list = new ArrayList<>();
        list.add("You enter the city.");
        list.add("Anyone that ever lived here has been long gone.");
        list.add("In the end of the street you see movement.");
        list.add("You caught a glimpse of moving tentacles.");
        list.add("Now there is nothing there.");
        return list;
    }

    @Override
    public List<Requirement> getRequirements() {
        return Collections.singletonList(new ExperienceRequirement(3));
    }

    @Override
    public String getFailedRequirementsMessage() {
        return "You are not strong enough to enter the city yet.";
    }
}
