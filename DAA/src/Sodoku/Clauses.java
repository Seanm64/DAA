package org.example;


import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class Clauses {
    private List<String> clauses = new ArrayList<>();
    private int smallBoxSize, fullBoxSize, encoder;
    private int[][] array;


    public Clauses(int smallBoxSize) {
        this.smallBoxSize = smallBoxSize;
        fullBoxSize = smallBoxSize * smallBoxSize;
        encoder = fullBoxSize + 1;
    }

    public void addClause(String clause) {
        clauses.add(clause);
    }

    public List getClauses() {
        return clauses;
    }


    public void generateClauses(int[][] sodokuContainer) {
        array = sodokuContainer;

        everyCellMustHaveOneValue();
        everyCellCannotHaveMoreThanOneValue();
        noTwoCellsInARowCanHaveTheSameValue();
        noTwoCellsInAColumnCanHaveTheSameValue();
        noTwoCellsInABlockCanHaveTheSameValue();
        fillTableBasedOffConstraints();

        sendClausesToTextFile();
    }

    private void sendClausesToTextFile() {
        try {
            FileWriter myWriter = new FileWriter("sudoku.cnf");
            int maxNumOfClauses = fullBoxSize * encoder * encoder + fullBoxSize * encoder + fullBoxSize;

            myWriter.write("p cnf " + maxNumOfClauses + " " + clauses.size() + "\n");
            for(int i = 0; i < clauses.size(); i++) {
                myWriter.append(clauses.get(i));
                if(i != clauses.size() - 1)
                    myWriter.append("\n");
            }

            myWriter.close();


        } catch (IOException e) {
            System.out.println("An file error occurred.");
            e.printStackTrace();
        }
    }

    private void noTwoCellsInABlockCanHaveTheSameValue() {
        for(int i = 0; i < fullBoxSize; i += smallBoxSize)
            for(int j = 0; j < fullBoxSize; j += smallBoxSize)
                for(int value = 1; value <= fullBoxSize; value++)
                {
                    //get every number already in the small square containing the position
                    //These numbers will help us figure out what "box" we're in

                    int x = i / smallBoxSize;
                    x = x * smallBoxSize; //Starting X
                    int endX = x + smallBoxSize;

                    int y = j / smallBoxSize;
                    y = y * smallBoxSize; //Starting Y
                    int endY = y + smallBoxSize;

                    for (int boxX = x; boxX < endX; boxX++)
                        for (int boxY = y; boxY < endY; boxY++)

                            //Do the whole row, then go on to the next column
                            for(int pairX = x+1; pairX <= endX; pairX++)
                                for(int pairY = y+1; pairY <= endY; pairY++)
                                    if(pairY != boxY+1 || pairX != boxX+1)
                                    {
                                        int variable1, variable2;

                                        variable1 = -1 * ((boxX+1) * encoder * encoder + (boxY+1) * encoder + value);
                                        variable2 = -1 * ((pairX) * encoder * encoder + (pairY) * encoder + value);

                                        clauses.add(variable1 + " " + variable2 + " 0");
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
                            clauses.add(variable1 + " " + variable2 + " 0");
                        }
    }


    private void everyCellMustHaveOneValue() {
        for (int i = 1; i <= fullBoxSize; i++)
            for (int j = 1; j <= fullBoxSize; j++) {
                String clause = "";
                for (int k = 1; k <= fullBoxSize; k++)
                        clause += (i*encoder*encoder + j*encoder + k + " ");

                clause += ("0");
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

                            clauses.add(variable1 + " " + variable2 + " 0");
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
                            clauses.add(variable1 + " " + variable2 + " 0");
                        }
    }



    private void fillTableBasedOffConstraints() {
        //For EACH POSITION, create a temporary array of every value that can't be entered in that position
            //Use that to find the normal and negated clauses
        for(int i = 0; i < fullBoxSize; i++) // rows
        {
            for(int j = 0; j < fullBoxSize; j++) //columns
            {
                    if(array[i][j] == 0)
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
                    for (int value = 1; value <= fullBoxSize; value++) {
                        int[] clause;

                        if (cantUse.contains(value)) //Can't be this number, so creates a negate clause
                            clauses.add((-1 * ((i+1) * encoder * encoder + (j+1) * encoder + value)) + " 0");
                        else {
                            fillRows(value, i+1, j+1);            //Inefficient with repeated clauses
                            fillColumns(value, i+1, j+1);         //Inefficient with repeated clauses
                            fillSquare(value, i+1, j+1);       //Good enough for government work
//                            System.out.println(clauses);
                        }
                    }
                }
            }
        }
    }

    private void fillRows(int k, int i, int j) {
        String clause = "";

        for(int ndx = 1; ndx <= fullBoxSize; ndx++)
        {
            //Create a bunch of negate clauses and 1 single acceptance clause at (i,j) , i stays the same though
            if(ndx == j)
//                clauses.append(i*100*encoder*encoder + ndx*encoder * 10 + k);
                clause += (i*encoder*encoder+ ndx*encoder + k) + " ";

            else
//                clauses.append(-1 * i*100*encoder + ndx * encoder * 10 + k);
                clause += (-1 * (i*encoder*encoder + ndx*encoder + k)) + " ";
        }
        clauses.add(clause + " 0");
    }

    private void fillColumns(int k,int i, int j) {
        String clause = "";

        for(int ndx = 1; ndx <= fullBoxSize; ndx++)
        {
            //Create a bunch of negate clauses and 1 single acceptance clause at (i,j) , i stays the same though
            if(ndx == i)
//                clauses.append(i*100*encoder*encoder + ndx*encoder * 10 + k);
                clause += (ndx*encoder*encoder+ j*encoder + k) + " ";

            else
//                clauses.append(-1 * i*100*encoder + ndx * encoder * 10 + k);
                clause += (-1 * (ndx*encoder*encoder + j*encoder + k)) + " ";
        }
        clauses.add(clause + " 0");
    }


    private void fillSquare(int k, int i, int j) {
        int x = i / smallBoxSize;
        int endX = x * smallBoxSize + smallBoxSize;
        int y = j / smallBoxSize;
        int endY = y * smallBoxSize + smallBoxSize;
        String clause = "";

        //If we multiply X and Y by smallBox, we can start at the START of that box, and work our way through the whole box
        for (int boxX = x * smallBoxSize; boxX < endX; boxX++)
            for (int boxY = y * smallBoxSize; boxY < endY; boxY++)
            {
                if(boxX == i && boxY == j)
                    clause += (i*encoder*encoder + j*encoder + k);

                else
                    clause += (-1 * (boxX*encoder*encoder + boxY*encoder + k));

                clause += " ";
            }

        clauses.add(clause + " 0");
    }
}
