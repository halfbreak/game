package com.hlbk.game.printer;

import java.util.List;

public class RedPrinter<T> implements Printer<T> {

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    private final Printer<T> printer;

    public RedPrinter(Printer<T> printer) {
        this.printer = printer;
    }

    @Override
    public void present(List<T> list, int i) {
        System.out.print(ANSI_RED);
        printer.present(list, i);
        System.out.print(ANSI_RESET);
    }
}
