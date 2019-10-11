import java.util.Scanner;
import java.io.IOException;

public class ClassRoomExample
{
    public static Scanner inputScanner;
    public static ClassRoster classRoom;

    // We haven't covered this... but you can use it wholesale
    public static void clearConsole() 
    {
        try
        {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch(IOException e)
        {

        }
        catch(InterruptedException e)
        {

        }
    }

    // A quick helper for "Press Any Key To Continue"
    public static void waitForInput()
    {
        System.out.println("Press Any Key To Continue");
        while (!inputScanner.hasNextLine());
    }

    static void printStudents()
    {
        clearConsole();
        classRoom.printAll(true);
        waitForInput();
    }

    static void showUpdateMenu()
    {
        clearConsole();

        System.out.println("What would you like to do?");
        System.out.println("F -  Update First Name");
        System.out.println("L -  Update Last Name");
        System.out.println("A -  Add Grade");
        System.out.println("B -  Update Birthdate");
    }

    static void updateStudent()
    {
        System.out.println("Enter Student Name: ");
        String studentName = inputScanner.nextLine();

        Student student = classRoom.getStudentByFirstName(studentName);
        if (student == null)
        {
            student = classRoom.getStudentByLastName(studentName);
        }

        if (student == null)
        {
            System.out.println("Student not found");
            return;
        }

        showUpdateMenu();

        String inputString = inputScanner.nextLine();

        System.out.println("Enter the data");
        if (inputString.equalsIgnoreCase("F"))
            student.setFirstName(inputScanner.nextLine());
            
        if (inputString.equalsIgnoreCase("A"))
            student.addGrade(inputScanner.nextDouble());

        if (inputString.equalsIgnoreCase("B"))
            student.setBirthDate(inputScanner.nextLine());

        if (inputString.equalsIgnoreCase("L"))
            student.setLastName(inputScanner.nextLine());

        student.printStudentData();

        waitForInput();
    }

    static void showMainMenu()
    {
        clearConsole();
        System.out.println("What would you like to do?");
        System.out.println("U -  Update Student");
        System.out.println("A -  Add Student");
        System.out.println("D -  Delete Student");
        System.out.println("P -  Print All Students");
        System.out.println("X -  Exit");
    }

    static void deleteStudent()
    {
        System.out.println("Input a student name:");
        String studentName = inputScanner.nextLine();

        Student student = classRoom.getStudentByLastName(studentName);
        if (student == null)
        {
            student = classRoom.getStudentByFirstName(studentName);
        }

        if (student != null)
        {
            classRoom.deleteStudent(student);
        }

        printStudents();
    }

    static void addStudent()
    {
        clearConsole();

        System.out.println("Input Student Last Name");
        String lastName = inputScanner.nextLine();

        System.out.println("Input Student First Name");
        String firstName = inputScanner.nextLine();

        System.out.println("Input Student Brithdate");
        String birthDate = inputScanner.nextLine();

        classRoom.addStudent(firstName, lastName, birthDate);

        printStudents();
    }

    public static void main(String[] args)
    {
        inputScanner = new Scanner(System.in);
        classRoom = new ClassRoster();

        while(true)
        {
            showMainMenu();

            String inputString = inputScanner.nextLine();

            if (inputString.equalsIgnoreCase("X"))
                break;
            else if (inputString.equalsIgnoreCase("A"))
                addStudent();
            else if (inputString.equalsIgnoreCase("U"))
                updateStudent();
            else if (inputString.equalsIgnoreCase("A"))
                deleteStudent();
            else if (inputString.equalsIgnoreCase("P"))
                printStudents();
        }

        inputScanner.close();
    }
}