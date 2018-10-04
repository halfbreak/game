# Game

## Running the code

`./gradlew build && java -jar build/libs/game-0.1.0-SNAPSHOT.jar`

## The game

It is a very simple command line based game. You are given options and must choose between them.
There are no major decisions and the story line is made to be linear.

You can save the game and load it back by passing the path to the save file.

## Extending the game

- Adding new options to the menus is easy, just create a new `Option` and add it to desired location in `OptionFactory`.
- Adding new chapters to the story is easy, just create a new `Chapter` and register it in `Exploring`.
- Want to switch how to serialize and deserialize a character? Just switch the `CharacterCodec`.


## Improvements
- `Character` should have its state in a `CharacterState` object.
- Extract `Scanner` to be passed by constructor to all the classes.
- Minimize the classes with side effects, less `System.out.println` everywhere 

## Features to add
- Add nested options for stories - a game is more fun when what you do has an impact.
- Add a story graph, a chapter can lead to two different ones depending on a choice.
- `Monster`s should have a reward, different types of items instead of only experience.
