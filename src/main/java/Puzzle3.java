import puzzle3.Rucksack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * elves rucksack problem
 */
public class Puzzle3 {

    /**
     * parses a file of puzzle
     *
     * @param file assume valid
     * @return list of RPS rounds
     */
    public static List<Rucksack> readPuzzleFile(File file) throws FileNotFoundException {
        List<Rucksack> sacks = new LinkedList<>();

        Scanner in = new Scanner(file);

        while (in.hasNextLine()) {
            String line = in.nextLine();

            Rucksack sack = Rucksack.parse(line);

            sacks.add(sack);
        }

        return sacks;
    }

}
