package puzzle8;

import java.util.ArrayList;
import java.util.List;

public class TreeLand {

    //row, col => tree height
    //assume not-ragged array
    public List<List<Integer>> treeHeights;

    public TreeLand() {
        treeHeights = new ArrayList<>();
    }

    public void addTreeRow(List<Integer> row) {
        treeHeights.add(row);
    }

    /**
     * count the number of trees that can be seen from the edge.
     * a tree is visible if one row/col is
     *
     * @return -
     */
    public int countVisibleTrees() {
        int count = 0;

        int rows = treeHeights.size();
        int cols = treeHeights.get(0).size();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                count += isVisibleTree(r, c) ? 1 : 0;
            }
        }

        return count;
    }

    /**
     * returns true if you can see this tree from any of the 4 edges.
     *
     * @param row -
     * @param col -
     * @return
     */
    private boolean isVisibleTree(int row, int col) {
        int origHeight = treeHeights.get(row).get(col);

        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int[] direction : directions) {
            int r = row + direction[0];
            int c = col + direction[1];

            boolean isGood = true;

            //check until you get to the edge
            while (isInBounds(r, c)) {
                int nextTree = treeHeights.get(r).get(c);

                if (nextTree >= origHeight) {
                    isGood = false;
                    break;
                }

                r += direction[0];
                c += direction[1];
            }

            if (isGood)
                return true;
        }

        return false;
    }

    public int bestScenicScore() {
        int best = 0;

        int rows = treeHeights.size();
        int cols = treeHeights.get(0).size();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                best = Math.max(getScenicScore(r, c), best);
            }
        }

        return best;
    }

    /**
     * get scenic score for one tree
     *
     * @param row -
     * @param col -
     * @return minimum of score above 0.
     */
    private int getScenicScore(int row, int col) {
        int origHeight = treeHeights.get(row).get(col);

        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int total = 1;

        for (int[] direction : directions) {
            int r = row + direction[0];
            int c = col + direction[1];
            int treesTouched = 0;

            //check until you get to the edge
            while (isInBounds(r, c)) {
                int nextTree = treeHeights.get(r).get(c);

                treesTouched++;

                if (nextTree >= origHeight)
                    break;

                r += direction[0];
                c += direction[1];
            }

            total *= treesTouched;
        }

        return total;
    }

    private boolean isInBounds(int row, int col) {
        if (row < 0 || row >= treeHeights.size())
            return false;

        if (col < 0 || col >= treeHeights.get(0).size())
            return false;

        return true;
    }

}
