package com.hlbk.game.options;

import java.util.List;

public interface Option {
    String choice();

    List<String> present();

    void call();
}
