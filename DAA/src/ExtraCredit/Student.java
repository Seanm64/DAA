package ExtraCredit;

public class Student extends Person {
    int ID;

    public Student(int id, String name)
    {
        super(name);
        ID = id;
    }

    public int getID()
    {
        return ID;
    }

    public String toString()
    {
        return ("Name: " + name + "\tID: " + ID);
    }
}
