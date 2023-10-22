package edu.project1.game.gameResults;

import java.util.List;
import org.jetbrains.annotations.NotNull;

public final class FailedGuess extends GuessResultBase {
    public FailedGuess(@NotNull List<Character> unknownWord, @NotNull String word, int remainingMisses) {
        super(unknownWord, word, remainingMisses);
    }
}
