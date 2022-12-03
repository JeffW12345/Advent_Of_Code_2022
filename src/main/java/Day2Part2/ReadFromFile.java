package Day2Part2;

import Day2Part2.move.MyMove;
import Day2Part2.move.OpponentMove;

import java.io.File;
import java.util.Scanner;

public class ReadFromFile {
    private final File file = new File("src/main/resources/paper-scissor-stone.txt");
    private Moves moves;

    public void readAndStoreActions(Moves moves){
        this.moves = moves;
        importData();
    }

    private void importData() {
        try {
            Scanner scanner = new Scanner(this.file);
            int count = 0;
            while (scanner.hasNextLine()) {
                String [] playerChoice = scanner.nextLine().split(" ");
                addOpponentMoveToDictionary(count, playerChoice[0]);
                addMyMoveToDictionary(count, playerChoice[1]);
                count++;
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void addMyMoveToDictionary(int count, String playerChoice) throws Exception {
        MoveTypes myMoveType = moveType(playerChoice);
        MyMove myMove = new MyMove(myMoveType);
        moves.addToMyMove(count, myMove);
    }

    private void addOpponentMoveToDictionary(int count, String playerChoice) throws Exception {
        MoveTypes moveType = moveType(playerChoice);
        OpponentMove opponentMove = new OpponentMove(moveType);
        moves.addToOpponentMove(count, opponentMove);
    }

    private MoveTypes moveType(String move) throws Exception {
        if(move.equals("A") || move.equals("X")){
            return MoveTypes.ROCK;
        }
        if(move.equals("B") || move.equals("Y")){
            return MoveTypes.PAPER;
        }
        if(move.equals("C") || move.equals("Z")){
            return MoveTypes.SCISSORS;
        }
        throw new Exception("Invalid string passed to moveType method");
    }

}
