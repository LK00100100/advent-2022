import org.junit.jupiter.api.Test;
import puzzle7.Directory;
import puzzle7.Puzzle7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Puzzle7Test {

    @Test
    void solvePart1() throws FileNotFoundException {
        File inputFile = new File(Objects.requireNonNull(this.getClass().getResource("puzzle7input.txt")).getFile());
        Directory rootDir = Puzzle7.readFile(inputFile);

        Directory.accumulator = 0;
        rootDir.calcTotalSize();
        System.out.println(Directory.accumulator);

        int expected = 1583951;
        assertEquals(expected, Directory.accumulator);
    }

    @Test
    void solvePart2() throws FileNotFoundException {
        File inputFile = new File(Objects.requireNonNull(this.getClass().getResource("puzzle7input.txt")).getFile());
        Directory rootDir = Puzzle7.readFile(inputFile);

        List<Integer> dirSizes = rootDir.getDirectorySizes();

        //calc smallest dir we can delete to get required 30m
        int usedSize = rootDir.calcTotalSize();
        int freeSize = 70_000_000 - usedSize;
        int desiredFree = 30_000_000 - freeSize;    //assumed positive

        Collections.sort(dirSizes);

        int minDirDeleteSize = 0;
        for (int dirSize : dirSizes) {
            if (dirSize > desiredFree) {
                minDirDeleteSize = dirSize;
                break;
            }
        }

        //assert
        int expected = 214171;
        assertEquals(expected, minDirDeleteSize);
    }

}