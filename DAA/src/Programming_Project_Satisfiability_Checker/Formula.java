package Programming_Project_Satisfiability_Checker;

import java.util.ArrayList;
import java.util.List;

public class Formula {
    List<Clause> list = new ArrayList<>(); // The overarching structure is a ArrayList of clauses, easy to gain access to
    List<Boolean> variables = new ArrayList<>();
    int variableIteration = 0;
    private int numVariables = 0;

    public Formula() {    }

    public void add(Clause clause) {
        list.add(clause);
    }

    public boolean testFormula()
    {
        for(int i = 0; i < list.size(); i++) {
            if (!(testClause(list.get(i)))) //Testing each one at a time, if a clause doesn't work:
            {
                //System.out.println("variableIterations: " + variableIteration);

                incrementVariableList(); //If it fails, keep doing it but increment the variables
                if(wentThroughVariableList()) //Went through the whole list, no possible outcomes
                    return false;

                return testFormula();
            }
        }
        return true;  //If it goes through all the clauses, and none fail in an iteration, it returns true
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


    public void incrementVariableList()
    {
        variableIteration++;
        String booleanCounter = Integer.toBinaryString(variableIteration); //Converts int to binary

        //Adding additional 0's to the front of the boolean string
        while(booleanCounter.length() < numVariables)
        {
            booleanCounter = "0" + booleanCounter; //This would be SO MUCH more space efficient with a StringBuilder, but that's okay
        }

        for(int i = 0; i < booleanCounter.length(); i++)
        {
            if(booleanCounter.charAt(i) == '0')
                variables.set(i, false);
            else
                variables.set(i, true);
        }
    //System.out.println(variables);  //To test if the variables are changing
    }

    public void setVariables(int parseInt) {
        for(int i = 1; i <= parseInt; i++) {
            variables.add(false);
            numVariables = i;
        }
    }
}
