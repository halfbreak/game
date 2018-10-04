package com.hlbk.game.story;

import com.hlbk.game.character.Character;
import com.hlbk.game.printer.Printer;
import com.hlbk.game.story.chapters.Chapter;
import com.hlbk.game.story.chapters.RequirementValidator;
import com.hlbk.game.story.chapters.requirements.Requirement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ExploringTest {
    @Mock
    private Character character;
    @Mock
    private Printer<Chapter> chapterPrinter;
    @Mock
    private RequirementValidator requirementValidator;
    @Mock
    private Requirement requirement;
    @Mock
    private Chapter chapter;

    @Test
    public void shouldExploreAndGoToNextChapterAndReset() {
        List<Requirement> requirements = Collections.singletonList(requirement);
        when(requirementValidator.validate(requirements, character)).thenReturn(true);
        when(chapter.getRequirements()).thenReturn(requirements);

        Exploring exploring = new Exploring(() -> character, chapterPrinter, requirementValidator);
        exploring.register(chapter);

        exploring.execute();
        verify(character, times(2)).setCurrentChapter(0);
        assertThat(exploring.hasStartedExploration()).isFalse();
    }

    @Test
    public void shouldExploreAndGoToNextChapter() {
        List<Requirement> requirements = Collections.singletonList(requirement);
        when(requirementValidator.validate(requirements, character)).thenReturn(true);
        when(chapter.getRequirements()).thenReturn(requirements);

        Exploring exploring = new Exploring(() -> character, chapterPrinter, requirementValidator);
        exploring.register(chapter);
        exploring.register(chapter);
        exploring.register(chapter);

        exploring.execute();
        verify(character).setCurrentChapter(0);
        exploring.execute();
        verify(character).setCurrentChapter(1);
    }

    @Test
    public void shouldNotGoToNextChapterWhenDoesNotFulfilRequirement() {
        List<Requirement> requirements = Collections.singletonList(requirement);
        when(requirementValidator.validate(requirements, character)).thenReturn(false);
        when(chapter.getRequirements()).thenReturn(requirements);

        Exploring exploring = new Exploring(() -> character, chapterPrinter, requirementValidator);
        exploring.register(chapter);

        exploring.execute();
        verify(character, times(0)).setCurrentChapter(0);
    }
}