package edu.hw1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task4Test {
    @Test
    public void fixString_onNull_throwsNullPointerException() {
        NullPointerException exception = assertThrows(NullPointerException.class,
            () -> Task4.fixString(null));
    }

    @Test
    public void fixString_onOddLengthString_returnsCorrectResult() {
        String actual = Task4.fixString("abc");
        assertThat(actual).isEqualTo("bac");
    }

    @Test
    public void fixString_onEvenLengthString_returnsCorrectResult() {
        String actual = Task4.fixString("ab");
        assertThat(actual).isEqualTo("ba");
    }

    @Test
    public void fixString_onEmptyString_returnsEmptyString() {
        String actual = Task4.fixString("");
        assertThat(actual).isEqualTo("");
    }

    @ParameterizedTest
    @CsvSource(value = {
        "123456, 214365",
        "hTsii  s aimex dpus rtni.g, This is a mixed up string.",
        "badce, abcde"
    })
    public void fixString_onCorrectString_returnsCorrectResult(String input, String expected) {
        String actual = Task4.fixString(input);
        assertThat(actual).isEqualTo(expected);
    }
}
