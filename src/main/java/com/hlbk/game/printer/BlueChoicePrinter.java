package com.hlbk.game.printer;

import java.util.List;

public class BlueChoicePrinter<T> implements ChoicePrinter<T> {

    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RESET = "\u001B[0m";

    private final ChoicePrinter<T> choicePrinter;

    public BlueChoicePrinter(ChoicePrinter<T> choicePrinter) {
        this.choicePrinter = choicePrinter;
    }

    @Override
    public void print(List<T> options) {
        System.out.print(ANSI_BLUE);
        choicePrinter.print(options);
        System.out.print(ANSI_RESET);
    }
}
