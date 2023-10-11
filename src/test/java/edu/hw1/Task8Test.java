package edu.hw1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task8Test {
    private static final int BOARD_SIZE = Task8.BOARD_SIZE;

    @Test
    public void knightBoardCapture_onEmptyBoard_returnsTrue() {
        boolean[][] board = new boolean[BOARD_SIZE][BOARD_SIZE];
        boolean actual = Task8.knightBoardCapture(board);
        assertThat(actual).isTrue();
    }

    @Test
    public void knightBoardCapture_onBoardWithNullArrays_throwsNullPointerException() {
        boolean[][] board = new boolean[BOARD_SIZE][BOARD_SIZE];
        board[0] = null;

        NullPointerException exception = assertThrows(NullPointerException.class,
            () -> Task8.knightBoardCapture(board));
    }

    @Test
    public void knightBoardCapture_onBoardWithInvalidSize_throwsNullPointerException() {
        boolean[][] board = new boolean[BOARD_SIZE][BOARD_SIZE];
        board[board.length - 1] = new boolean[BOARD_SIZE + 1];

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            () -> Task8.knightBoardCapture(board));
    }

    @ParameterizedTest
    @ValueSource(strings = {
        """
            00010000
            00000000
            01000100
            00001010
            01000100
            00000000
            01000001
            00001000
            """,
    })
    public void knightBoardCapture_onCorrectBoard_returnsTrue(String boardStr) {
        boolean[][] board = convertStringToBoard(boardStr);
        boolean actual = Task8.knightBoardCapture(board);
        assertThat(actual).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {
        """
            10101010
            01010101
            00001010
            00100101
            10001010
            00000101
            10001010
            00010101
            """,
        """
            00001000
            00000100
            00010000
            10000000
            00001000
            00000100
            00000100
            10000000
            """,
    })
    public void knightBoardCapture_onCorrectBoard_returnsFalse(String boardStr) {
        boolean[][] board = convertStringToBoard(boardStr);
        boolean actual = Task8.knightBoardCapture(board);
        assertThat(actual).isFalse();
    }

    private boolean[][] convertStringToBoard(String str) {
        String[] lines = str.split("\n");
        boolean[][] board = new boolean[lines.length][];

        for (int i = 0; i < lines.length; i++) {
            board[i] = new boolean[lines[i].length()];
            for (int j = 0; j < lines[i].length(); j++) {
                board[i][j] = lines[i].charAt(j) == '1';
            }
        }

        return board;
    }
}
