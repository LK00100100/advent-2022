import puzzle4.ElfPair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * pairs of elf intervals
 */
public class Puzzle4 {

    /**
     * @param file assume valid
     * @return list of elf's total calories
     */
    public static List<ElfPair> readFile(File file) throws FileNotFoundException {
        List<ElfPair> pairs = new LinkedList<>();

        Scanner in = new Scanner(file);

        while (in.hasNextLine()) {
            String line = in.nextLine();

            pairs.add(ElfPair.parse(line));
        }

        return pairs;
    }

}
