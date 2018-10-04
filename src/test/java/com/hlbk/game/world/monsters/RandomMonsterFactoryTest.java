package com.hlbk.game.world.monsters;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RandomMonsterFactoryTest {

    @Mock
    private Random random;

    @Test
    public void shouldGetARandomMonster() {
        RandomMonsterFactory factory = new RandomMonsterFactory(random);
        Zombie zombie = new Zombie();
        factory.register(zombie);
        when(random.nextInt(anyInt())).thenReturn(0);
        Monster monster = factory.get();
        assertThat(zombie).isEqualTo(monster);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldAnExceptionWhenNoMonsterWasRegistered() {
        new RandomMonsterFactory(random).get();
    }
}