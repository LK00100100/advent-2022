import puzzle2.RpsChoice;
import puzzle2.RpsRound;
import puzzle2.RpsRoundResult;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//rock paper scissors (RPS) puzzle
public class Puzzle2 {

    /**
     * calc points using the point system
     *
     * @return total points
     */
    public static int calcPoints(RpsRound round) {

        RpsRoundResult res = round.whoWon();

        //note: future java versions have switch expressions

        int roundResPoints = 0;
        if (res == RpsRoundResult.YOU)
            roundResPoints = 6;

        if (res == RpsRoundResult.TIE)
            roundResPoints = 3;

        int yourChoicePoints = 1;
        if (round.yourChoice == RpsChoice.PAPER)
            yourChoicePoints = 2;

        if (round.yourChoice == RpsChoice.SCISSORS)
            yourChoicePoints = 3;

        return yourChoicePoints + roundResPoints;
    }

    /**
     * parses a file of puzzle part-1 format
     *
     * @param file assume valid
     * @return list of RPS rounds
     */
    public static List<RpsRound> readPuzzleFilePart1(File file) throws FileNotFoundException {
        List<RpsRound> rpsRounds = new LinkedList<>();

        Scanner in = new Scanner(file);

        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] tokens = line.split(" ");

            char enemyChar = tokens[0].charAt(0);
            char yourChar = tokens[1].charAt(0);

            rpsRounds.add(RpsRound.parseRpsRoundPart1(enemyChar, yourChar));
        }

        return rpsRounds;
    }

    /**
     * parses a file of puzzle part-2 format
     *
     * @param file assume valid
     * @return list of RPS rounds
     */
    public static List<RpsRound> readPuzzleFilePart2(File file) throws FileNotFoundException {
        List<RpsRound> rpsRounds = new LinkedList<>();

        Scanner in = new Scanner(file);

        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] tokens = line.split(" ");

            char enemyChar = tokens[0].charAt(0);
            char roundResult = tokens[1].charAt(0);

            rpsRounds.add(RpsRound.parseRpsRoundPart2(enemyChar, roundResult));
        }

        return rpsRounds;
    }

}