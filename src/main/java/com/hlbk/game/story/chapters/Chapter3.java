package com.hlbk.game.story.chapters;

import java.util.ArrayList;
import java.util.List;

public class Chapter3 implements Chapter {
    @Override
    public List<String> execution() {
        List<String> list = new ArrayList<>();
        list.add("You approach the stone.");
        list.add("You can see your face reflected back at. But you do not recognize it.");
        list.add("Salty water runs down your face, but if it is tears or sea water you do not know.");
        list.add("You move past it and you see a city.");
        return list;
    }
}
