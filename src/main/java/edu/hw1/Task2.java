package edu.hw1;

import edu.hw1.utils.DigitsHelper;

public class Task2 {
    private static final int BASE_10 = 10;

    private Task2() {
    }

    public static int countDigits(int number) {
        return countDigits((long) number);
    }

    public static int countDigits(long number) {
        return DigitsHelper.countDigits(number, BASE_10);
    }
}
