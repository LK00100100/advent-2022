package puzzle5;

import java.util.*;

public class ElfStacks {

    public List<Stack<Character>> stacks;   //1-indexed
    public Queue<StackInstruction> instructions;

    public ElfStacks() {
        stacks = new ArrayList<>();
        instructions = new LinkedList<>();
    }

    /**
     * add box to stackNum's top.
     *
     * @param stackNum 1-indexed. will create stack if non-existent
     * @param c        the box's value
     */
    public void addBox(int stackNum, char c) {
        while (stackNum >= stacks.size())
            stacks.add(new Stack<>());

        stacks.get(stackNum).push(c);
    }

    /**
     * turns the stack upside down. stuff on the top is now on the bottom.
     * and vice versa.
     */
    public void flipStack() {
        for (int i = 1; i < stacks.size(); i++) {
            Stack<Character> oldStack = stacks.get(i);
            Stack<Character> newStack = new Stack<>();

            while (!oldStack.isEmpty())
                newStack.push(oldStack.pop());

            stacks.set(i, newStack);
        }

    }

    public boolean hasInstruction() {
        return !instructions.isEmpty();
    }

    /**
     * moves one box at a time.
     * assume has instruction. execute instruction (earliest)
     * assume instructions are legit
     */
    public void pollAndExecuteOne() {
        StackInstruction instruction = instructions.remove();

        Stack<Character> fromStack = stacks.get(instruction.from);
        Stack<Character> toStack = stacks.get(instruction.to);
        for (int i = 0; i < instruction.numMoves; i++)
            toStack.push(fromStack.pop());
    }

    /**
     * moves many boxes in one go.
     * assume has instruction. execute instruction (earliest)
     * assume instructions are legit
     */
    public void pollAndExecuteMulti() {
        StackInstruction instruction = instructions.remove();

        Stack<Character> fromStack = stacks.get(instruction.from);
        Stack<Character> toStack = stacks.get(instruction.to);

        Stack<Character> tempStack = new Stack<>();
        for (int i = 0; i < instruction.numMoves; i++)
            tempStack.push(fromStack.pop());

        for (int i = 0; i < instruction.numMoves; i++)
            toStack.push(tempStack.pop());
    }

    @Override
    public String toString() {
        return "ElfStacks{" +
                "stacks=" + stacks +
                ", instructions=" + instructions +
                '}';
    }

    /**
     * prints the top of every stack from 1 to n
     */
    public String printTops() {
        StringBuilder sb = new StringBuilder();

        for (Stack<Character> stack : stacks) {
            char c = stack.isEmpty() ? ' ' : stack.peek();
            sb.append(c);
        }

        return sb.toString();
    }
}
