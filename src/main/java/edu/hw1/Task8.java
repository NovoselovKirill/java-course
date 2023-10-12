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

        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                if (board[row][column] && canCapture(board, row, column)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean canCapture(boolean[][] board, int row, int column) {
        for (var dx : DELTAS) {
            for (var dy : DELTAS) {
                if (Math.abs(dx) == Math.abs(dy)) {
                    continue;
                }
                int column0 = column + dx;
                int row0 = row + dy;
                if (isNotInBound(column0) || isNotInBound(row0)) {
                    continue;
                }
                if (board[row0][column0]) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isNotInBound(int x) {
        return !(0 <= x && x < BOARD_SIZE);
    }

    private static boolean isBoardValid(boolean[][] board) {
        return board.length == BOARD_SIZE
            && Arrays.stream(board).allMatch(x -> x.length == BOARD_SIZE);
    }
}
