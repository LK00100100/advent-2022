
import puzzle7.Directory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * No Space Left On Devicee
 */
public class Puzzle7 {

    /**
     * @param file assume valid
     * @return the root directory
     */
    public static Directory readFile(File file) throws FileNotFoundException {

        Directory rootDir = new Directory();
        Directory currentDir = rootDir;

        Scanner in = new Scanner(file);
        boolean skipRead = false;

        String line = "";
        while (in.hasNextLine()) {

            if (!skipRead)
                line = in.nextLine();

            skipRead = false;

            String[] tokens = line.split(" ");
            //commands
            if (line.startsWith("$")) {
                //cd command
                if (tokens[1].equals("cd")) {
                    String folder = tokens[2];

                    if (folder.equals("/")) {
                        currentDir = rootDir;
                        continue;
                    }

                    if (folder.equals("..")) {
                        currentDir = currentDir.parent;
                        continue;
                    }

                    //go deeper
                    if (!currentDir.directories.containsKey(folder))
                        currentDir.directories.put(folder, new Directory(currentDir));

                    currentDir = currentDir.directories.get(folder);
                }
                //ls command
                else if (tokens[1].equals("ls")) {
                    line = in.nextLine();
                    skipRead = true;

                    while (!line.startsWith("$")) {
                        tokens = line.split(" ");

                        //dir name
                        if (tokens[0].equals("dir")) {
                            if (!currentDir.directories.containsKey(tokens[0]))
                                currentDir.directories.put(tokens[0], new Directory());
                        }
                        //file size
                        else {
                            int size = Integer.parseInt(tokens[0]);
                            String filename = tokens[1];

                            currentDir.fileSizes.put(filename, size);
                        }

                        if(!in.hasNextLine())
                            break;

                        line = in.nextLine();
                    }

                } else
                    throw new IllegalArgumentException("reee");

            } else
                throw new IllegalArgumentException("reee");
        }

        return rootDir;
    }

}
