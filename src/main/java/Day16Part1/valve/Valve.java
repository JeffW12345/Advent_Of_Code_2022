package Day16Part1.valve;

import java.util.ArrayList;

public class Valve {
    private int flowScore;
    private final ArrayList<Valve> leadsTo = new ArrayList<>();

    private final String reference;

    private boolean isOpen = false;

    public Valve(int flowScore, String reference) {
        this.flowScore = flowScore;
        this.reference = reference;
    }

    public void addTunnel(String tunnel) {
        leadsTo.add(Valves.getValveFor(tunnel.trim()));
    }

    public ArrayList<Valve> getLeadsTo() {
        return leadsTo;
    }

    public void close(){
        isOpen = false;
    }

    public void open(){
        isOpen = true;
    }

    public String getReference() {
        return this.reference;
    }
    public boolean isOpen(){
        return isOpen;
    }

    public boolean pressureAboveZero(){
        return flowScore > 0;
    }

    public int getFlowScore(){ return flowScore;}
}
