
import puzzle7.Directory;
import puzzle8.TreeLand;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * No Space Left On Devicee
 */
public class Puzzle8 {

    /**
     * @param file assume valid
     * @return -
     */
    public static TreeLand readFile(File file) throws FileNotFoundException {
        TreeLand treeLand = new TreeLand();

        Scanner in = new Scanner(file);

        while (in.hasNextLine()) {
            String line = in.nextLine();

            List<Integer> rowHeights = new ArrayList<>();

            for (char c : line.toCharArray()) {
                int height = c - '0';
                rowHeights.add(height);
            }

            treeLand.addTreeRow(rowHeights);
        }

        return treeLand;
    }

}
