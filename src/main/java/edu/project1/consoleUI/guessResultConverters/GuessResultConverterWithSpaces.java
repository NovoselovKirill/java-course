package edu.project1.consoleUI.guessResultConverters;

import edu.project1.game.gameResults.GuessResult;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

public class GuessResultConverterWithSpaces implements GuessResultConverter {
    private final String unknownCharFiller;

    public GuessResultConverterWithSpaces(char unknownCharFiller) {

        this.unknownCharFiller = Character.toString(unknownCharFiller);
    }

    @Override
    @NotNull
    public String convert(GuessResult guessResult) {
        String[] chars = guessResult
            .unknownWord()
            .stream()
            .map(c -> c == null ? unknownCharFiller : c.toString())
            .toArray(String[]::new);
        return String.join(" ", chars);
    }

    @Override
    public @NotNull String getEmpty(int wordLength) {
        String[] chars = new String[wordLength];
        Arrays.fill(chars, unknownCharFiller);
        return String.join(" ", chars);
    }
}
