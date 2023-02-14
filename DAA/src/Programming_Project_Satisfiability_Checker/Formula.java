package Programming_Project_Satisfiability_Checker;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Formula {
    List<Clause> list = new LinkedList<>(); // The overarching structure is a LinkedList of clauses, if one clause is false
    List<Boolean> variables = new ArrayList<>();

    public Formula()
    {
        setVariableList();
    }

    public void add(Clause clause) {
        list.add(clause);
    }

    public boolean testClauses()
    {
        for(int i = 0; i < list.size(); i++) {
            if (!(testClause(list.get(i)))) //Testing each one at a time, if a clause doesn't work:
            {
                //incrementVariableList(); //If it fails, keep doing it but increment the variables
                if(wentThroughVariableList()) //Went through the whole list, no possible outcomes
                    return false;

                return testClauses();
            }
        }
        return true;  //If it goes through all of the clauses, and none fail in an iteration, it returns true
    }

    //Went through entire variable list, typically means that there's no possible outcomes
    private boolean wentThroughVariableList() {
        for(int i=0; i <= list.size(); i++)
        {
            if(! variables.get(i)) //If any of them are false, we aren't finished with the list
                return false;
        }
        return true;
    }

    private boolean testClause(Clause clause) {
        return clause.checkClause(variables);
    }


    private void setVariableList()
    {
        for(int i = 1; i <= list.size(); i++)
            variables.add(false);
    }
}
