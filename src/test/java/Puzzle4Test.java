import org.junit.jupiter.api.Test;
import puzzle3.Rucksack;
import puzzle4.ElfPair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class Puzzle4Test {

    @Test
    void solvePart1() throws FileNotFoundException {
        File inputFile = new File(Objects.requireNonNull(this.getClass().getResource("puzzle4input.txt")).getFile());

        List<ElfPair> sacks = Puzzle4.readFile(inputFile);

        long overlapCount = sacks.stream().filter(ElfPair::isCompleteOverlap).count();
        System.out.println(overlapCount);
        long expected = 530;
        assertEquals(expected, overlapCount);
    }

    @Test
    void solvePart2() throws FileNotFoundException {
        File inputFile = new File(Objects.requireNonNull(this.getClass().getResource("puzzle4input.txt")).getFile());

        List<ElfPair> sacks = Puzzle4.readFile(inputFile);

        long overlapCount = sacks.stream().filter(ElfPair::isPartialOverlap).count();
        System.out.println(overlapCount);
        long expected = 903;
        assertEquals(expected, overlapCount);
    }
}