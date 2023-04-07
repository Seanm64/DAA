package org.example;

import org.sat4j.minisat.SolverFactory;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.ISolver;
import org.sat4j.core.VecInt;
import org.sat4j.specs.TimeoutException;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class Clauses {
    private List<String> clauses = new ArrayList<>();
    private int smallBoxSize, fullBoxSize, encoder;
    private int[][] array;
    private ISolver solver = SolverFactory.newDefault();
//    private StringBuilder clause = new StringBuilder();


    public Clauses(int smallBoxSize) {
        this.smallBoxSize = smallBoxSize;
        fullBoxSize = smallBoxSize * smallBoxSize;
        solver.setTimeout(3600);
//        encoder = fullBoxSize;
        encoder = 10;
    }

    public void addClause(String clause) {
        clauses.add(clause);
    }


    private void generateClauses() {
//        everyCellMustHaveOneValue(); //THIS WORKS PERFECTLY
//        everyCellCannotHaveMoreThanOneValue(); //THIS WORKS PERFECTLY
//        noTwoCellsInARowCanHaveTheSameValue(); //THIS WORKS PERFECTLY
//        noTwoCellsInAColumnCanHaveTheSameValue(); //THIS WORKS PERFECTLY
          noTwoCellsInABlockCanHaveTheSameValue();
        System.out.println(clauses);

    }

    private void noTwoCellsInABlockCanHaveTheSameValue() {
        for(int i = 1; i <= fullBoxSize; i++)
        {
            for(int j = 1; j <= fullBoxSize; j++)
            {
                for(int value = 1; value <= fullBoxSize; value++)
                {
                    //get every number already in the small square containing the position
                    //These numbers will help us figure out what "box" we're in

                    int x = i / smallBoxSize;
                    x = x * smallBoxSize; //Starting X
                    int endX = x * smallBoxSize + smallBoxSize;
                    int y = j / smallBoxSize;
                    y = y * smallBoxSize; //Starting Y
                    int endY = y * smallBoxSize + smallBoxSize;

                    for (int boxX = x; boxX < endX; boxX++)
                        for (int boxY = y; boxY < endY; boxY++) {
                            //Do the whole row, then go on to the next column
                            for(int pairX = x; pairX < endX; pairX++)
                                for(int pairY = y; pairY < endY; pairY++)
                                {
                                    if(pairY != boxY && pairX != boxX) {
                                        int variable1, variable2;

                                        variable1 = -1 * ((boxX+1) * encoder * encoder + (boxY+1) * encoder + value);
                                        variable2 = -1 * ((pairX+1) * encoder * encoder + (pairY+1) * encoder + value);

                                        clauses.add(variable1 + " " + variable2 + " 0\n");
                                    }
                                }
                        }
                }
            }
        }
    }

    private void noTwoCellsInAColumnCanHaveTheSameValue() {
        for(int j = 1; j <= fullBoxSize; j++)
            for(int i = 1; i <= fullBoxSize; i++)
                for(int value = 1; value <= fullBoxSize; value++)
                    for(int pairI = 1; pairI <= fullBoxSize; pairI++)
                        if(pairI != i) {
                            int variable1, variable2;
                            variable1 = -1 * (i * encoder * encoder + j * encoder + value);
                            variable2 = -1 * (pairI * encoder * encoder + j * encoder + value);
                            clauses.add(variable1 + " " + variable2 + " 0\n");
                        }
    }


    private void everyCellMustHaveOneValue() {
        for (int i = 1; i <= fullBoxSize; i++)
            for (int j = 1; j <= fullBoxSize; j++) {
                String clause = "";
                for (int k = 1; k <= fullBoxSize; k++)
                        clause += (i*encoder*encoder + j*encoder + k + " ");

                clause += ("0\n");
                clauses.add(clause);
            }

    }

    private void everyCellCannotHaveMoreThanOneValue() {
        //For each square in the sudoku, cannot, one spot cannot share a spot with another value
        for(int i = 1; i <= fullBoxSize; i++)
            for(int j = 1; j <= fullBoxSize; j++)
                for(int value = 1; value <= fullBoxSize; value++)
                    for(int pair = 1; pair <= fullBoxSize; pair++)
                        if(value != pair) {
                            int variable1, variable2;
                            variable1 = -1 * (i*encoder*encoder + j*encoder + value);
                            variable2 = -1 * (i*encoder*encoder + j*encoder + pair);

                            clauses.add(variable1 + " " + variable2 + " 0\n");
                        }
    }

    private void noTwoCellsInARowCanHaveTheSameValue() {
        for(int i = 1; i <= fullBoxSize; i++)
            for(int j = 1; j <= fullBoxSize; j++)
                for(int value = 1; value <= fullBoxSize; value++)
                    for(int pairJ = 1; pairJ <= fullBoxSize; pairJ++)
                        if(pairJ != j) {
                            int variable1, variable2;
                            variable1 = -1 * (i * encoder * encoder + j * encoder + value);
                            variable2 = -1 * (i * encoder * encoder + pairJ * encoder + value);
                            clauses.add(variable1 + " " + variable2 + " 0\n");
                        }
    }






    /*
        REMOVE BELLOW STUFF
     */

    private void generateClauses(int THISONEDOESNTWORK) {
        //For EACH POSITION, create a temporary array of every value that can't be entered in that position
            //Use that to find the normal and negated clauses
        for(int i = 0; i < fullBoxSize; i++) // rows
        {
            for(int j = 0; j < fullBoxSize; j++) //columns
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


                    // So right now, we know every number we can't use for that one spot
                    //One number at a time, fill out the negate of that number's row, column and square
                    for (int k = 1; k <= fullBoxSize; k++) {
                        int[] clause;

                        if (cantUse.contains(k)) //Can't be this number, so creates a negate clause
//                            clauses.append(-1 * i*encoder*encoder*100 + j * 10*encoder + k);
//                            clauses.append(-1 * i*100 + j * 10 + k);
                            System.out.println(""); //Just to get rid of error

                        else

                        {
//                            fillRows(k,i, j);
                            System.out.println(clauses);
//                            fillColumns(k, i, j);
                            System.out.println(clauses);
//                            fillSquare(k, i, j);
                            System.out.println(clauses);
                        }

                    }
            }
        }
    }

    private void fillFile()
    {
        //Insert the p cnf # # here


        //Then add the whole stringBuilder to the file
        try {
            FileWriter myWriter = new FileWriter("sudoku.cnf");

            myWriter.append("Tear\n\nBear");

            myWriter.close(); //It's important to close this lol


        } catch (IOException e) {
            System.out.println("An file error occurred.");
            e.printStackTrace();
        }
    }

   /* private void fillRows(int k, int i, int j) {
        for(int ndx = 1; ndx < fullBoxSize; ndx++)
        {
            //Create a bunch of negate clauses and 1 single acceptance clause at (i,j) , i stays the same though
            if(ndx == j)
//                clauses.append(i*100*encoder*encoder + ndx*encoder * 10 + k);
                clauses.append(i*100+ ndx*10 + k);

            else
//                clauses.append(-1 * i*100*encoder + ndx * encoder * 10 + k);
                clauses.append(-1 * i*100 + ndx*10 + k);


            clauses.append(" ");
        }
        clauses.append(0 + "\n");
    }
*/

    /*private void fillColumns(int k,int i, int j) {
        for(int ndx = 1; ndx < fullBoxSize; ndx++)
        {
            //Create a bunch of negate clauses and 1 single acceptance clause at (i,j) , i stays the same though
            if(ndx == i){
//                clauses.append(ndx*100*encoder*encoder + j * 10 * encoder + k);
                clauses.append(ndx*100 + j * 10+ k);}

            else{}
//                clauses.append(-1 * ndx*100*encoder*encoder + j*encoder * 10 + k);
                clauses.append(-1 * ndx + j* 10 + k);


            clauses.append(" ");
        }
        clauses.append(0 + "\n");

    }
*/
    /*private void fillSquare(int k, int i, int j) {
        int x = i / smallBoxSize;
        int endX = x * smallBoxSize + smallBoxSize;
        int y = j / smallBoxSize;
        int endY = y * smallBoxSize + smallBoxSize;

        //If we multiply X and Y by smallBox, we can start at the START of that box, and work our way through the whole box
        for (int boxX = x * smallBoxSize; boxX < endX; boxX++)
            for (int boxY = y * smallBoxSize; boxY < endY; boxY++)
            {
                if(boxX == i && boxY == j)
//                    clauses.append(i*100*encoder*encoder + j * 10 * encoder + k);
                    clauses.append(i*100 + j * 10+ k);

                else
//                    clauses.append(-1 * boxX*100*encoder*encoder + boxY*encoder * 10 + k);
                    clauses.append(-1 * boxX*100 + boxY* 10 + k);

                clauses.append(" ");
            }

        clauses.append(0 + "\n");
    }
*/

    /** Goes through many helper functions to test to see if it is solvable
     *
     * @return true IFF the puzzle is solvable, false otherwise
     */
    public boolean solve(int[][] sodokuContainer) throws ContradictionException, TimeoutException {
        array = sodokuContainer;

        //Generate all the clauses
        generateClauses();
//        System.out.println(clauses);

        //Add all the clauses to the solver
//        updateSolver();

        //See if the solver can do it's thang
        solveIt();

        return true;
    }

    private void solveIt() throws TimeoutException {
        System.out.println(solver.isSatisfiable());

    }

    /**
     * Adds all the newly generated clauses to the solver
     */
    /*private void updateSolver() throws ContradictionException {
        for(int i = 0; i < list.size(); i++) {
                    solver.addClause(new VecInt((int[]) list.get(i)));
        }
    }*/
}
