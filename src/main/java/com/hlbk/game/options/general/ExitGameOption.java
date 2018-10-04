package com.hlbk.game.options.general;

import com.hlbk.game.options.Option;

import java.util.ArrayList;
import java.util.List;

public class ExitGameOption implements Option {

    @Override
    public String choice() {
        return "Leave the game.";
    }

    @Override
    public List<String> present() {
        List<String> list = new ArrayList<>();
        list.add("The struggle will continue...");
        return list;
    }

    @Override
    public void call() {
        System.exit(0);
    }
}
