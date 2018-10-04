package com.hlbk.game.options.login;

import com.hlbk.game.character.Character;
import com.hlbk.game.character.CharacterCodec;
import com.hlbk.game.character.CharacterContainer;
import com.hlbk.game.options.Option;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LoadCharacterOption implements Option {

    private final CharacterContainer characterContainer;
    private final CharacterCodec characterCodec;

    public LoadCharacterOption(CharacterContainer characterContainer, CharacterCodec characterCodec) {
        this.characterContainer = characterContainer;
        this.characterCodec = characterCodec;
    }

    @Override
    public String choice() {
        return "Load a character";
    }

    @Override
    public List<String> present() {
        List<String> list = new ArrayList<>();
        list.add("What is the path of your save game?");
        return list;
    }

    @Override
    public void call() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        String fileLocation = scanner.next();

        Path path = Paths.get(fileLocation);
        if (!path.toFile().exists()) {
            throw new IllegalArgumentException("No such file!");
        }

        try {
            String stringFromFile = Files.lines(path).collect(
                    Collectors.joining());
            Character character = characterCodec.deserialize(stringFromFile);
            characterContainer.update(character);
        } catch (IOException | InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
