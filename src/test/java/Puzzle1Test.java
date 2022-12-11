import org.junit.jupiter.api.Test;
import puzzle1.Puzzle1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;

class Puzzle1Test {

    @Test
    void solve() throws FileNotFoundException {
        File inputFile = new File(Objects.requireNonNull(this.getClass().getResource("puzzle1input.txt")).getFile());

        List<Integer> elves = Puzzle1.readElvesFile(inputFile);

        int answer = Puzzle1.maxElfCalories(elves);
        System.out.println(answer);
    }

    @Test
    void solvePart2() throws FileNotFoundException {
        File inputFile = new File(Objects.requireNonNull(this.getClass().getResource("puzzle1input.txt")).getFile());
        List<Integer> elves = Puzzle1.readElvesFile(inputFile);

        List<Integer> answer2 = Puzzle1.maxElfCalories(elves, 3);

        int totalTopKElves = answer2.stream().reduce(Integer::sum).orElse(0);
        System.out.println(answer2);
        System.out.println(totalTopKElves);
    }
}