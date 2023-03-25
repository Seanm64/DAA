package Sodoku;
/** Sodoku - Transform and Conquer algorithm
 * @author Sean McKay
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File dir = new File("sodokuInputs");
        File[] files = dir.listFiles();
        Scanner fileReader = new Scanner(files[0]);   //READING IN DATA FROM sodokuInputs
        ISolver solver = SolverFactory.newDefault();

        int boxLength, boxWidth;
        int rowCounter = 0;
        int[] clause = {0, 0, 0};
        List clauseList = new ArrayList<>(); //May not need this, can just submit everything into the Sat4j I think
        String[] input;

        boxLength = Integer.parseInt(fileReader.nextLine());
        boxWidth = Integer.parseInt(fileReader.nextLine());

        while (fileReader.hasNext()) {
            input = fileReader.nextLine().split(" "); //Split the whole line by " "

            rowCounter++;
            for(int columnCounter = 0; columnCounter < input.length; columnCounter++)
            {
                clause[0] = rowCounter;
                clause[1] = columnCounter;
                clause[2] = Integer.parseInt(input[columnCounter]);

                if(clause[2] != 0)
                {
//                    clauseList.add(clause);
                    System.out.println(clause[0] + " " + clause[1] + " " + clause[2]) ;
//                    System.out.println(clauseList.get(columnCounter));
                }
            }
        }
    }

}
