package edu.hw1;

import java.util.Objects;

public class Task1 {
    private Task1() {
    }

    private static final String SEPARATOR = ":";
    private static final int RESULT_ON_INCORRECT_INPUT = -1;
    private static final int SECONDS_IN_MINUTE = 60;

    private static Integer tryParse(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static int minutesToSeconds(String minutesAndSeconds) throws NullPointerException {
        Objects.requireNonNull(minutesAndSeconds);

        var parts = minutesAndSeconds.split(SEPARATOR);

        if (parts.length != 2) {
            return RESULT_ON_INCORRECT_INPUT;
        }

        Integer minutes = tryParse(parts[0]);
        Integer seconds = tryParse(parts[1]);

        if (minutes == null || seconds == null) {
            return RESULT_ON_INCORRECT_INPUT;
        }

        var isValidMinutes = 0 <= minutes;
        var isValidSeconds = 0 <= seconds && seconds < SECONDS_IN_MINUTE;

        return isValidMinutes && isValidSeconds
            ? minutes * SECONDS_IN_MINUTE + seconds
            : RESULT_ON_INCORRECT_INPUT;
    }
}
