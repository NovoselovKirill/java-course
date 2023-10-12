package edu.hw1;

import java.util.Objects;

public class Task4 {
    private Task4() {
    }

    public static String fixString(String broken) {
        Objects.requireNonNull(broken);
        if (broken.isEmpty()) {
            return broken;
        }

        var sb = new StringBuilder(broken.length());
        for (int i = 1; i < broken.length(); i += 2) {
            sb.append(broken.charAt(i));
            sb.append(broken.charAt(i - 1));
        }

        if (broken.length() % 2 != 0) {
            char lastChar = broken.charAt(broken.length() - 1);
            sb.append(lastChar);
        }

        return sb.toString();
    }
}
