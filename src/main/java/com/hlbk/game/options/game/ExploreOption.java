package com.hlbk.game.options.game;

import com.hlbk.game.options.Option;
import com.hlbk.game.story.Exploring;

import java.util.ArrayList;
import java.util.List;

public class ExploreOption implements Option {

    private final Exploring exploring;

    public ExploreOption(Exploring exploring) {
        this.exploring = exploring;
    }

    @Override
    public String choice() {
        return "Explore the world.";
    }

    @Override
    public List<String> present() {
        return new ArrayList<>();
    }

    @Override
    public void call() {
        exploring.execute();
    }
}
