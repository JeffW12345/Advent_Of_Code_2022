package Day5Part2;

public class Move {
    private int numberOfCrates;
    private int moveFrom;
    private int moveTo;
    Crates crates;

    public Move(int numberOfCrates, int moveFrom, int moveTo, Crates crates) {
        this.numberOfCrates = numberOfCrates;
        this.moveFrom = moveFrom;
        this.moveTo = moveTo;
        this.crates = crates;
        execute();
    }

    public void execute(){
        crates.transferBetweenCrates(numberOfCrates, moveFrom, moveTo);
    }
}
