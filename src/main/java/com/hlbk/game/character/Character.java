package com.hlbk.game.character;

import com.hlbk.game.world.items.Fists;
import com.hlbk.game.world.items.Weapon;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.StringJoiner;

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

    //TODO move these two methods to a Codec class
    public String serialize() {
        StringJoiner stringJoiner = new StringJoiner(",");
        stringJoiner.add(characterName);
        stringJoiner.add(Long.toString(experience.getExperience()));
        stringJoiner.add(weapon.getClass().getCanonicalName());
        stringJoiner.add(currentChapter.toString());
        return stringJoiner.toString();
    }

    public static Character deserialize(String stringFromFile) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String[] fields = stringFromFile.split(",");
        String characterName = fields[0];
        long experience = Long.parseLong(fields[1]);
        Class<?> clazz = Class.forName(fields[2]);
        Constructor<?> constructor = clazz.getConstructor();
        Weapon instance = (Weapon) constructor.newInstance();
        int currentChapter = Integer.parseInt(fields[3]);
        return new Character(characterName, new Experience(experience), instance, currentChapter);
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
