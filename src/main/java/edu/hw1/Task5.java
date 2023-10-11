package edu.hw1;

import edu.hw1.utils.DigitsHelper;

public class Task5 {
    private static final int BASE_10 = 10;

    private Task5() {
    }

    public static boolean isPalindromeDescendant(long number) {
        long positive = Math.abs(number);
        int digitsCount = Task2.countDigits(positive);
        int[] digits = DigitsHelper.toDigitsArray(positive, digitsCount, BASE_10);

        do {
            if (isPalindrome(digits, digitsCount)) {
                return true;
            }
            digitsCount = transformToItsChildAndReturnNewCount(digits, digitsCount);

        } while (digitsCount > 1);

        return false;
    }

    private static int transformToItsChildAndReturnNewCount(int[] digits, int digitsCount) {
        int newCount = 0;
        int i = 1;

        if (digitsCount % 2 != 0) {
            newCount++;
            i++;
        }

        for (; i < digitsCount; i += 2) {
            int sum = digits[i] + digits[i - 1];
            if (sum < BASE_10) {
                digits[newCount++] = sum;
            } else {
                digits[newCount++] = sum / BASE_10;
                digits[newCount++] = sum % BASE_10;
            }
        }

        return newCount;
    }

    private static boolean isPalindrome(int[] array, int count) {
        for (int i = 0; i < count / 2; i++) {
            int oppositeIndex = count - 1 - i;
            if (array[i] != array[oppositeIndex]) {
                return false;
            }
        }
        return true;
    }
}
