package puzzle6;

import java.util.HashSet;
import java.util.Set;

public class ElfSignal {

    public String input;
    public int currentIdx = 0;  //on the start of every new section. 0-indexed

    private ElfSignal() {
        //blank
    }

    public ElfSignal(String input) {
        this.input = input;
    }

    //looking for n contiguous sequences with unique characters.
    public void moveToNextMarker(int n) {
        Set<Character> set = new HashSet<>();

        //inefficiency sure, why not
        while (currentIdx < input.length() - n - 1) {
            set.clear();

            for (int i = 0; i < n; i++) {
                char c = input.charAt(currentIdx + i);
                set.add(c);
            }

            currentIdx++;

            if (set.size() == n) {
                currentIdx += n - 1;
                break;
            }
        }
    }
}
