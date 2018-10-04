package com.hlbk.game.character;

import com.hlbk.game.world.items.Fists;
import com.hlbk.game.world.items.Weapon;

public class Character {

    private final String characterName;
    private final Experience experience;
    private final Weapon weapon;
    private Integer currentChapter = 0;

    public Character(String characterName) {
        this.characterName = characterName;
        this.experience = new Experience(0);
        this.weapon = new Fists();
    }

    public Character(String characterName, Experience experience, Weapon weapon, Integer currentChapter) {
        this.characterName = characterName;
        this.experience = experience;
        this.weapon = weapon;
        this.currentChapter = currentChapter;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCurrentChapter(Integer index) {
        this.currentChapter = index;
    }

    public String describeWeapon() {
        return weapon.getDescription();
    }

    public String useWeapon() {
        return weapon.getName();
    }

    public void learn(int exp) {
        experience.increase(exp);
    }

    public long getExperience() {
        return experience.getExperience();
    }

    Weapon getWeapon() {
        return weapon;
    }

    Integer getCurrentChapter() {
        return currentChapter;
    }

    @Override
    public String toString() {
        return "Character{" +
                "characterName='" + characterName + '\'' +
                ", weapon=" + weapon +
                ", experience=" + experience +
                ", currentChapter=" + currentChapter +
                '}';
    }
}
