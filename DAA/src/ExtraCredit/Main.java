package ExtraCredit;
import java.io.File;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            FileWriter out = new FileWriter("output.txt");

            //Read in files
            File linked = new File("linked.txt");
            File hash = new File("hash.txt");
            Scanner linkedReader = new Scanner(linked);
            Scanner hashReader = new Scanner(hash);


            //Create hashMap and LinkedList
            List<Integer> IDs = new LinkedList<>();
            HashMap<Integer, Student>  studentList = new HashMap<>();

            //Input information into the lists
            inputIDs(IDs, linkedReader);
            inputStudents(IDs, studentList, hashReader);

            //Output into Output.txt
            writeToFile(out, studentList, IDs);


            //Close readers
            linkedReader.close();
            hashReader.close();
            out.close();
        }
        catch(FileNotFoundException fnfe)
        {
            System.out.println("File(s) not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeToFile(FileWriter out, HashMap<Integer, Student> studentList, List<Integer> IDs) throws IOException {
        out.write("Students: \tIDs\n");

        for(int i = 0; i < studentList.size(); i++)
        {
            out.write(studentList.get(IDs.get(i)).getName() + " = " + IDs.get(i) + "\n");
        }
    }

    private static void inputStudents(List<Integer> IDs, HashMap<Integer, Student> studentList, Scanner hashReader) {
        int n = 0;
        while(hashReader.hasNext())
        {
            studentList.put(IDs.get(n), new Student(IDs.get(n),hashReader.next()));
            n++;
        }
    }

    static private void inputIDs(List<Integer> linkedList, Scanner linkedReader) {
        while(linkedReader.hasNext())
        {
            linkedList.add(linkedReader.nextInt());
        }
    }

}