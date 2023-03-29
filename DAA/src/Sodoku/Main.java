package org.example;
/** Sodoku - Transform and Conquer algorithm
 * @author Sean McKay
 */

import org.sat4j.specs.ContradictionException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, ContradictionException {
        File dir = new File("sodokuInputs");
        File[] files = dir.listFiles();

        Scanner fileReader = new Scanner(files[0]);   //READING IN DATA FROM sodokuInputs


        int rowCounter = 0;
        String[] input;

        //Finding and creating the sodokuContainer
        int smallBoxSize = Integer.parseInt(fileReader.nextLine());
        int fullBoxSize = Integer.parseInt(fileReader.nextLine());
        fullBoxSize = fullBoxSize * fullBoxSize;

        Clauses clauses = new Clauses(smallBoxSize);
        int[][] sodokuContainer = new int[fullBoxSize][fullBoxSize];

        while (fileReader.hasNext()) {
            input = fileReader.nextLine().split(" "); //Split the whole line by " "

            rowCounter++;
            for(int columnCounter = 1; columnCounter < input.length+1; columnCounter++)
            {
                int[] clause = {0, 0, 0}; //Instantiated here because I need the clause to delete itself after each iteration

                clause[0] = rowCounter;
                clause[1] = columnCounter;
                clause[2] = Integer.parseInt(input[columnCounter-1]);
                sodokuContainer[rowCounter-1][columnCounter-1] = clause[2];


                if(clause[2] != 0)
                    clauses.addClause(clause);
            }
        }

        //Print out the current Sodoku
        printSodoku(sodokuContainer, fullBoxSize);

        //Test to see if it is solvable
        boolean solved = clauses.solve(sodokuContainer);

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

