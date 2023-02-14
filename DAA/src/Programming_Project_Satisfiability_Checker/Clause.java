package Programming_Project_Satisfiability_Checker;

import java.util.HashMap;
import java.util.Map;

public class Clause {
    private boolean result = false;
    Map<Integer, Boolean> map = new HashMap(); //Hashmap of integer and boolean (True = NOT, false = normal)


    public Clause() {
    }

    public void addVariable(int put)
    { //If it's NOT, it's flagged as true
        if (put > 0)
            map.put(put, false);
        if (put < 0)
            map.put(Math.abs(put), true);
    }

    public boolean checkClause()
    {


        return true;
    }


    public boolean getBool(int i)
    {
        return map.get(i);
    }

    public boolean finalRestult()
    {
        if(map.size() == 0)
            return true;

        return false;
    }
}
