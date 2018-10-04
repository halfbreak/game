package com.hlbk.game.story.chapters;

import com.hlbk.game.character.Character;
import com.hlbk.game.story.chapters.requirements.Requirement;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RequirementValidatorTest {

    @Mock
    private Requirement validRequirement;
    @Mock
    private Requirement invalidRequirement;
    @Mock
    private Character character;

    @Before
    public void init() {
        when(validRequirement.isSatisfied(character)).thenReturn(true);
        when(invalidRequirement.isSatisfied(character)).thenReturn(false);
    }

    @Test
    public void shouldBeValidForOneRequirement() {
        RequirementValidator validator = new RequirementValidator();
        boolean valid = validator.validate(singletonList(validRequirement), character);
        assertThat(valid).isTrue();
    }

    @Test
    public void shouldBeValidForMultipleRequirement() {
        RequirementValidator validator = new RequirementValidator();
        List<Requirement> requirements = new ArrayList<>();
        requirements.add(validRequirement);
        requirements.add(validRequirement);
        boolean valid = validator.validate(requirements, character);
        assertThat(valid).isTrue();
    }

    @Test
    public void shouldBeInvalidForOneRequirement() {
        RequirementValidator validator = new RequirementValidator();
        boolean valid = validator.validate(singletonList(invalidRequirement), character);
        assertThat(valid).isFalse();
    }

    @Test
    public void shouldBeInvalidForMultipleRequirement() {
        RequirementValidator validator = new RequirementValidator();
        List<Requirement> requirements = new ArrayList<>();
        requirements.add(invalidRequirement);
        requirements.add(invalidRequirement);
        boolean valid = validator.validate(requirements, character);
        assertThat(valid).isFalse();
    }

    @Test
    public void shouldBeValidForMultipleRequirementMixed() {
        RequirementValidator validator = new RequirementValidator();
        List<Requirement> requirements = new ArrayList<>();
        requirements.add(validRequirement);
        requirements.add(invalidRequirement);
        boolean valid = validator.validate(requirements, character);
        assertThat(valid).isFalse();
    }
}