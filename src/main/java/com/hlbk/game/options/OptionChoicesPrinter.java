package com.hlbk.game.options;

import com.hlbk.game.printer.ChoicePrinter;

import java.util.List;

public class OptionChoicesPrinter implements ChoicePrinter<Option> {

    @Override
    public void print(List<Option> options) {
        System.out.println();
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + " " + options.get(i).choice());
        }
        System.out.println();
        System.out.println();
    }
}
