package com.hlbk.game.character;

import com.hlbk.game.world.items.Weapon;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.StringJoiner;

public class CharacterCodec {

    public String serialize(Character character) {
        StringJoiner stringJoiner = new StringJoiner(",");
        stringJoiner.add(character.getCharacterName());
        stringJoiner.add(Long.toString(character.getExperience()));
        stringJoiner.add(character.getWeapon().getClass().getCanonicalName());
        stringJoiner.add(character.getCurrentChapter().toString());
        return stringJoiner.toString();
    }

    public Character deserialize(String stringFromFile) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String[] fields = stringFromFile.split(",");
        String characterName = fields[0];
        long experience = Long.parseLong(fields[1]);
        Class<?> clazz = Class.forName(fields[2]);
        Constructor<?> constructor = clazz.getConstructor();
        Weapon instance = (Weapon) constructor.newInstance();
        int currentChapter = Integer.parseInt(fields[3]);
        return new Character(characterName, new Experience(experience), instance, currentChapter);
    }
}
