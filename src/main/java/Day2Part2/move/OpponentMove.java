package Day2Part2.move;

import Day2Part2.MoveTypes;

public class OpponentMove extends Move {

    public OpponentMove(MoveTypes moveType) {
        super(moveType);
    }

    public MoveTypes opponentWinner(MoveTypes opponentMoveType) {
        if(opponentMoveType == MoveTypes.ROCK){
            return MoveTypes.SCISSORS;
        }
        if(opponentMoveType == MoveTypes.SCISSORS){
            return MoveTypes.PAPER;
        }
        return MoveTypes.ROCK;
    }

    public MoveTypes opponentDraw(MoveTypes opponentMoveType) {
        if(opponentMoveType == MoveTypes.ROCK){
            return MoveTypes.ROCK;
        }
        if(opponentMoveType == MoveTypes.SCISSORS){
            return MoveTypes.SCISSORS;
        }
        return MoveTypes.PAPER;
    }

    public MoveTypes opponentLoser(MoveTypes opponentMoveType) {
        if(opponentMoveType == MoveTypes.PAPER){
            return MoveTypes.SCISSORS;
        }
        if(opponentMoveType == MoveTypes.ROCK){
            return MoveTypes.PAPER;
        }
        return MoveTypes.ROCK;
    }

}
