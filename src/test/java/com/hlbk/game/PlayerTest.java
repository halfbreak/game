package com.hlbk.game;

import com.hlbk.game.character.Character;
import com.hlbk.game.character.CharacterContainer;
import com.hlbk.game.options.Option;
import com.hlbk.game.options.OptionExecutor;
import com.hlbk.game.options.OptionsFactory;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlayerTest {

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Mock
    private OptionsFactory optionsFactory;
    @Mock
    private OptionExecutor optionExecutor;
    @Mock
    private CharacterContainer characterContainer;
    @Mock
    private Option option;
    @Mock
    private Character character;

    @Test
    public void shouldLoginAndCreateCharacter() {
        List<Option> loginOptions = Collections.singletonList(option);
        systemInMock.provideLines("1", "MyCharacter");
        when(optionsFactory.getLoginOptions()).thenReturn(loginOptions);
        when(characterContainer.get()).thenReturn(character);

        Player player = new Player(characterContainer, optionsFactory, optionExecutor);
        Character login = player.login();
        verify(optionsFactory).getLoginOptions();
        verify(optionExecutor).execute(loginOptions);
        assertThat(login).isEqualTo(character);
    }
}
