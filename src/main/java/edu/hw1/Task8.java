package edu.hw1;

import java.util.Arrays;

public class Task8 {
    public static final int BOARD_SIZE = 8;
    private static final int[] DELTAS = new int[] {1, 2, -1, -2};

    private Task8() {
    }

    public static boolean knightBoardCapture(boolean[][] board) {
        if (!isBoardValid(board)) {
            throw new IllegalArgumentException();
        }

        for (int y = 0; y < BOARD_SIZE; y++) {
            for (int x = 0; x < BOARD_SIZE; x++) {
                if (board[y][x] && canCapture(board, x, y)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean canCapture(boolean[][] board, int x, int y) {
        for (var dx : DELTAS) {
            for (var dy : DELTAS) {
                if (Math.abs(dx) == Math.abs(dy)) {
                    continue;
                }
                int x0 = x + dx;
                int y0 = y + dy;
                if (!isInBound(x0) || !isInBound(y0)) {
                    continue;
                }
                if (board[y0][x0]) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isInBound(int x) {
        return 0 <= x && x < BOARD_SIZE;
    }

    private static boolean isBoardValid(boolean[][] board) {
        return board.length == BOARD_SIZE
            && Arrays.stream(board).allMatch(x -> x.length == BOARD_SIZE);
    }
}
