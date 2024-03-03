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

        RepositoryClass repositoryClass = new RepositoryClass();
        int n = -1;
        while (n != 0)
        {
            System.out.print("Меню:\n" +
                    "1.Добавить студента\n" +
                    "2.Удалить студента по номеру\n" +
                    "3.Редактировать студента по номеру\n" +
                    "0 - Выход\n");
            n = in.nextInt();
            switch (n)
            {
                case 1:
                    System.out.print("Введите имя:");
                    String name = in.next();
                    System.out.print("Введите образование (Budget/Paid):");
                    String edu = in.next().toLowerCase();
                    FormOfEducation education;
                    switch (edu)
                    {
                        case "budget":
                            education = FormOfEducation.Budget;
                            break;
                        default:
                            education = FormOfEducation.Paid;
                            break;
                    }
                    System.out.print("Введите оценку:");
                    float mark = in.nextFloat();
                    repositoryClass.AddNewStudent(students,name,education,mark);
                break;

                case 2:
                    System.out.println("Введите номер:");
                    int num = in.nextInt();
                    repositoryClass.DeleteStudent(students,num);
                break;

                case 3:
                    System.out.println("Введите номер:");
                    num = in.nextInt();
                    System.out.print("Введите имя:");
                    name = in.next();
                    System.out.print("Введите образование (Budget/Paid):");
                    edu = in.next().toLowerCase();
                    switch (edu)
                    {
                        case "budget":
                            education = FormOfEducation.Budget;
                            break;
                        default:
                            education = FormOfEducation.Paid;
                            break;
                    }
                    System.out.print("Введите оценку:");
                    mark = in.nextFloat();
                    repositoryClass.EditStudent(students,num,name,education,mark);
                break;

                default:
                    break;
            }
        }
        listOfStudents = new ListOfStudents(students);

        listOfStudents.GetStudentsList();
        listOfStudents.GetAverageSessionMark();
        listOfStudents.GetInfoOfScholarship();
        listOfStudents.GetInfoPaidStudents();
    }
}
