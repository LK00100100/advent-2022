package puzzle5;

import puzzle5.ElfStacks;
import puzzle5.StackInstruction;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * supply stacks
 */
public class Puzzle5 {

    /**
     * @param file assume valid
     * @return -
     */
    public static ElfStacks readFile(File file) throws FileNotFoundException {
        ElfStacks elfStacks = new ElfStacks();

        Scanner in = new Scanner(file);
        while (in.hasNextLine()) {
            String line = in.nextLine();

            //stack line
            if (line.contains("[")) {
                //start at [
                for (int i = 0; i < line.length(); i += 4) {
                    char c = line.charAt(i + 1);

                    if (c == ' ')
                        continue;

                    int stackNum = i / 4;
                    elfStacks.addBox(stackNum + 1, c);
                }
            }
            //instruction
            else if (line.contains("move")) {
                String[] tokens = line.split(" ");
                int moves = Integer.parseInt(tokens[1]);
                int from = Integer.parseInt(tokens[3]);
                int to = Integer.parseInt(tokens[5]);

                StackInstruction instruction = new StackInstruction(moves, from, to);
                elfStacks.instructions.add(instruction);
            }
            //ignore junk lines

        }

        //have to make the stacks, rightside up
        elfStacks.flipStack();

        return elfStacks;
    }

}
