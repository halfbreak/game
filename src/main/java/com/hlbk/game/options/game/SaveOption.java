package com.hlbk.game.options.game;

import com.hlbk.game.character.Character;
import com.hlbk.game.character.CharacterCodec;
import com.hlbk.game.options.Option;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class SaveOption implements Option {

    private final Supplier<Character> characterSupplier;
    private final CharacterCodec characterCodec;

    public SaveOption(Supplier<Character> characterSupplier, CharacterCodec characterCodec) {
        this.characterSupplier = characterSupplier;
        this.characterCodec = characterCodec;
    }

    @Override
    public String choice() {
        return "Save the game.";
    }

    @Override
    public List<String> present() {
        return Collections.emptyList();
    }

    @Override
    public void call() {
        Character character = characterSupplier.get();

        String sanitizedName = character.getCharacterName().replaceAll(" ", "");
        Path path = Paths.get(sanitizedName + ".save");

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(characterCodec.serialize(character));
            System.out.println("The game was saved to " + path.getFileName().toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error saving the file: " + e.getMessage());
        }
    }
}
