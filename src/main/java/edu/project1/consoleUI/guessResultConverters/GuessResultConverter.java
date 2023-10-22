package edu.project1.consoleUI.guessResultConverters;

import edu.project1.game.gameResults.GuessResult;
import org.jetbrains.annotations.NotNull;

public interface GuessResultConverter {
    @NotNull
    String convert(GuessResult guessResult);

    @NotNull
    String getEmpty(int wordLength);
}
