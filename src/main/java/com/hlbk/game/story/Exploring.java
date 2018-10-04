package com.hlbk.game.story;

import com.hlbk.game.character.Character;
import com.hlbk.game.printer.Printer;
import com.hlbk.game.story.chapters.Chapter;
import com.hlbk.game.story.chapters.RequirementValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Exploring {

    private final Supplier<Character> characterContainer;
    private final Printer<Chapter> chapterPrinter;
    private final RequirementValidator requirementValidator;
    private final List<Chapter> chapters;

    private Integer index = 0;

    public Exploring(Supplier<Character> characterContainer,
                     Printer<Chapter> chapterPrinter,
                     RequirementValidator requirementValidator) {
        this.characterContainer = characterContainer;
        this.chapterPrinter = chapterPrinter;
        this.requirementValidator = requirementValidator;
        chapters = new ArrayList<>();
    }

    public void execute() {
        Chapter chapter = chapters.get(index);
        Character character = characterContainer.get();
        if (requirementValidator.validate(chapter.getRequirements(), character)) {
            chapterPrinter.present(chapters, index);
            character.setCurrentChapter(index);
            index++;
            if (index >= chapters.size()) {
                index = 0;
                character.setCurrentChapter(index);
            }
        } else {
            System.out.println(chapter.getFailedRequirementsMessage());
        }
    }

    public boolean hasStartedExploration() {
        return index > 0;
    }

    public void register(Chapter chapter) {
        chapters.add(chapter);
    }
}
