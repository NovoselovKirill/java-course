package edu.hw1;

import edu.hw1.utils.DigitsHelper;
import java.util.Arrays;

public class Task6 {
    private static final int KAPREKARS_CONSTANT = 6174;
    private static final int REQUIRED_DIGITS_COUNT = 4;

    private Task6() {
    }

    public static int countK(int number) {
        if (!is4DigitPositiveNumber(number)) {
            throw new IllegalArgumentException();
        }
        if (areAllDigitsEqual(number)) {
            throw new IllegalArgumentException();
        }

        return countKRecursive(number);
    }


    @SuppressWarnings("MagicNumber")
    private static boolean areAllDigitsEqual(int number) {
        return number % 1111 == 0;
    }

    @SuppressWarnings("MagicNumber")
    private static boolean is4DigitPositiveNumber(int number) {
        return 1000 <= number && number < 10_000;
    }

    private static int countKRecursive(int current) {
        if (current == KAPREKARS_CONSTANT) {
            return 0;
        }

        int[] digits = DigitsHelper.toDigitsArray(current, REQUIRED_DIGITS_COUNT, DigitsHelper.BASE_10);

        Arrays.sort(digits);

        int descending = 0;
        int ascending = 0;

        for (int i = 0; i < REQUIRED_DIGITS_COUNT; i++) {
            descending = descending * DigitsHelper.BASE_10 + digits[REQUIRED_DIGITS_COUNT - 1 - i];
            ascending = ascending * DigitsHelper.BASE_10 + digits[i];
        }

        return countKRecursive(descending - ascending) + 1;
    }
}
