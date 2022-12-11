import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Puzzle1 {

    /**
     * Get the elf with the most calories.
     *
     * @param calories list of elf's total calories
     * @return the answer
     */
    public static int maxElfCalories(List<Integer> calories) {
        return calories.stream().max(Comparator.naturalOrder()).orElse(0);
    }

    /**
     * Like max calories but gets the top N.
     *
     * @param calories -
     * @param topK     top K number of elves with the most calories
     * @return top K elves.
     */
    public static List<Integer> maxElfCalories(List<Integer> calories, int topK) {
        Collections.sort(calories);

        //note: could walk through with heap of K. O( n * log k)

        List<Integer> topElves = new LinkedList<>();
        for (int i = topK; i > 0; i--)
            topElves.add(calories.get(calories.size() - i));

        return topElves;
    }

    /**
     * @param file assume valid
     * @return list of elf's total calories
     */
    public static List<Integer> readElvesFile(File file) throws FileNotFoundException {
        List<Integer> elves = new LinkedList<>();

        Scanner in = new Scanner(file);

        int currentElfCalories = 0;
        while (in.hasNextLine()) {
            String token = in.nextLine();

            if (token.isEmpty()) {
                elves.add(currentElfCalories);
                currentElfCalories = 0;
                continue;
            }

            currentElfCalories += Integer.parseInt(token);
        }

        return elves;
    }
}
