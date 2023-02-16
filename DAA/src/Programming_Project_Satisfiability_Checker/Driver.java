package Programming_Project_Satisfiability_Checker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        Formula formula = new Formula();

        //Take in a .txt file, (Figure out how to figure out the name of the files)
        File dir = new File("fileFolder");
        File[] files = dir.listFiles();

        //Create a forLoop here for the folders
        Scanner fileReader = new Scanner(files[0]);   //READING IN DATA FROM fileFolder

        String[] input;
        Clause clause = new Clause();
        String name = "";


        //Should make the loop for fileReader here
        //fileReader = new Scanner(files[i])

        while (fileReader.hasNext()) {
            input = fileReader.nextLine().split(" "); //Split the whole line by " "

            if (input[0].charAt(0) == 'p') {
                name = (input[0] + " " + input[1] + " " + input[2] + " " + input[3]);
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

        boolean satisfied = formula.testFormula();

        if(satisfied)
            System.out.println(name + " is: SATISFIED");
        else
            System.out.println(name + " is: UNSATISFIED");

    //}  //Ends for loop for the 1 file, will start up second file
    }
}
