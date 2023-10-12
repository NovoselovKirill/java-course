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
        if (shift < 0) {
            throw new IllegalArgumentException();
        }

        int bits = DigitsHelper.countDigits(n, DigitsHelper.BASE_2);
        int shiftMod = shift % bits;
        int mask = allNBitsAreOne(bits);
        int d = bits - shiftMod;
        int resWithoutMaskUse = toLeft
            ? (n << shiftMod) | (n >> d)
            : (n >> shiftMod) | (n << d);

        return resWithoutMaskUse & mask;
    }

    private static int allNBitsAreOne(int n) {
        return ~(0xffffffff << n);
    }
}
