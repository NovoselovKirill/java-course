package edu.hw1;

import edu.hw1.utils.DigitsHelper;

public class Task7 {
    private Task7() {
    }

    public static int rotateLeft(int n, int shift) {
        return rotate(true, n, shift);
    }

    public static int rotateRight(int n, int shift) {
        return rotate(false, n, shift);
    }

    private static int rotate(boolean toLeft, int n, int shift) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        int bits = DigitsHelper.countDigits(n, DigitsHelper.BASE_2);
        int shiftMod = shift % bits;
        int mask = ~(0xffffffff << bits);
        int d = bits - shiftMod;
        int res = toLeft
            ? (n << shiftMod | (n >> d))
            : (n >> shiftMod | (n << d));

        return res & mask;
    }
}
