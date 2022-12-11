import org.junit.jupiter.api.Test;
import puzzle7.Directory;
import puzzle8.TreeLand;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class Puzzle8Test {

    @Test
    void solvePart1() throws FileNotFoundException {
        File inputFile = new File(Objects.requireNonNull(this.getClass().getResource("puzzle8input.txt")).getFile());
        TreeLand land = Puzzle8.readFile(inputFile);

        int countVisibleTrees = land.countVisibleTrees();

        int expected = 1859;
        assertEquals(expected, countVisibleTrees);
    }

    @Test
    void solvePart2() throws FileNotFoundException {
        File inputFile = new File(Objects.requireNonNull(this.getClass().getResource("puzzle8input.txt")).getFile());
        TreeLand land = Puzzle8.readFile(inputFile);

        int bestScenicScore = land.bestScenicScore();

        System.out.println(bestScenicScore);

        int expected = 332640;
        assertEquals(expected, bestScenicScore);
    }
}