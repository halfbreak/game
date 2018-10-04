package com.hlbk.game.character;

import com.hlbk.game.world.items.Fists;
import com.hlbk.game.world.items.Weapon;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CharacterTest {

    @Test
    public void shouldSetCharacterName() {
        String characterName = "test";
        Character c = new Character(characterName);
        assertThat(c.getCharacterName()).isEqualTo(characterName);
    }

    @Test
    public void shouldStartWithZeroExperienceAndIncrease() {
        Character c = new Character("test");
        assertThat(c.getExperience()).isEqualTo(0);
        c.learn(1);
        assertThat(c.getExperience()).isEqualTo(1);
        c.learn(1);
        assertThat(c.getExperience()).isEqualTo(2);
    }

    @Test
    public void shouldStartWithFists() {
        Weapon weapon = new Fists();
        Character c = new Character("test");
        assertThat(c.describeWeapon()).isEqualTo(weapon.getDescription());
        assertThat(c.useWeapon()).isEqualTo(weapon.getName());
    }
}