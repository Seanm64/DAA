package Programming_Project_Satisfiability_Checker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        List<Clause> clauseList = new LinkedList<>(); // The overarching structure is a LinkedList of clauses, if one clause is false
                                                          //then it's not a viable solution


        //Take in a .txt file, (Figure out how to figure out the name of the files)
        File dir = new File("fileFolder");
        File[] files = dir.listFiles();
        Scanner fileReader = new Scanner(files[0]);   //READING IN DATA FROM fileFolder

        //Need a for loop to loop through the folder of files!

        String[] input;
        while(fileReader.hasNext())
        {
            Clause clause = new Clause();
            input = fileReader.nextLine().split(" "); //Split the whole line by " "
            if(input[0] != "c" || input[0] != "p")
            {
                for(int i = 0; i < input.length; i++)
                {
                    if(input[i] == "0")
                        break;

                    clause.addVariable(Integer.parseInt(input[i]));
                }
            }
            input = fileReader.nextLine().split(" "); //Move onto the next line
        }

        //with the p15 or s15, create an array of the number of variables of booleans (I think)


        fileReader.close();
    }
}
