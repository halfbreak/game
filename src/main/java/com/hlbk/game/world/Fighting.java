package com.hlbk.game.world;

import com.hlbk.game.character.Character;
import com.hlbk.game.world.monsters.Monster;
import com.hlbk.game.world.monsters.RandomMonsterFactory;

import java.util.function.Supplier;

public class Fighting {

    private final RandomMonsterFactory monsterFactory;
    private final Supplier<Character> characterContainer;

    public Fighting(RandomMonsterFactory monsterFactory,
                    Supplier<Character> characterContainer) {
        this.monsterFactory = monsterFactory;
        this.characterContainer = characterContainer;
    }

    public void run() {
        Monster monster = monsterFactory.get();
        Character character = characterContainer.get();
        System.out.println("In front of you stands a " + monster.getName());
        System.out.println("You have " + character.describeWeapon() + " to fight the " + monster.getName() + ".");
        System.out.println("You " + character.useWeapon() + " the " + monster.getName() + ".");
        System.out.println("He falls dead.");
        character.learn(monster.getExperience());
        System.out.println("You grew wiser with this encounter.");
    }
}
