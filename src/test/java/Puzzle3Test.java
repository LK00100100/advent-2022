import org.junit.jupiter.api.Test;
import puzzle3.Puzzle3;
import puzzle3.Rucksack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class Puzzle3Test {

    @Test
    void solvePuzzlePart1() throws FileNotFoundException {
        File inputFile = new File(Objects.requireNonNull(this.getClass().getResource("puzzle3input.txt")).getFile());

        List<Rucksack> sacks = Puzzle3.readPuzzleFile(inputFile);

        int total = sacks.stream().map(sack -> Rucksack.getCost(sack.getOddChar())).reduce(Integer::sum).orElse(0);
        System.out.println(total);
        int expected = 8493;
        assertEquals(expected, total);
    }

    @Test
    void solvePuzzlePart2() throws FileNotFoundException {
        File inputFile = new File(Objects.requireNonNull(this.getClass().getResource("puzzle3input.txt")).getFile());
        int sum = 0;

        List<Rucksack> sacks = Puzzle3.readPuzzleFile(inputFile);

        //group of 3 elves. find the one shared char (the elf badge)
        for (int i = 0; i < sacks.size(); i += 3) {
            Set<Character> allChars = sacks.get(i).getAllCharsSet();
            allChars.retainAll(sacks.get(i + 1).getAllCharsSet());
            allChars.retainAll(sacks.get(i + 2).getAllCharsSet());

            char sharedChar = allChars.iterator().next();

            sum += Rucksack.getCost(sharedChar);
        }

        System.out.println(sum);
    }
}