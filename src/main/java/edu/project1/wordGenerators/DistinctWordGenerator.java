package edu.project1.wordGenerators;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import org.apache.logging.log4j.util.Strings;
import org.jetbrains.annotations.NotNull;

public class DistinctWordGenerator implements WordGenerator {
    private final Random random = new Random();
    private final String[] dictionary;
    private final boolean[] used;
    private int usedCount;

    public DistinctWordGenerator(Iterable<String> dictionary) {
        HashSet<String> set = new HashSet<>();

        for (String word : dictionary) {
            if (word == null) {
                throw new NullPointerException();
            }
            if (Strings.isEmpty(word)) {
                throw new IllegalArgumentException();
            }
            set.add(word);
        }
        if (set.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.dictionary = set.toArray(new String[set.size()]);
        used = new boolean[this.dictionary.length];
    }

    @Override
    public @NotNull String getRandomWord() {
        renewUsedIfNeeded();

        int index = random.nextInt(dictionary.length);
        while (used[index]) {
            index = (index + 1) % dictionary.length;
        }

        used[index] = true;

        return dictionary[index];
    }

    private void renewUsedIfNeeded() {
        if (usedCount < dictionary.length) {
            return;
        }
        usedCount = 0;
        Arrays.fill(used, false);
    }
}
