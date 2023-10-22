package edu.project1.game.gameResults;

import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;


sealed class GuessResultBase implements GuessResult permits Win, Lose, SuccessfulGuess, FailedGuess {
    private final List<Character> unknownWord;
    private final String word;
    private final int remainingMisses;

    protected GuessResultBase(
        @NotNull List<Character> unknownWord,
        @NotNull String word,
        int remainingMisses
    ) {

        this.unknownWord = unknownWord;
        this.word = word;
        this.remainingMisses = remainingMisses;
    }

    @Override
    public List<Character> unknownWord() {
        return Collections.unmodifiableList(unknownWord);
    }

    @Override
    public int remainingMisses() {
        return remainingMisses;
    }

    @Override
    public @NotNull String word() {
        return word;
    }
}
