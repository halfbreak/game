package com.hlbk.game.story.chapters;

import java.util.ArrayList;
import java.util.List;

public class Chapter1 implements Chapter {

    @Override
    public List<String> execution() {
        List<String> chapters = new ArrayList<>();
        chapters.add("You run through the water until you reach a beach.");
        chapters.add("You are wet and tired. You keep on walking.");
        chapters.add("You get to a forest.");
        chapters.add("Behind you there are steps.");
        chapters.add("Loud steps.");
        chapters.add("Who are they from?");
        return chapters;
    }
}
