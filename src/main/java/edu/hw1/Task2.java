package edu.hw1;

import edu.hw1.utils.DigitsHelper;

public class Task2 {
    private Task2() {
    }

    public static int countDigits(int number) {
        return countDigits((long) number);
    }

    public static int countDigits(long number) {
        return DigitsHelper.countDigits(number, DigitsHelper.BASE_10);
    }
}
