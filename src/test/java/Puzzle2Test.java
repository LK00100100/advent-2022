import org.junit.jupiter.api.Test;
import puzzle2.RpsRound;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class Puzzle2Test {

    @Test
    void solvePart1() throws FileNotFoundException {
        File inputFile = new File(Objects.requireNonNull(this.getClass().getResource("puzzle2input.txt")).getFile());

        List<RpsRound> rpsRounds = Puzzle2.readPuzzleFilePart1(inputFile);

        int sumPoints = rpsRounds.stream()
                .map(Puzzle2::calcPoints)
                .reduce(Integer::sum)
                .orElse(0);
        System.out.println(sumPoints);
    }

    @Test
    void solvePart2() throws FileNotFoundException {
        File inputFile = new File(Objects.requireNonNull(this.getClass().getResource("puzzle2input.txt")).getFile());

        List<RpsRound> rpsRounds = Puzzle2.readPuzzleFilePart2(inputFile);

        int sumPoints = rpsRounds.stream()
                .map(Puzzle2::calcPoints)
                .reduce(Integer::sum)
                .orElse(0);
        System.out.println(sumPoints);
        
        int expected = 13071;
        assertEquals(expected, sumPoints);
    }
}