package edu.project1.wordGenerators;

import org.jetbrains.annotations.NotNull;

public interface WordGenerator {
    @NotNull
    String getRandomWord();
}
