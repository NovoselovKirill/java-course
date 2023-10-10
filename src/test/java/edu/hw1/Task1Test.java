package edu.hw1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task1Test {
    private static final int RESULT_ON_INCORRECT_INPUT = -1;

    @ParameterizedTest
    @CsvSource(value = {
        "00:00, 0",
        "1:1, 61",
        "01:1, 61",
        "00:59, 59",
    })
    public void minutesToSeconds_whenCorrectInput_returnsCorrectResult(String input, int expectedMinutes) {
        int actualMinutes = Task1.minutesToSeconds(input);
        assertThat(actualMinutes).isEqualTo(expectedMinutes);
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "   0:0",
        "0: 0",
        "0:0  ",
        "0 :0",
        "\n0:0",
        "0:\t0",
    })
    public void minutesToSeconds_whenWhiteSpacesInInput_returnsMinusOne(String input) {
        int actualResult = Task1.minutesToSeconds(input);
        assertThat(actualResult).isEqualTo(RESULT_ON_INCORRECT_INPUT);
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "qwerty",
        "123:123:00",
        ":",
    })
    public void minutesToSeconds_whenIncorrectInput_returnsMinusOne(String input) {
        int actualResult = Task1.minutesToSeconds(input);
        assertThat(actualResult).isEqualTo(RESULT_ON_INCORRECT_INPUT);
    }


    @Test
    public void minutesToSeconds_whenNegativeMinutes_returnsMinusOne() {
        int actualResult = Task1.minutesToSeconds("-1:0");
        assertThat(actualResult).isEqualTo(RESULT_ON_INCORRECT_INPUT);
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "0:-1",
        "0:60",
    })
    public void minutesToSeconds_whenSecondsAreOutOfBounds_returnsMinusOne(String input) {
        int actualResult = Task1.minutesToSeconds(input);
        assertThat(actualResult).isEqualTo(RESULT_ON_INCORRECT_INPUT);
    }

    @Test
    public void minutesToSeconds_whenMinutesAreTooLarge_returnsMinusOne() {
        int actualResult = Task1.minutesToSeconds("100000000000000000000000:0");
        assertThat(actualResult).isEqualTo(RESULT_ON_INCORRECT_INPUT);
    }

    @Test
    public void minutesToSeconds_onEmptyString_returnsMinusOne() {
        int actualResult = Task1.minutesToSeconds("");
        assertThat(actualResult).isEqualTo(RESULT_ON_INCORRECT_INPUT);
    }

    @Test
    public void minutesToSeconds_onNull_throwsNullPointerException() {
        NullPointerException exception = assertThrows(NullPointerException.class,
            () -> Task1.minutesToSeconds(null));
    }
}
