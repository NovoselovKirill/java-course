package edu.hw1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    public void countDigits_onZero_returnsOne() {
        int actual = Task2.countDigits(0);
        assertThat(actual).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "-1, 1",
        "-10, 2",
        "-111, 3",
    })
    public void countDigits_onNegativeLong_returnsCorrectResult(long number, int expected) {
        int actual = Task2.countDigits(number);
        assertThat(actual).isEqualTo(expected);
    }


    @ParameterizedTest
    @CsvSource(value = {
        "-1, 1",
        "-10, 2",
        "-111, 3",
    })
    public void countDigits_onNegativeInt_returnsCorrectResult(int number, int expected) {
        int actual = Task2.countDigits(number);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "1, 1",
        "1_000_000_000_000_000, 16",
    })
    public void countDigits_onCommonLong_returnsCorrectResult(long number, int expected) {
        int actual = Task2.countDigits(number);
        assertThat(actual).isEqualTo(expected);
    }
}
