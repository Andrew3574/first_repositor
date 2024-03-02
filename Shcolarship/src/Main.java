import LibClass.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ListOfStudents listOfStudents = null;
        ArrayList<Student> students = new ArrayList<Student>();
        Scanner in = new Scanner(System.in);

        System.out.print("Введите количество студентов: ");
        float numberOfStudents = in.nextFloat();

        for(int i = 0; i < numberOfStudents; i++)
        {
            System.out.print("Введите имя студента: ");
            String name = in.next();
            System.out.print("Введите форму обучения" +
                    " студента(Budget/Paid): ");
            String formEducation = in.next();

            FormOfEducation formOfEducation;
            switch (formEducation)
            {
                case ("Budget"):
                    formOfEducation = FormOfEducation.Budget;
                    break;

                case ("Paid"):
                    formOfEducation = FormOfEducation.Paid;
                    break;

                default:
                    return;
            }
            System.out.print("Введите оценку по итогам" +
                    " сессии студента: ");
            int mark = in.nextInt();
//
            students.add(new Student(name, formOfEducation, mark));
        }

        listOfStudents = new ListOfStudents(students);

        listOfStudents.GetStudentsList();
        listOfStudents.GetAverageSessionMark();
        listOfStudents.GetInfoOfScholarship();
        listOfStudents.GetInfoPaidStudents();
    }
}
