package Day5Part1;

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
        for(int i = 0; i < numberOfCrates; i++){
           crates.transferBetweenCrates(moveFrom, moveTo);
        }
    }
}
