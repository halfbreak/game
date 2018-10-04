package com.hlbk.game;

import com.hlbk.game.character.Character;
import com.hlbk.game.options.OptionExecutor;
import com.hlbk.game.options.OptionsFactory;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {
    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
    @Mock
    private Character character;
    @Mock
    private OptionsFactory optionsFactory;
    @Mock
    private OptionExecutor optionExecutor;

    @Test
    public void hello() {
        systemInMock.provideLines("1");
        Game game = new Game(optionsFactory, optionExecutor, character);
//        game.start();
    }
}