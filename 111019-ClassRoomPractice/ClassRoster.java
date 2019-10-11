import java.util.ArrayList;

public class ClassRoster
{
    public ArrayList<Student> students;

    public ClassRoster()
    {
        students = new ArrayList<Student>();
    }

    public void deleteStudent(Student studentToDelete)
    {
        for (Student student : students)
        {
            if (student.equals(studentToDelete))
            {
                students.remove(studentToDelete);
            }
        }
    }

    public void addStudent(Student newStudent)
    {
        students.add(newStudent);
    }

    public void addStudent(String firstName, String lastName, String birthDate)
    {
        Student newStudent = new Student(firstName, lastName, birthDate);
        addStudent(newStudent);
    }

    public Student getStudentByFirstName(String firstName)
    {
        for (Student student : students)
        {
            if (student.firstName.equalsIgnoreCase(firstName))
                return student;
        }

        return null;
    }

    public Student getStudentByLastName(String lastName) 
    {       
        for (Student student : students)
        {
            if (student.lastName.equalsIgnoreCase(lastName))
                return student;
        }

        return null;
    }

    public Student getStudentByFullName(String lastName, String firstName)
    {
        for (Student student : students)
        {
            if (student.lastName.equalsIgnoreCase(lastName)
            && student.firstName.equalsIgnoreCase(firstName))
            {
                return student;
            }         
        }
        
        return null;
    }

    public void printAll(boolean withBreaks)
    {
        for (Student student : students)
        {
            student.printStudentData();

            if (withBreaks == true
                && students.size() > 1)
            {
                System.out.println();
            }
        }
    }

}