package edu.hw1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.Random;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task7Test {
    private static final Random RANDOM = new Random();

    @ParameterizedTest
    @CsvSource(value = {
        "16, 1, 1", // 10000, 1 -> 00001
        "17, 2, 6", // 10001, 2 -> 00110
    })
    public void rotateLeft_onCorrectInput_returnsCorrectResult(int n, int shift, int expected) {
        int actual = Task7.rotateLeft(n, shift);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "8, 1, 4", // 1000, 1 -> 0100
        "9, 2, 6", // 1001, 2 -> 0110
    })
    public void rotateRight_onCorrectInput_returnsCorrectResult(int n, int shift, int expected) {
        int actual = Task7.rotateRight(n, shift);
        assertThat(actual).isEqualTo(expected);
    }

    @RepeatedTest(1000)
    public void rotateLeftAndRotateRight_onRandomNumberAndZeroShift_returnsSameNumber() {
        int number = RANDOM.nextInt(Integer.MAX_VALUE);
        int rotatedLeft = Task7.rotateLeft(number, 0);
        int rotatedRight = Task7.rotateRight(number, 0);

        assertThat(rotatedLeft)
            .as("n = %d; rotatedLeft = %d".formatted(number, rotatedLeft))
            .isEqualTo(number);

        assertThat(rotatedRight)
            .as("n = %d; rotatedRight = %d".formatted(number, rotatedRight))
            .isEqualTo(number);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "9, 5, 3", // 1001, 5 -> 0011
        "9, 7, 12",  // 1001, 7 -> 1100
        "10, 8, 10"
    })
    public void rotateLeft_whenShiftIsGreaterThanBitsCountInN_returnsCorrectResult(int n, int shift, int expected) {
        int actual = Task7.rotateLeft(n, shift);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void rotateLeft_whenShiftIsNegative_throwsIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            () -> Task7.rotateLeft(10, -1));
    }

    @Test
    public void rotateLeft_whenNIsNegative_throwsIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            () -> Task7.rotateLeft(-1, 1));
    }
}
