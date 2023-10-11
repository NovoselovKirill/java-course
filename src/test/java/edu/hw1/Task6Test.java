package edu.hw1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task6Test {
    @Test
    public void countK_forAll4DigitsNumbers_returnsNumberThatLessThen8() {
        for (int i = 1000; i < 10_000; i++) {
            if (i % 1111 == 0) {
                continue;
            }
            int actual = Task6.countK(i);
            assertThat(actual)
                .as("Number = %d, K = %d".formatted(i, actual))
                .isLessThan(8);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {
        -1,
        1,
        10_000,
    })
    public void countK_onNonPositive4DigitNumber_throwsIllegalArgumentException(int num) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            () -> Task6.countK(num));
    }

    @Test
    public void countK_whenAllDigitsAreEqual_throwsIllegalArgumentException() {
        for (int i = 1; i < 10; i++) {
            int j = i;
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Task6.countK(1111 * j));
        }
    }

    @ParameterizedTest
    @CsvSource(value = {
        "6621, 5",
        "6554, 4",
        "1234, 3",
        "3524, 3",
        "6174, 0"
    })
    public void countK_onCorrectNumber_returnsCorrectResult(int num, int expected) {
        int actual = Task6.countK(num);
        assertThat(actual).isEqualTo(expected);
    }
}

