package Day16Part1;

import Day16Part1.valve.Valve;
import Day16Part1.valve.Valves;

import java.util.ArrayList;

public class ProcessData {
    private final ImportData importData;
    private final Valves valves = new Valves();
    private int maximumFlow = 0;

    public ProcessData(ImportData data) {
        this.importData = data;
        createAndStoreValveObjects();
        printResults();
    }

    private void printResults() {
        System.out.println("Max flow: " + maximumFlow);
    }

    public void createAndStoreValveObjects() {
        createValves();
        addTunnels();
        calculateMaximumFlow();
    }

    private void calculateMaximumFlow(){
        ArrayList<String> combinationsStringified = new ArrayList<>();
        combinationsStringified.add("moveTo-AA");
        boolean canExpandList = true;
        while(canExpandList){
            canExpandList = false;
            for(String combination : combinationsStringified){
                if(CombinationOfMinutes.canExpand(combination, combinationsStringified)){
                    canExpandList = true;
                    combinationsStringified.add(CombinationOfMinutes.newCombination(combination, combinationsStringified));
                    valves.closeAll();
                    break;
                }
                else{
                    maximumFlow = Math.max(CombinationOfMinutes.score(combination), maximumFlow);
                }
                //System.out.println(combinationsStringified.get(combinationsStringified.size() - 1));
            }
        }

    }
    private void createValves() {
        for (int rowNumber = 0; rowNumber < importData.numberOfRows(); rowNumber++) {
            String row = importData.releaseDataRow(rowNumber);
            String valveReference = row.split(" has")[0]
                    .substring(row.split(" has")[0].length() - 2);
            valves.add(valveReference, new Valve(Integer.parseInt(row.split("flow rate=")[1].split(";")[0]),
                    valveReference));
        }
    }

    private void addTunnels() {
        for (int rowNumber = 0; rowNumber < importData.numberOfRows(); rowNumber++) {
            String row = importData.releaseDataRow(rowNumber);
            String valveReference = row.split(" has")[0].substring(row.split(" has")[0].length() - 2);
            String tunnels = row.contains("to valves ") ? row.split("to valves ")[1]
                    : row.split("to valve ")[1];
            String [] tunnelsAsArray = tunnels.split(",");
            Valve valve = Valves.getValveFor(valveReference);
            for(String tunnel : tunnelsAsArray){
                valve.addTunnel(tunnel);
            }
        }
    }
}

