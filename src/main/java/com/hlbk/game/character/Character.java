package com.hlbk.game.character;

public class Character {

    private final String characterName;
    private Integer currentChapter;

    public Character(String characterName) {
        this.characterName = characterName;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCurrentChapter(Integer index) {
        this.currentChapter = index;
    }
}
