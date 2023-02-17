package Programming_Project_Satisfiability_Checker;
/** SAT - Satisfiability Checker
 * @author Sean McKay
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        final long programStart = System.currentTimeMillis(); //Timing to see how long the WHOLE program took

        Formula formula = new Formula();

        //Take in a .txt file, (Figure out how to figure out the name of the files)
        File dir = new File("fileFolder");
        File[] files = dir.listFiles();

        //Create a forLoop here for the folders
        for(int filesIn = 0; filesIn < files.length; filesIn++)
        {
            Scanner fileReader = new Scanner(files[filesIn]);   //READING IN DATA FROM fileFolder


            String[] input;
            Clause clause = new Clause();
            String name = "";


            //Should make the loop for fileReader here
            //fileReader = new Scanner(files[i])

            while (fileReader.hasNext()) {
                input = fileReader.nextLine().split(" "); //Split the whole line by " "

                if (input[0].charAt(0) == 'p') {
                    name = (input[0] + " " + input[1] + " " + input[2] + " " + input[3]);
                    System.out.println("Testing: " + name + ". . .");
                    formula.setVariables(Integer.parseInt(input[2])); //Creating all the variables in a boolean array
                }

                if (input[0].charAt(0) != 'c' && input[0].charAt(0) != 'p') {
                    for (int i = 0; i < input.length; i++) {
                        if (input[i].charAt(0) == '0') //When it comes to 0, have to input the clause into the formula
                        {
                            formula.add(clause);
                            clause = new Clause();
                            break;
                        }

                        clause.addVariable(Integer.parseInt(input[i]));
                    }
                }
            } //Should have a full formula by now.
            fileReader.close();

            final long startTime = System.currentTimeMillis(); //Timing to see how long program took

            boolean satisfied = formula.testFormula();

            final long endTime = System.currentTimeMillis(); // End timer for program

            if(satisfied)
                System.out.println(name + " is: SATISFIED");
            else
                System.out.println(name + " is: UNSATISFIED");



            long seconds = (endTime - startTime) / 1000;
            if(seconds < 180)
                System.out.println("Total execution time: " + seconds + " seconds\n");
            else
                System.out.println("Total execution time: " + seconds / 60 + " minutes\n");

        }  //Ends for loop for the file loader, will start up a second file

        final long programEnd = System.currentTimeMillis(); //Timing to see how long the WHOLE program took

        long minutes = (programEnd - programStart) / 1000 / 60;

        System.out.println("This whole program took " + minutes + " minutes to execute");

    }
}
