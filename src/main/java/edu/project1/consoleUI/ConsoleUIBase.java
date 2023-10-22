package edu.project1.consoleUI;

import edu.project1.game.GameRound;
import edu.project1.game.GameRoundFabric;
import edu.project1.game.gameResults.FailedGuess;
import edu.project1.game.gameResults.GuessResult;
import edu.project1.game.gameResults.Lose;
import edu.project1.game.gameResults.SuccessfulGuess;
import edu.project1.game.gameResults.Win;
import edu.project1.wordGenerators.WordGenerator;
import java.util.Scanner;

public abstract class ConsoleUIBase {
    protected static final String EXIT = "exit";

    private final GameRoundFabric gameRoundFabric;
    private final WordGenerator wordGenerator;
    private final Scanner scanner;

    public ConsoleUIBase(GameRoundFabric gameRoundFabric, WordGenerator wordGenerator, Scanner scanner) {
        this.scanner = scanner;
        this.gameRoundFabric = gameRoundFabric;
        this.wordGenerator = wordGenerator;
    }

    public void run() {
        printGreetings();

        while (playOneRound()) {
        }
    }

    private boolean playOneRound() {
        String word = wordGenerator.getRandomWord();
        GameRound round = gameRoundFabric.create(word);
        printGuess(word.length());
        String guess = readGuess();

        while (true) {
            if (guess.equals(EXIT)) {
                printOnExit();
                return false;
            }

            GuessResult result = round.guess(guess.charAt(0));
            printAfterGuess(result);

            if (result instanceof Win || result instanceof Lose) {
                return playAnotherGame(scanner);
            }

            printGuess(result);
            guess = readGuess();
        }
    }

    private String readGuess() {
        while (true) {
            String guess = scanner.nextLine().strip().toLowerCase();
            if (guess.equals(EXIT) || guess.length() == 1) {
                return guess;
            }
            printOnWrongInput();
        }
    }

    private void printAfterGuess(GuessResult guessResult) {
        switch (guessResult) {
            case Win result -> printOnWin(result);
            case Lose result -> printOnLose(result);
            case SuccessfulGuess result -> printOnSuccessfulGuess(result);
            case FailedGuess result -> printOnFailedGuess(result);
            default -> throw new IllegalStateException("Unexpected value: " + guessResult);
        }
    }

    protected abstract void printGreetings();

    protected abstract void printGuess(GuessResult guessResult);

    protected abstract void printGuess(int wordLength);

    protected abstract void printOnExit();

    protected abstract void printOnWrongInput();

    protected abstract void printOnSuccessfulGuess(GuessResult guessResult);

    protected abstract void printOnFailedGuess(GuessResult guessResult);

    protected abstract void printOnWin(GuessResult guessResult);

    protected abstract void printOnLose(GuessResult guessResult);

    protected abstract boolean playAnotherGame(Scanner scanner);
}
