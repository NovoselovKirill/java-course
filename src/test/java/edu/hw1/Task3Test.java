package edu.hw1;

import org.assertj.core.api.AbstractBooleanAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.Arrays;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task3Test {
    @Test
    public void isNestable_whenOneOfArraysIsNull_throwsNullPointerException() {
        NullPointerException exception1 = assertThrows(NullPointerException.class,
            () -> Task3.isNestable(null, new int[] {1, 2}));

        NullPointerException exception2 = assertThrows(NullPointerException.class,
            () -> Task3.isNestable(new int[] {1, 2}, null));

        NullPointerException exception3 = assertThrows(NullPointerException.class,
            () -> Task3.isNestable(null, null));
    }

    @Test
    public void isNestable_whenOneOfArraysIsEmpty_returnsFalse() {
        int[] empty = new int[0];
        int[] array = new int[] {1, 2};

        assertThat(Task3.isNestable(empty, array)).isFalse();
        assertThat(Task3.isNestable(array, empty)).isFalse();
        assertThat(Task3.isNestable(empty, empty)).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {
        "[1, 2, 3, 4]; [0, 6]",
        "[3, 1]; [4, 0]",
    }, delimiterString = ";")
    public void isNestable_onCorrectInput_returnsTrue(String array1Str, String array2Str) {
        int[] array1 = convertStringToArray(array1Str);
        int[] array2 = convertStringToArray(array2Str);

        boolean actual = Task3.isNestable(array1, array2);

        assertThat(actual).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {
        "[9, 9, 8]; [8, 9]",
        "[1, 2, 3, 4]; [2, 3]",
    }, delimiterString = ";")
    public void isNestable_onCorrectInput_returnsFalse(String array1Str, String array2Str) {
        int[] array1 = convertStringToArray(array1Str);
        int[] array2 = convertStringToArray(array2Str);

        boolean actual = Task3.isNestable(array1, array2);

        assertThat(actual).isFalse();
    }

    private int[] convertStringToArray(String str) {
        String str1 = str.replace("[", "").replace("]", "");
        return Arrays.stream(str1.split(", ")).mapToInt(Integer::parseInt).toArray();
    }
}
