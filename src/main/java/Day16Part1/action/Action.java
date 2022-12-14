package Day16Part1.action;

import Day16Part1.valve.Valve;

public class Action {
    private final Valve valve;

    public Valve getValve() {
        return valve;
    }
    public Action(Valve valve) {
        this.valve = valve;
    }
    @Override
    public String toString() {
        if(this instanceof MoveTo){
            return "moveTo-" + this.getValve().getReference();
        }
        else{
            return "open-" + this.getValve().getReference();
        }
    }
}
