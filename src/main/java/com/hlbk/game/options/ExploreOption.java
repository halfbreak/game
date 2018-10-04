package com.hlbk.game.options;

import com.hlbk.game.story.Exploration;

import java.util.ArrayList;
import java.util.List;

public class ExploreOption implements Option {

    private final Exploration exploration;

    public ExploreOption(Exploration exploration) {
        this.exploration = exploration;
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
        exploration.execute();
    }
}
