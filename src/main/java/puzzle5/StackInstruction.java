package puzzle5;

public class StackInstruction {
    public int numMoves;
    public int from;
    public int to;

    public StackInstruction(int move, int from, int to) {
        this.numMoves = move;
        this.from = from;
        this.to = to;
    }
}
