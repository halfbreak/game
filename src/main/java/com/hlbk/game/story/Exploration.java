package com.hlbk.game.story;

import com.hlbk.game.character.Character;
import com.hlbk.game.printer.Printer;
import com.hlbk.game.story.chapters.Chapter;
import com.hlbk.game.story.chapters.Chapter1;
import com.hlbk.game.story.chapters.Chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Exploration {

    private final Supplier<Character> characterContainer;
    private final Printer<Chapter> chapterPrinter;
    private final List<Chapter> chapters;

    private Integer index = 0;

    public Exploration(Supplier<Character> characterContainer,
                       Printer<Chapter> chapterPrinter) {
        this.characterContainer = characterContainer;
        this.chapterPrinter = chapterPrinter;
        chapters = chapters();
    }

    public void execute() {
        chapterPrinter.present(chapters, index);
        characterContainer.get().setCurrentChapter(index);
        index++;
    }

    //TODO chapters can have requirements (e.g. amount of experience)
    //TODO in that case it doesn't advance to the next chapter and a message is shown
    //TODO Requirement is an interface and there should be NoRequirement and ExpRequirement, etc.

    //TODO add options relevant to each chapter? maybe as an execute

    private List<Chapter> chapters() {
        List<Chapter> chapters = new ArrayList<>();
        chapters.add(new Chapter1());
        chapters.add(new Chapter2());
        return chapters;
    }
}
