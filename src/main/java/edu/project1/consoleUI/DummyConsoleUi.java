package edu.project1.consoleUI;

import edu.project1.consoleUI.guessResultConverters.GuessResultConverter;
import edu.project1.game.GameRoundFabric;
import edu.project1.game.gameResults.GuessResult;
import edu.project1.wordGenerators.WordGenerator;
import java.util.Scanner;

@SuppressWarnings("RegexpSinglelineJava")
public class DummyConsoleUi extends ConsoleUIBase {
    private final GuessResultConverter converter;

    public DummyConsoleUi(
        GameRoundFabric gameRoundFabric,
        WordGenerator wordGenerator,
        Scanner scanner,
        GuessResultConverter converter
        ) {
        super(gameRoundFabric, wordGenerator, scanner);
        this.converter = converter;
    }

    @Override
    protected void printGreetings() {
        System.out.println("This is Hangman game");
        System.out.println("To exit print '" + EXIT + "'");
    }

    @Override
    protected void printGuess(GuessResult result) {
        printGuess(converter.convert(result));
    }

    @Override
    protected void printGuess(int wordLength) {
        printGuess(converter.getEmpty(wordLength));
    }

    private void printGuess(String message) {
        System.out.println("The word: " + message);
        System.out.println("Guess a letter:");
    }

    @Override
    protected void printOnExit() {
    }

    @Override
    protected void printOnWrongInput() {
        System.out.println("Incorrect input. Try one more time:");
    }

    @Override
    protected void printOnSuccessfulGuess(GuessResult guessResult) {
        System.out.println("Hit!");
    }

    @Override
    protected void printOnFailedGuess(GuessResult guessResult) {
        System.out.printf("Missed, %s errors left \n", guessResult.remainingMisses());
    }

    @Override
    protected void printOnWin(GuessResult guessResult) {
        System.out.println("You won!");
    }

    @Override
    protected void printOnLose(GuessResult guessResult) {
        System.out.println("You lost!");
    }

    @Override
    protected boolean playAnotherGame(Scanner scanner) {
        while (true) {
            System.out.println("Play another game [yes/no]?");
            String answer = scanner.nextLine().strip().toLowerCase();
            if (yes(answer)) {
                return true;
            }
            if (no(answer)) {
                return false;
            }
        }
    }

    private boolean yes(String answer) {
        return answer.equals("yes") || answer.equals("y");
    }

    private boolean no(String answer) {
        return answer.equals("no") || answer.equals("n");
    }
}
