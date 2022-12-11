package puzzle2;

public enum RpsChoice {
    ROCK,
    PAPER,
    SCISSORS;

    /**
     * @param yourChar your chosen character. should be in the key
     * @param key      a string of rock, paper, scissors. "ABC" => A = rock, b= scissors, etc
     * @return your choice. throws exception on baddie.
     */
    public static RpsChoice getRpsChoice(char yourChar, String key) {
        char[] keys = key.toCharArray();

        for (int i = 0; i < keys.length; i++) {
            if (yourChar == keys[i]) {

                //note: if this gets worse, use a map instead
                switch (i) {
                    case 0:
                        return RpsChoice.ROCK;
                    case 1:
                        return RpsChoice.PAPER;
                    case 2:
                        return RpsChoice.SCISSORS;
                }

            }
        }

        throw new IllegalArgumentException("bad choice and key: " + yourChar + " ;key: " + key);
    }

}
