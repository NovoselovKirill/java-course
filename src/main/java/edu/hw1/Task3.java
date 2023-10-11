package edu.hw1;

import java.util.Arrays;
import java.util.Objects;

public class Task3 {
    private Task3() {
    }

    public static boolean isNestable(int[] array1, int[] array2) throws NullPointerException {
        Objects.requireNonNull(array1);
        Objects.requireNonNull(array2);

        if (array1.length == 0 || array2.length == 0) {
            return false;
        }

        int minArray1 = Arrays.stream(array1).min().getAsInt();
        int minArray2 = Arrays.stream(array2).min().getAsInt();
        int maxArray1 = Arrays.stream(array1).max().getAsInt();
        int maxArray2 = Arrays.stream(array2).max().getAsInt();

        return minArray2 < minArray1 && maxArray1 < maxArray2;
    }
}
