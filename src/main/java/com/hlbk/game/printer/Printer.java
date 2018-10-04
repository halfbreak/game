package com.hlbk.game.printer;

import java.util.List;

public interface Printer<T> {
    void present(List<T> list, int i);

    default void print(String s) {
        System.out.println(s);
    }
}
