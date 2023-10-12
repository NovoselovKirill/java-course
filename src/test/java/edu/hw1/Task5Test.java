package edu.hw1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    public void isPalindromeDescendant_forAllOneDigitNumbers_returnsTrue() {
        for (int i = 0; i < 10; i++) {
            boolean actual = Task5.isPalindromeDescendant(i);
            assertThat(actual).isTrue();
        }
    }

    @ParameterizedTest
    @ValueSource(longs = {
        11211230, // 11211230 -> 2333 -> 56 -> 11
        13001120, // 13001120 -> 4022 -> 44
        23336014, // 23336014 -> 5665
        541,      // 0541 -> 55
    })
    public void isPalindromeDescendant_onCorrectNumber_returnsTrue(long num) {
        boolean actual = Task5.isPalindromeDescendant(num);
        assertThat(actual).isTrue();
    }

    @ParameterizedTest
    @ValueSource(longs = {
        31221, // 031221 -> 333
        541,   // 0541 -> 55
    })
    public void isPalindromeDescendant_onCorrectOddDigitsNumber_returnsTrue(long num) {
        boolean actual = Task5.isPalindromeDescendant(num);
        assertThat(actual).isTrue();
    }

    @ParameterizedTest
    @ValueSource(longs = {
        12,
        112,
        1234
    })
    public void isPalindromeDescendant_onCorrectNumber_returnsFalse(long num) {
        boolean actual = Task5.isPalindromeDescendant(num);
        assertThat(actual).isFalse();
    }

    @ParameterizedTest
    @ValueSource(longs = {
        11,
        222,
        3333,
        44444,
        555555,
    })
    public void isPalindromeDescendant_onPalindromeNumber_returnsTrue(long num) {
        boolean actual = Task5.isPalindromeDescendant(num);
        assertThat(actual).isTrue();
    }
}
