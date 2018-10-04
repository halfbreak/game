package com.hlbk.game.story.chapters;

import java.util.ArrayList;
import java.util.List;

public class Chapter5 implements Chapter {
    @Override
    public List<String> execution() {
        List<String> list = new ArrayList<>();
        list.add("You run at the top of your power.");
        list.add("The monster looks back at you.");
        list.add("Its immense tentacles grab you throw you into the ground.");
        list.add("You fade out of consciousness.");
        list.add("");
        list.add("You dream you are swimming.");
        return list;
    }
}
