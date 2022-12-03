package Day2Part2;

import Day2Part2.move.MyMove;
import Day2Part2.move.OpponentMove;

import java.util.HashMap;

public class Moves {
    HashMap<Integer, OpponentMove> referenceToOpponentMove = new HashMap<>();
    HashMap<Integer, MyMove> referenceToMyMove = new HashMap<>();

    public void addToMyMove(int reference, MyMove move){
        referenceToMyMove.put(reference, move);
    }

    public void addToOpponentMove(int reference, OpponentMove move){
        referenceToOpponentMove.put(reference, move);
    }
}
