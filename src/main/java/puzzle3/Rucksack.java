package puzzle3;

import java.util.HashSet;
import java.util.Set;

public class Rucksack {

    public Set<Character> compartmentOneChars;
    public Set<Character> compartmentTwoChars;

    private Rucksack() {
        //empty
    }

    /**
     * get the one char that is in both compartments
     *
     * @return -
     */
    public char getOddChar() {
        for (char c : compartmentOneChars) {
            if (compartmentTwoChars.contains(c))
                return c;
        }

        throw new IllegalArgumentException("no odd chars reee");
    }

    /**
     * Get compartments combined char sets.
     *
     * @return -
     */
    public Set<Character> getAllCharsSet() {
        Set<Character> newSet = new HashSet<>();
        newSet.addAll(compartmentOneChars);
        newSet.addAll(compartmentTwoChars);
        return newSet;
    }

    /**
     * @param input the jumble of letters
     * @return -
     */
    public static Rucksack parse(String input) {
        String left = input.substring(0, input.length() / 2);
        String right = input.substring(input.length() / 2);

        Set<Character> charsLeft = charSet(left);
        Set<Character> charsRight = charSet(right);

        Rucksack sack = new Rucksack();
        sack.compartmentOneChars = charsLeft;
        sack.compartmentTwoChars = charsRight;

        return sack;
    }

    private static Set<Character> charSet(String str) {
        Set<Character> counts = new HashSet<>();

        for (char c : str.toCharArray())
            counts.add(c);

        return counts;
    }

    /**
     * for example: a - Z = 1 - 26.
     * A - Z = 27 - 52.
     * <p>
     * so a = 1, and Z = 52
     *
     * @param c -
     * @return points
     */
    public static int getCost(char c) {
        if (!Character.isAlphabetic(c))
            throw new IllegalArgumentException("reeeee");

        if (Character.isLowerCase(c))
            return c - 'a' + 1;

        return c - 'A' + 27;
    }

}
