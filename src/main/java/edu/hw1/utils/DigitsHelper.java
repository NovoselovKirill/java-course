package edu.hw1.utils;

public class DigitsHelper {
    public static final int BASE_10 = 10;
    public static final int BASE_2 = 2;

    private DigitsHelper() {
    }

    public static int[] toDigitsArray(long number, int digitsCount, int base) {
        int[] digits = new int[digitsCount];
        long n = number;

        for (int i = digitsCount - 1; i >= 0; i--) {
            digits[i] = (int) (n % base);
            n /= base;
        }

        return digits;
    }

    public static int countDigits(long number, int base) {
        long positive = Math.abs(number);
        int digitsCount = 0;

        do {
            positive /= base;
            digitsCount++;
        } while (positive != 0);

        return digitsCount;
    }
}
