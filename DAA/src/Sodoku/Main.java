package org.example;
/** Sodoku - Transform and Conquer algorithm
 * @author Sean McKay
 */

import org.sat4j.core.VecInt;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.ISolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, ContradictionException {
        File dir = new File("sodokuInputs");
        File[] files = dir.listFiles();

        Scanner fileReader = new Scanner(files[0]);   //READING IN DATA FROM sodokuInputs
        ISolver solver = SolverFactory.newDefault();


        int boxLength, boxWidth;
        int rowCounter = 0;
        int[] clause = {0, 0, 0};
        List clauseList = new ArrayList<>();
        String[] input;

        //Finding and creating the sodokuContainer
        boxLength = Integer.parseInt(fileReader.nextLine());
        boxLength = boxLength * boxLength;
        boxWidth = Integer.parseInt(fileReader.nextLine());
        boxWidth = boxWidth * boxWidth;
        int[][] sodokuContainer = new int[boxLength][boxWidth];

        while (fileReader.hasNext()) {
            input = fileReader.nextLine().split(" "); //Split the whole line by " "

            rowCounter++;
            for(int columnCounter = 1; columnCounter < input.length+1; columnCounter++)
            {
                clause[0] = rowCounter;
                clause[1] = columnCounter;
                clause[2] = Integer.parseInt(input[columnCounter-1]);
                sodokuContainer[rowCounter-1][columnCounter-1] = clause[2];


                if(clause[2] != 0)
                {
                    clauseList.add(clause);
//                    solver.addClause(new VecInt((Integer) clauseList.get(0)));
//                    System.out.println(clause[0] + " " + clause[1] + " " + clause[2]) ;
                }
            }
        }

        //Generate Every Clause Function


        //Add all the clauses to the solver


        //See if the solver can do it's thang


        //Reverse engineer it


        //Print out new 2D array (if can)


        //Trying to print out the whole sodoku List to see what's in it
        for(int i = 0; i < boxLength; i++) {
            for (int j = 0; j < boxWidth ; j++) {
                System.out.print(sodokuContainer[i][j] + " ");
            }
            System.out.println("");
        }
    }

}