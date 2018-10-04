package com.hlbk.game.story;

import com.hlbk.game.printer.Printer;
import com.hlbk.game.story.chapters.Chapter;

import java.util.List;

public class ChapterPrinter implements Printer<Chapter> {

    @Override
    public void present(List<Chapter> chapters, int i) {
        System.out.println();
        chapters.get(i).execution().forEach(this::print);
    }
}
