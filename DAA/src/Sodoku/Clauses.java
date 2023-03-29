package org.example;

import org.sat4j.minisat.SolverFactory;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.ISolver;
import org.sat4j.core.VecInt;


import java.util.ArrayList;
import java.util.List;

public class Clauses {
    private List list = new ArrayList<>();
    private int smallBoxSize, fullBoxSize;
    private int[][] array;
    private ISolver solver = SolverFactory.newDefault();


    public Clauses(int smallBoxSize) {
        this.smallBoxSize = smallBoxSize;
        fullBoxSize = smallBoxSize * smallBoxSize;
    }

    public void addClause(int[] clause) {
        list.add(clause);
    }


    /**
     * Helper Function to generate all the clauses
     */
    private void generateClauses() {
        //For EACH POSITION, create a temporary array of every value that can't be entered in that position
            //Use that to find the normal and negated clauses
        for(int i = 0; i < fullBoxSize; i++)
        {
            for(int j = 0; j < fullBoxSize; j++)
            {
                System.out.println("i= " + i + "\nj=" + j);
                //If the spot is NOT a 0, then every clause can be a negated clause
                if(array[i][j] != 0)
                {
                    int numberInPosition = array[i][j];
                    for(int k = 1; k <= fullBoxSize; k++)
                    {
                        if(numberInPosition != k) { //The number already exists in the arrayList, make everything else negated
                            int[] clause = {i+1, j+1, k * -1};
                            this.addClause(clause);
                        }
                    }
                }
                else //Else, the spot IS a 0, we have to figure out what clauses can fill that spot
                {
                    List<Integer> cantUse = new ArrayList();

                    //get every number already in this column
                    for (int row = 0; row < fullBoxSize; row++)
                        cantUse.add(array[row][j]);

                    //get every number already in this row
                    for (int column = 0; column < fullBoxSize; column++)
                        cantUse.add((array[i][column]));

                    //get every number already in the small square containing the position
                    //These numbers will help us figure out what "box" we're in
                    int x = i / smallBoxSize;
                    int endX = x * smallBoxSize + smallBoxSize;
                    int y = j / smallBoxSize;
                    int endY = y * smallBoxSize + smallBoxSize;

                    //If we multiply X and Y by smallBox, we can start at the START of that box, and work our way through the whole box
                    for (int boxX = x * smallBoxSize; boxX < endX; boxX++)
                        for (int boxY = y * smallBoxSize; boxY < endY; boxY++)
                            cantUse.add(array[boxX][boxY]); //Will submit every number in the smaller box

                    //Make a normal + negated clause based off of the cantUse arraylist
                    for (int k = 1; k <= fullBoxSize; k++) {
                        int[] clause;

                        if (cantUse.contains(k))
                            clause = new int[]{i+1, j+1, k * -1}; //Negated Clause
                        else
                            clause = new int[]{i+1, j+1, k}; //Normal Clause

                        this.addClause(clause);
                    }
                }
            }
        }
    }

    /** Goes through many helper functions to test to see if it is solvable
     *
     * @return true IFF the puzzle is solvable, false otherwise
     */
    public boolean solve(int[][] sodokuContainer) throws ContradictionException {
        array = sodokuContainer;

        //Generate all the clauses
        generateClauses();

        //Add all the clauses to the solver
        updateSolver();

        //See if the solver can do it's thang

        return true;
    }

    /**
     * Adds all the newly generated clauses to the solver
     */
    private void updateSolver() throws ContradictionException {
        for(int i = 0; i < list.size(); i++) {
                    solver.addClause(new VecInt((int[]) list.get(i)));
        }
    }
}
