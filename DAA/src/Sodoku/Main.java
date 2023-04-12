package org.example;
/** Sodoku - Transform and Conquer algorithm
 * @author Sean McKay
 */

import org.sat4j.reader.ParseFormatException;
import org.sat4j.specs.ContradictionException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, ContradictionException {
        File dir = new File("sodokuInputs");
        File[] files = dir.listFiles();

        //Go through every file
        for(int fileIterator = 0; fileIterator < 5; fileIterator++) {
            Scanner fileReader = new Scanner(files[fileIterator]);   //READING IN DATA FROM sodokuInputs


            int rowCounter = 0;
            String[] input;

            //Finding and creating the sodokuContainer
            int smallBoxSize = Integer.parseInt(fileReader.nextLine());
            int fullBoxSize = Integer.parseInt(fileReader.nextLine()) * smallBoxSize;
            int encoder = fullBoxSize + 1;

            Clauses clauses = new Clauses(smallBoxSize);
            int[][] sodokuContainer = new int[fullBoxSize][fullBoxSize];

            System.out.println("FILE #" + fileIterator);
            while (fileReader.hasNext()) {
                input = fileReader.nextLine().split(" "); //Split the whole line by " "

                rowCounter++;

                for (int columnCounter = 1; columnCounter < input.length + 1; columnCounter++) {
                    String clause = "";
                    int variable = Integer.parseInt(input[columnCounter - 1]);

                    clause += (rowCounter * encoder * encoder + columnCounter * encoder + variable + " 0");
                    sodokuContainer[rowCounter - 1][columnCounter - 1] = variable;

                    if (variable != 0)
                        clauses.addClause(clause);
                }
            }

            //Print out the current Sodoku
            printSodoku(sodokuContainer, fullBoxSize);


            //Generate all clauses needed to solve the sudoku
            clauses.generateClauses(sodokuContainer);

            //Solve it
            Solver solver;

            try {
                solver = new Solver(sodokuContainer, encoder);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ParseFormatException e) {
                throw new RuntimeException(e);
            } catch (ContradictionException e) {
                throw new ContradictionException(e);
            }

            int[] model = {1};
            //Reverse engineer it
            if (solver.solvable()) {
                System.out.println("This is solvable, Solved output:\n");
                sodokuContainer = solver.getModel();
                printSodoku(sodokuContainer, fullBoxSize);
            } else
                System.out.println("Cannot Be Solved.");
        }
    }



    private static void printSodoku(int[][] array, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("\n");
    }
}

