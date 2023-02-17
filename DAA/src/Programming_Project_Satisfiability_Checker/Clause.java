package Programming_Project_Satisfiability_Checker;
/** Clause class - Stores a map of variables, compares the variables to check if they can be satisfied
 * @author Sean McKay
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Clause {
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

    public boolean checkClause(List<Boolean> variables)
    {
        if(map.size() == 0)
            return true; //If the clause is empty, don't bother going through the list

        for(int i = 0; i < variables.size(); i++)
        {
            int lookingFor = i+1; //Since the boolean variable list is 1 off, we want to add 1 to it

            if(map.containsKey(lookingFor)) //If the map contains something in the list
            {
                //Check to see if it any of them can return true, 1 true means the clause is fufilled
                if(map.get(lookingFor) && ! variables.get(lookingFor-1)) //If variables = false, but it's a NOT clause
                    return true;
                if(! (map.get(lookingFor)) && variables.get(lookingFor-1)) //If variables = true, and it's normal
                     return true;
            }
        }
        return false;  //If it goes through the whole list, this clause is not satisfied
    }
}
