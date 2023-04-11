package org.example;
/** Sodoku - Transform and Conquer algorithm
 * @author Sean McKay
 */

import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.TimeoutException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, ContradictionException, TimeoutException {
        File dir = new File("sodokuInputs");
        File[] files = dir.listFiles();

        Scanner fileReader = new Scanner(files[0]);   //READING IN DATA FROM sodokuInputs


        int rowCounter = 0;
        String[] input;

        //Finding and creating the sodokuContainer
        int smallBoxSize = Integer.parseInt(fileReader.nextLine());
        int fullBoxSize = Integer.parseInt(fileReader.nextLine());
        int encoder = 10;

        fullBoxSize = fullBoxSize * fullBoxSize;

        Clauses clauses = new Clauses(smallBoxSize);
        int[][] sodokuContainer = new int[fullBoxSize][fullBoxSize];

        while (fileReader.hasNext()) {
            input = fileReader.nextLine().split(" "); //Split the whole line by " "

            rowCounter++;

            for(int columnCounter = 1; columnCounter < input.length+1; columnCounter++)
            {
                String clause = "";
                int variable = Integer.parseInt(input[columnCounter-1]);

                clause += (rowCounter*encoder*encoder + columnCounter*encoder + variable + " 0");
                sodokuContainer[rowCounter-1][columnCounter-1] = variable;

                if(variable != 0)
                    clauses.addClause(clause);
            }
        }

        //Print out the current Sodoku
        printSodoku(sodokuContainer, fullBoxSize);

        //Generate all clauses needed to solve the sudoku
        clauses.generateClauses(sodokuContainer);

        //Solve it
//        Solver solver = new Solver();

        //Reverse engineer it


        //Print out new 2D array (if can)


    }



    private static void printSodoku(int[][] array, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
    }
}

