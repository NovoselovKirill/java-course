package edu.project1.game.gameResults;

import java.util.List;
import org.jetbrains.annotations.NotNull;

sealed public interface GuessResult permits GuessResultBase {
    List<Character> unknownWord();

    int remainingMisses();

    @NotNull
    String word();
}

