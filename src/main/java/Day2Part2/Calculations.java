package Day2Part2;

import Day2Part2.move.MyMove;

public class Calculations {

    Moves moves;

    public int calculateScore(Moves moves){
        this.moves = moves;
        int score = 0;
        for(int i = 0; i < moves.referenceToMyMove.size(); i++){
            MyMove myMove = moves.referenceToMyMove.get(i);
            MoveTypes newMoveType = myMove.newChoice(moves.referenceToOpponentMove.get(i));
            if(myMove.isWinner()) score += 6;
            if(myMove.isDraw()) score += 3;
            if(newMoveType == MoveTypes.ROCK){
                score += 1;
            }
            if(newMoveType == MoveTypes.PAPER){
                score += 2;
            }
            if(newMoveType == MoveTypes.SCISSORS){
                score += 3;
            }
        }
        return score;
    }
}
