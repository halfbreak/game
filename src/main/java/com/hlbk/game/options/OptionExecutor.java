package com.hlbk.game.options;

import com.hlbk.game.printer.ChoicePrinter;
import com.hlbk.game.printer.Printer;

import java.util.List;
import java.util.Scanner;

public class OptionExecutor {
    private final Printer<Option> optionsPrinter;
    private final ChoicePrinter<Option> optionChoicesPrinter;

    public OptionExecutor(Printer<Option> optionsPrinter,
                          ChoicePrinter<Option> optionChoicesPrinter) {
        this.optionsPrinter = optionsPrinter;
        this.optionChoicesPrinter = optionChoicesPrinter;
    }

    public void execute(List<Option> options) {
        Scanner scanner = new Scanner(System.in);
        optionChoicesPrinter.print(options);
        int choice = scanner.nextInt();
        optionsPrinter.present(options, choice);
        options.get(choice - 1).call();
    }
}
