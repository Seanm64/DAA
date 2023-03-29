package org.example;

import java.util.ArrayList;
import java.util.List;

public class Clauses {
    private List list = new ArrayList<>();
    private int smallBoxSize, fullBoxSize;
    private int[][] array;

    public Clauses(int smallBoxSize) {
        this.smallBoxSize = smallBoxSize;
        fullBoxSize = smallBoxSize * smallBoxSize;
    }

    public void addClause(int[] clause) {
        list.add(clause);
    }



    private void generateClauses() {

        //First check to see if the clause already exists
        //If it does exist, make a bunch of negated clauses for that position
        for(int i = 0; i < fullBoxSize; i++)
        {
            for(int j = 0; j < fullBoxSize; j++)
            {
                //There already is an input for this position
                if(array[i][j] != 0)
                {
                    int number = array[i][j];
                    for(int turnIntoNegatedNumber = 1; turnIntoNegatedNumber < smallBoxSize; turnIntoNegatedNumber++)
                    {
                        if(turnIntoNegatedNumber != number)
                        {   //This doesn't work, it doesn't check any of the surrounding issues
                            int[] negatedClause = {i, j, turnIntoNegatedNumber * -1};
                            this.addClause(negatedClause);
                        }
                    }
                }
            }
        }

        //If it doesn't, check the row for a collision

        //Check the column for a collision

        //Check the small box for a collision
    }

    public boolean solve(int[][] sodokuContainer) {
        array = sodokuContainer;

        //Generate all of the clauses
        generateClauses();

        //Add all the clauses to the solver
//                    solver.addClause(new VecInt((Integer) clauseList.get(0)));


        //See if the solver can do it's thang


        //Reverse engineer it


        //Print out new 2D array (if can)

        return true;
    }
}
