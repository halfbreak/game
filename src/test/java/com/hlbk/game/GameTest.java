package com.hlbk.game;

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

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {
    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Mock
    private OptionsFactory optionsFactory;
    @Mock
    private OptionExecutor optionExecutor;
    @Mock
    private Option option;

    @Test
    public void hello() {
        systemInMock.provideLines("1");
        List<Option> optionList = Collections.singletonList(option);
        when(optionsFactory.getGameOptions()).thenReturn(optionList);
        Game game = new Game(optionsFactory, optionExecutor);
        game.step();
        verify(optionExecutor).execute(optionList);
    }
}