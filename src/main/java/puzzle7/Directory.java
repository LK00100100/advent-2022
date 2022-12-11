package puzzle7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Directory {

    //todo: bad code :-/ gotta go fast
    public static int accumulator;

    public Directory parent;

    //filename, size
    public Map<String, Integer> fileSizes;
    //dir name, Directory
    public Map<String, Directory> directories;

    public Directory() {
        parent = null;
        fileSizes = new HashMap<>();
        directories = new HashMap<>();
    }

    public Directory(Directory parent) {
        this.parent = parent;
        fileSizes = new HashMap<>();
        directories = new HashMap<>();
    }

    /**
     * recursively calculates the total size of this directory's
     * size and its children directories.
     *
     * @return -
     */
    public int calcTotalSize() {

        int sum = fileSizes.values().stream().reduce(Integer::sum).orElse(0);

        for (Directory dir : directories.values()) {
            sum += dir.calcTotalSize();
        }

        //todo: bad code :-/
        if (sum <= 100_000)
            accumulator += sum;

        return sum;
    }

    public List<Integer> getDirectorySizes() {
        int sum = fileSizes.values().stream().reduce(Integer::sum).orElse(0);

        for (Directory dir : directories.values()) {
            sum += dir.calcTotalSize();
        }

        List<Integer> dirSizes = new ArrayList<>();
        dirSizes.add(sum);

        for (Directory dir : directories.values())
            dirSizes.addAll(dir.getDirectorySizes());

        return dirSizes;
    }

}
