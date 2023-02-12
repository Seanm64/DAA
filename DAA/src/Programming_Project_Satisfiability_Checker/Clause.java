package Programming_Project_Satisfiability_Checker;

import java.util.HashMap;
import java.util.Map;

public class Clause {
    private boolean result = false;
    Map<Integer, Boolean> map = new HashMap(); //Hashmap of integer and boolean (True = NOT, false = normal)


    public Clause(String[] load) {
        createClause(load);
    }

    public Clause() {
    }
    public void createClause(String[] load) {
        //This is the raw data, no comments should get through

        //Any positive number that comes through, set it's Boolean to FALSE
        for (int i = 0; i < load.length; i++) {
            int put = Integer.parseInt(load[i]);

            if (put > 0)
                map.put(put, false);
            if (put < 0)
                map.put(Math.abs(put), true);
        }
    }

    public void addVariable(int put)
    {
        if (put > 0)
            map.put(put, false);
        if (put < 0)
            map.put(Math.abs(put), true);
    }


    public boolean getBool(int i)
    {
        return map.get(i);
    }
}
