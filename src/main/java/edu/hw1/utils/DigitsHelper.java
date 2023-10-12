package edu.hw1.utils;

public class DigitsHelper {
    public static final short BASE_10 = 10;
    public static final short BASE_2 = 2;

    private DigitsHelper() {
    }

    public static short[] toDigitsArray(long number, int digitsCount, short base) {
        short[] digits = new short[digitsCount];
        long n = number;

        for (int i = digitsCount - 1; i >= 0; i--) {
            digits[i] = (short) (n % base);
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
