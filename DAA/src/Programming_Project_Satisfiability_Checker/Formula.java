package Programming_Project_Satisfiability_Checker;
/** Formula class, uses an ArrayList to store Clauses, goes through each clause to make sure that it can be satisfied
 * @author Sean McKay
 */

import java.util.ArrayList;
import java.util.List;

public class Formula {
    List<Clause> list = new ArrayList<>(); // The overarching structure is an ArrayList of clauses, allows for quick access
    List<Boolean> variables = new ArrayList<>();
    int variableIteration = 0;
    private int numVariables = 0;

    public Formula() {    }

    public void add(Clause clause) {
        list.add(clause);
    }

    public boolean testFormula()
    {   boolean notDone = true;
        while(notDone)
        {
            int i = 0;
            while(i < list.size())
            {
                 if (!(testClause(list.get(i)))) //Testing each one at a time, if a clause doesn't work:
                {
                    //System.out.println("variableIterations: " + variableIteration);  //Test to see how many iterations we've been through

                    if (wentThroughVariableList()) //Went through the whole list, no possible outcomes
                        return false;

                    incrementVariableList(); //If it fails, keep doing it but increment the variables

                    i = -1;
                }
                 i++;
            }
            notDone = false;
        }
        return true;  //If it goes through all the clauses, and none fail in an iteration, it returns true
    }

    //Went through entire variable list, typically means that there's no possible outcomes
    private boolean wentThroughVariableList() {
        for(int i=0; i < variables.size(); i++)
        {
            if(! variables.get(i)) //If any of them are false, we aren't finished with the list
                return false;
        }
        return true;
    }

    private boolean testClause(Clause clause) {
        return clause.checkClause(variables);
    }


    public void incrementVariableList()
    {
        variableIteration++;
        String booleanCounter = Integer.toBinaryString(variableIteration); //Converts int to binary

        //Adding additional 0's to the front of the boolean string
        while(booleanCounter.length() < numVariables)
            booleanCounter = "0" + booleanCounter;

        for(int i = 0; i < booleanCounter.length(); i++)
        {
            if(booleanCounter.charAt(i) == '0')
                variables.set(i, false);
            else
                variables.set(i, true);
        }
    //System.out.println(variables);  //Test to see how the variables are changing
    }

    public void setVariables(int parseInt) {
        for(int i = 1; i <= parseInt; i++) {
            variables.add(false);
            numVariables = i;
        }
    }
}
