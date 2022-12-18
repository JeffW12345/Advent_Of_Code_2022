package Day16Part1;

import java.util.ArrayList;

public class CombinationOfMinutes {

    public static boolean canExpand(String combination, ArrayList<String> allCombinationsSoFar) {
        ArrayList<Action> combinationAsList = stringToActionObjectList(combination);
        setOpenedValvesToOpen(combinationAsList);
        Valve finalValveInList = combinationAsList.get(combinationAsList.size() - 1).getValve();
        return doWeOpenValve(combination, allCombinationsSoFar, finalValveInList) ||
                canGoDownATunnel(combination, allCombinationsSoFar, finalValveInList);
    }

    private static boolean canGoDownATunnel(String combination, ArrayList<String> allCombinationsSoFar,
                                            Valve finalValveInList) {
        for (Valve availableValve : finalValveInList.getLeadsTo()) {
            MoveTo proposedMove = new MoveTo(availableValve);
            if (!followOnMoveAlreadyDone(combination, proposedMove.toString(), allCombinationsSoFar)
                    && combination.split(",").length < 31) {
                return true;
            }
        }
        return false;
    }

    private static boolean doWeOpenValve(String combinationAsString, ArrayList<String> allCombinationsSoFar,
                                         Valve valveToCheck) {
        if(combinationAsString.split(",").length > 30) return false;
        OpenValve proposed = new OpenValve(valveToCheck);
        return !valveToCheck.isOpen()
                && !followOnMoveAlreadyDone(combinationAsString, proposed.toString(), allCombinationsSoFar)
                && valveToCheck.pressureAboveZero();
    }

    private static boolean followOnMoveAlreadyDone(String combination, String proposedAction,
                                                   ArrayList<String> combinations) {
        return combinations.contains(combination + "," + proposedAction);
    }


    private static void setOpenedValvesToOpen(ArrayList<Action> combinations) {
        for (Action combination : combinations) {
            if (combination instanceof OpenValve) {
                combination.getValve().open();
            }
        }
    }

    private static ArrayList<Action> stringToActionObjectList(String action) {
        ArrayList<Action> combinations = new ArrayList<>();
        String[] actions = action.split(",");
        for (String anAction : actions) {
            Valve valve = Valves.getValveFor(anAction.split("-")[1]);
            if (anAction.split("-")[0].equals("moveTo")) {
                combinations.add(new MoveTo(valve));
            } else {
                combinations.add(new OpenValve(valve));
            }
        }
        return combinations;
    }

    public static String newCombination(String combination, ArrayList<String> allCombinationsSoFar) {
        ArrayList<Action> combinationAsList = stringToActionObjectList(combination);
        setOpenedValvesToOpen(combinationAsList);
        Valve finalValveInList = combinationAsList.get(combinationAsList.size() - 1).getValve();
        if (doWeOpenValve(combination, allCombinationsSoFar, finalValveInList)) {
            OpenValve openValve = new OpenValve(finalValveInList);
            return combination + "," + openValve;
        }
        else{
            for (Valve option : finalValveInList.getLeadsTo()) {
                MoveTo proposedMove = new MoveTo(option);
                if (!followOnMoveAlreadyDone(combination, proposedMove.toString(), allCombinationsSoFar)) {
                    return combination + "," + proposedMove;
                }
            }
        }
        return "";
    }

    public static int score(String combination) {
        String [] actions = combination.split(",");
        int total = 0;
        // Minute 0 is arrival at AA, so won't result in any points.
        for(int minute = 0; minute < actions.length; minute++){
            if(actions[minute].split("-")[0].equals("open-")){
                Valve valve = Valves.getValveFor(actions[minute].split("-")[1]);
                total += (minute * valve.getFlowScore());
            }
        }
        return total;
    }
}
