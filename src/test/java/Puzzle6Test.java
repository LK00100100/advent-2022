import org.junit.jupiter.api.Test;
import puzzle6.ElfSignal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class Puzzle6Test {

    @Test
    void solvePart1() throws FileNotFoundException {
        File inputFile = new File(Objects.requireNonNull(this.getClass().getResource("puzzle6input.txt")).getFile());
        ElfSignal signal = Puzzle6.readFile(inputFile);

        signal.moveToNextMarker(4);

        int expected = 1356;
        assertEquals(expected, signal.currentIdx);
    }

    @Test
    void solvePart2() throws FileNotFoundException {
        File inputFile = new File(Objects.requireNonNull(this.getClass().getResource("puzzle6input.txt")).getFile());
        ElfSignal signal = Puzzle6.readFile(inputFile);

        signal.moveToNextMarker(14);

        int expected = 2564;
        assertEquals(expected, signal.currentIdx);
    }

}