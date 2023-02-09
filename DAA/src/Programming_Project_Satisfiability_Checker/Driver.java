package Programming_Project_Satisfiability_Checker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        //Take in a .txt file, (Figure out how to figure out the name of the files)
        File dir = new File("fileFolder");
        File[] files = dir.listFiles();

        Scanner fileReader = new Scanner(files[0]);   //READING IN DATA FROM fileFolder


        //Get to the header (p15) Ignore the comments
        String[] input = fileReader.nextLine().split(" "); //Split the whole line by

        System.out.println(input[0]);

        //with the p15 or s15, create an array of the number of variables of booleans (I think)


        fileReader.close();
    }
}
