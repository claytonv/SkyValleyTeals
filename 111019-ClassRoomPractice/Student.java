import java.util.ArrayList;

public class Student
{
    public String firstName;
    public String lastName;
    public String birthdate;

    public ArrayList<Double> grades;

    Student()
    {
        firstName = "Jane";
        lastName = "Doe";
        birthdate = "01-017-1970";
        grades = new ArrayList<Double>();
    }

    Student(String firstName, String lastName, String birthDate)
    {
        grades = new ArrayList<Double>();
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthDate;
    }

    private double getAverageGrade()
    {
        // If size is 0, the rest of this will divide by 0
        // Which is NaN (Invalid)
        if (grades.isEmpty())
        {
            return 100.0;
        }

        double outAverage = 0.0;
        for (Double grade : grades)
        {
            outAverage += grade;
        }

        return outAverage /= (double)grades.size();
    }

    private String getLetterGrade()
    {
        double averageGrade = getAverageGrade();

        if(averageGrade >= 90.0)
            return "A";
        else if (averageGrade >= 80.0)
            return "B";
        else if (averageGrade >= 70.0)
            return "C";
        else if (averageGrade >= 60.0)
            return "D";
        
        return "F";
    }

    public void printStudentData()
    {
        double averageGrade = getAverageGrade();

        System.out.println("Student Name: " +
            lastName + " , " + firstName);

        System.out.println("Student DOB: " +
            birthdate);

        System.out.println("Student Grade Average : " + averageGrade 
        + "(" + getLetterGrade() + ")");
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setBirthDate(String birthdate)
    {
        this.birthdate = birthdate;
    }

    public void addGrade(double inGrade)
    {
        grades.add(inGrade);
    }
}