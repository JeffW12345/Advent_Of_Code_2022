package Day8Part1;

public class Tree {
    private final int row;

    private final int column;

    private final int height;

    public Tree(int row, int column, int value) {
        this.row = row;
        this.column = column;
        this.height = value;
    }

    public int getHeight() {
        return height;
    }

    public boolean isTallerThan(int highest) {
        return this.height > highest;
    }

    public int heightIncrement(int previousHighest) {
        return height - previousHighest;
    }
}
