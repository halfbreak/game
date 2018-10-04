package com.hlbk.game.options;

import com.hlbk.game.character.Character;
import com.hlbk.game.character.CharacterContainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateCharacterOption implements Option {

    private final CharacterContainer characterContainer;

    public CreateCharacterOption(CharacterContainer characterContainer) {
        this.characterContainer = characterContainer;
    }

    @Override
    public String choice() {
        return "Create a new character.";
    }

    @Override
    public List<String> present() {
        List<String> list = new ArrayList<>();
        list.add("What is the name of your character?");
        return list;
    }

    @Override
    public void call() {
        Scanner scanner = new Scanner(System.in);
        String characterName = scanner.next();
        characterContainer.update(new Character(characterName));
    }
}
