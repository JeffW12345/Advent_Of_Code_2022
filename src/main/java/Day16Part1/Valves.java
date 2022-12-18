package Day16Part1;

import java.util.HashMap;

public class Valves {
    private static final HashMap<String, Valve> valveCodeToValve = new HashMap<>();
    public static Valve getValveFor(String code){
        return valveCodeToValve.get(code);
    }
    public void add(String valveCode, Valve valve){
        valveCodeToValve.put(valveCode, valve);
    }

    public void closeAll(){
        for(Valve valve: valveCodeToValve.values()){
            valve.close();
        }
    }
}
