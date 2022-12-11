package puzzle2;

import java.util.Comparator;

/**
 * compares which
 */
public class RpsRoundComparator implements Comparator<RpsChoice> {

    @Override
    public int compare(RpsChoice c1, RpsChoice c2) {
        if (c1 == c2)
            return 0;

        //note: could just precalculate and put in map. or use a graph

        if (c1 == RpsChoice.ROCK && c2 == RpsChoice.PAPER)
            return 1;

        if (c1 == RpsChoice.ROCK && c2 == RpsChoice.SCISSORS)
            return -1;

        if (c1 == RpsChoice.PAPER && c2 == RpsChoice.ROCK)
            return -1;

        if (c1 == RpsChoice.PAPER && c2 == RpsChoice.SCISSORS)
            return 1;

        if (c1 == RpsChoice.SCISSORS && c2 == RpsChoice.ROCK)
            return 1;

        if (c1 == RpsChoice.SCISSORS && c2 == RpsChoice.PAPER)
            return -1;

        throw new IllegalArgumentException("what the what");
    }
}
