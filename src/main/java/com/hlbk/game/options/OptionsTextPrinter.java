package com.hlbk.game.options;

import com.hlbk.game.printer.Printer;

import java.util.List;

public class OptionsTextPrinter implements Printer<Option> {

    @Override
    public void present(List<Option> options, int i) {
        System.out.println();
        options.get(i - 1).present().forEach(System.out::println);
    }
}
