package edu.project1.game;

import edu.project1.game.gameResults.FailedGuess;
import edu.project1.game.gameResults.GuessResult;
import edu.project1.game.gameResults.Lose;
import edu.project1.game.gameResults.SuccessfulGuess;
import edu.project1.game.gameResults.Win;
import java.util.ArrayList;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public class GameRound {
    private final String word;
    private final ArrayList<Character> unknownWord;
    private int remainingMisses;

    public String word() {
        return word;
    }

    public int remainingMisses() {
        return remainingMisses;
    }

    public GameRound(@NotNull String word, GameOptions options) {
        if (options.maxMisses <= 0) {
            throw new IllegalArgumentException();
        }
        this.word = word;
        remainingMisses = options.maxMisses;
        unknownWord = new ArrayList<>(word.length());
        for (int i = 0; i < word.length(); i++) {
            unknownWord.add(null);
        }
    }

    public GuessResult guess(char guessChar) {
        throwIfAlreadyLost();
        throwIfAlreadyWon();

        boolean success = updateUnknownWord(guessChar);

        if (!success) {
            remainingMisses--;
            return isLose()
                ? new Lose(unknownWord, word, remainingMisses)
                : new FailedGuess(unknownWord, word, remainingMisses);
        }

        return isWin()
            ? new Win(unknownWord, word, remainingMisses)
            : new SuccessfulGuess(unknownWord, word, remainingMisses);
    }

    public GuessResult giveUp() {
        throwIfAlreadyLost();
        throwIfAlreadyWon();

        return new Lose(unknownWord, word, remainingMisses);
    }

    private boolean updateUnknownWord(char guessChar) {
        boolean success = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != guessChar) {
                continue;
            }
            success = true;
            unknownWord.set(i, guessChar);
        }

        return success;
    }

    private void throwIfAlreadyLost() {
        if (isLose()) {
            throw new RuntimeException();
        }
    }

    private void throwIfAlreadyWon() {
        if (isWin()) {
            throw new RuntimeException();
        }
    }

    private boolean isLose() {
        return remainingMisses == 0;
    }

    private boolean isWin() {
        return unknownWord.stream().allMatch(Objects::nonNull);
    }
}
