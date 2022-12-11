package puzzle2;

/**
 * Holds info on one Rock, Paper, Scissors round
 */
public class RpsRound {
    public RpsChoice enemyChoice;
    public RpsChoice yourChoice;
    private RpsRoundComparator comparator = new RpsRoundComparator();

    private RpsRound() {
        //blank
    }

    public RpsRoundResult whoWon() {
        int result = comparator.compare(enemyChoice, yourChoice);

        if (result == 0)
            return RpsRoundResult.TIE;
        else if (result < 0)
            return RpsRoundResult.ENEMY;

        return RpsRoundResult.YOU;
    }

    /**
     * A, B, C = enemy's RPS choice
     * X, Y, Z = your RPS choice
     *
     * @param enemyChar char from RPS input file
     * @param yourChar  char from RPS input file
     * @return Rock paper scissors round
     */
    public static RpsRound parseRpsRoundPart1(char enemyChar, char yourChar) {
        RpsRound rpsRound = new RpsRound();

        //todo: hardcode bad :-/
        rpsRound.enemyChoice = RpsChoice.getRpsChoice(enemyChar, "ABC");
        rpsRound.yourChoice = RpsChoice.getRpsChoice(yourChar, "XYZ");

        return rpsRound;
    }

    //todo: hardcode bad

    /**
     * given an enemy move (char) and the round result,
     * return what happened that round.
     *
     * @param enemyChar  -
     * @param resultChar the encrypted round result character
     * @return -
     */
    public static RpsRound parseRpsRoundPart2(char enemyChar, char resultChar) {
        if ("XYZ".indexOf(resultChar) == -1)
            throw new IllegalArgumentException("reeeee");

        RpsRound rpsRound = new RpsRound();

        rpsRound.enemyChoice = RpsChoice.getRpsChoice(enemyChar, "ABC");

        //note: could use switch expressions;

        RpsRoundResult rpsRoundResult = RpsRoundResult.ENEMY;
        if (resultChar == 'Y')
            rpsRoundResult = RpsRoundResult.TIE;

        if (resultChar == 'Z')
            rpsRoundResult = RpsRoundResult.YOU;

        rpsRound.yourChoice = getYourChoice(rpsRound.enemyChoice, rpsRoundResult);

        return rpsRound;
    }

    /**
     * given an enemy choice and round result, return what your choice should be.
     *
     * @param enemyChoice -
     * @param result      -
     * @return -
     */
    public static RpsChoice getYourChoice(RpsChoice enemyChoice, RpsRoundResult result) {
        if (result == RpsRoundResult.TIE)
            return enemyChoice;

        //note: if this rps was turned into a graph, you could do it like that too.
        //each RPS node would be pointing to pros and cons.
        //if tie, return enemy node. if winner, return enemynode.winner, else return enemynode.loser

        switch (enemyChoice) {
            case ROCK:
                if (result == RpsRoundResult.ENEMY)
                    return RpsChoice.SCISSORS;

                return RpsChoice.PAPER;
            case PAPER:
                if (result == RpsRoundResult.ENEMY)
                    return RpsChoice.ROCK;

                return RpsChoice.SCISSORS;
            case SCISSORS:
                if (result == RpsRoundResult.ENEMY)
                    return RpsChoice.PAPER;

                return RpsChoice.ROCK;
            default:
                throw new IllegalArgumentException("reeee");
        }
    }

    @Override
    public String toString() {
        return "RpsRound{" +
                "yourChoice=" + yourChoice +
                ", enemyChoice=" + enemyChoice +
                '}';
    }
}