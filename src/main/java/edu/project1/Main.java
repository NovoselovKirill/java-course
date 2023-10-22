package edu.project1;

import edu.project1.consoleUI.DummyConsoleUi;
import edu.project1.consoleUI.guessResultConverters.GuessResultConverter;
import edu.project1.consoleUI.guessResultConverters.GuessResultConverterWithSpaces;
import edu.project1.game.GameOptions;
import edu.project1.game.GameRoundFabric;
import edu.project1.wordGenerators.DistinctWordGenerator;
import edu.project1.wordGenerators.WordGenerator;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final int MAX_MISSES = 5;

    private Main() {
    }

    public static void main(String[] args) {
        WordGenerator wordGenerator = new DistinctWordGenerator(getDict());
        GameOptions options = new GameOptions(MAX_MISSES);
        GameRoundFabric fabric = new GameRoundFabric(options);
        GuessResultConverter converter = new GuessResultConverterWithSpaces('_');
        Scanner scanner = new Scanner(System.in);
        DummyConsoleUi ui = new DummyConsoleUi(fabric, wordGenerator, scanner, converter);
        ui.run();
    }

    private static ArrayList<String> getDict() {
        ArrayList<String> res = new ArrayList<>();
        res.add("table");
        res.add("hello");
        res.add("hangman");
        return res;
    }
}
