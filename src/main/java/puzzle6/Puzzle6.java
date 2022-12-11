package puzzle6;

import puzzle6.ElfSignal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * tuning trouble
 */
public class Puzzle6 {

    /**
     * @param file assume valid
     * @return -
     */
    public static ElfSignal readFile(File file) throws FileNotFoundException {
        Scanner in = new Scanner(file);

        return new ElfSignal(in.nextLine());
    }

}
