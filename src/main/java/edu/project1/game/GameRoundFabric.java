package edu.project1.game;

public class GameRoundFabric {
    private final GameOptions options;

    public GameRoundFabric(GameOptions options) {
        this.options = options;
    }

    public GameRound create(String word) {
        return new GameRound(word, options);
    }
}
