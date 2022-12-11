import org.junit.jupiter.api.Test;
import puzzle5.ElfStacks;
import puzzle5.Puzzle5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class Puzzle5Test {

    @Test
    void solvePart1() throws FileNotFoundException {
        File inputFile = new File(Objects.requireNonNull(this.getClass().getResource("puzzle5input.txt")).getFile());
        ElfStacks stacks = Puzzle5.readFile(inputFile);

        while (stacks.hasInstruction())
            stacks.pollAndExecuteOne();

        String top = stacks.printTops();
        String expected = " TWSGQHNHL";
        assertEquals(expected, top);
    }

    @Test
    void solvePart2() throws FileNotFoundException {
        File inputFile = new File(Objects.requireNonNull(this.getClass().getResource("puzzle5input.txt")).getFile());
        ElfStacks stacks = Puzzle5.readFile(inputFile);

        while (stacks.hasInstruction())
            stacks.pollAndExecuteMulti();

        String top = stacks.printTops();
        String expected = " JNRSCDWPP";
        assertEquals(expected, top);
    }
}