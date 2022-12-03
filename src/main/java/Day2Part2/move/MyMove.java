package Day2Part2.move;

import Day2Part2.MoveTypes;

public class MyMove extends Move {
    public MyMove(MoveTypes moveType) {
        super(moveType);
    }

    public MoveTypes newChoice(OpponentMove opponentMove) {
        //System.out.println(moveType);
        // If rock, I need to lose
        if(this.moveType == MoveTypes.ROCK){
            return opponentMove.opponentWinner(opponentMove.moveType);
        }
        // If paper, I need to draw
        if(this.moveType == MoveTypes.PAPER){
            return opponentMove.opponentDraw(opponentMove.moveType);
        }
        // If scissors, I need to win
        return opponentMove.opponentLoser(opponentMove.moveType);
    }

    public boolean isWinner() {
        return moveType == MoveTypes.SCISSORS;
    }

    public boolean isDraw() {
        return moveType == MoveTypes.PAPER;
    }
}
