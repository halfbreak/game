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
        //TODO this assumes always a new character
        //TODO create a new constructor for loading a character
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
