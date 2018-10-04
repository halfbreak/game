package com.hlbk.game.story.chapters;

import java.util.ArrayList;
import java.util.List;

public class Chapter2 implements Chapter {

    @Override
    public List<String> execution() {
        List<String> chapters = new ArrayList<>();
        chapters.add("You keep running.");
        chapters.add("There are toucans flying over your head, raccoons by your feet.");
        chapters.add("You get to a great white stone.");
        return chapters;
    }
}
