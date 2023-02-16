package Programming_Project_Satisfiability_Checker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        Formula formula = new Formula();

        //Take in a .txt file, (Figure out how to figure out the name of the files)
        File dir = new File("fileFolder");
        File[] files = dir.listFiles();
        Scanner fileReader = new Scanner(files[0]);   //READING IN DATA FROM fileFolder

        //Need a for loop to loop through the folder of files!

        String[] input;
        Clause clause = new Clause();

        //Should make the loop for fileReader here
        //fileReader = new Scanner(files[i])

        while (fileReader.hasNext()) {
            input = fileReader.nextLine().split(" "); //Split the whole line by " "
            String name;

            if (input[0].charAt(0) == 'p') {
                name = (input[0] + " " + input[1] + " " + input[2] + " " + input[3]);
                System.out.println("This is " + name);
                formula.setVariables(Integer.parseInt(input[2])); //Creating all of the variables in a boolean array
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
        }

        //with the p15 or s15, create an array of the number of variables of booleans (I think)


        fileReader.close();
    }
}
