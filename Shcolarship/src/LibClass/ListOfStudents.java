package LibClass;

import java.util.ArrayList;

public class ListOfStudents extends Student
{
    private ArrayList<Student> studentsArrayList;

    public ListOfStudents(ArrayList<Student> StudentsArrayList)
    {
        studentsArrayList = new ArrayList<Student>();

        for(Student students : StudentsArrayList)
        {
            studentsArrayList.add(new Student(students.GetName(),
                    students.GetFormOfEducation(), students.GetMark()));
        }
    }
    public void GetStudentsList()
    {
        System.out.println("Список студентов:");
        for(Student student : studentsArrayList)
        {
            System.out.printf("%s %s %.1f\n",student.GetName(),student.GetFormOfEducation().toString(),
                    student.GetMark());
        }
    }
   public void GetInfoOfScholarship()
    {
        float scholarShip = 109.2F;
        for(Student students : studentsArrayList)
        {
            if(students.GetFormOfEducation() == FormOfEducation.Budget)
            {
                switch ((int) students.GetMark())
                {
                    case 1:
                    case 2:
                    case 3:
                        System.out.printf("Студент %s не получает" +
                                " стипендию.\n", students.GetName());
                        break;
                    case 4:
                    case 5:
                        System.out.printf("Студент %s получает" +
                                " минимальную стипендию: %f\n", students.GetName(), scholarShip);
                        break;
                    case 6:
                    case 7:
                        scholarShip = scholarShip + scholarShip * 25 / 100;
                        System.out.printf("Студент %s получает" +
                                " первую повышенную стипендию: %f\n", students.GetName(), scholarShip);
                        break;
                    case 8:
                    case 9:
                    case 10:
                        scholarShip = scholarShip + scholarShip * 50 / 100;
                        System.out.printf("Студент %s получает" +
                                " вторую повышенную стипендию: %f\n", students.GetName(), scholarShip);
                        break;
                    default:
                        return;
                }
            }
            else
            {
                System.out.printf("Студент %s не получает" +
                        " стипендию.\n", students.GetName());
            }
        }
    }

    public void GetInfoPaidStudents()
    {
        for(Student students : studentsArrayList)
        {
            if(students.GetFormOfEducation() == FormOfEducation.Paid)
            {
                System.out.printf("Студент %s обучается" +
                        " на платной основе\n", students.GetName());
            }
        }
    }

    public void GetAverageSessionMark()
    {
        int index = 0;
        float averageMark = 0;
        for(Student students : studentsArrayList)
        {
            index++;
            averageMark += students.GetMark();
        }
        System.out.printf("Средняя оценка за прошедшую" +
                " сессию: %.1f\n",averageMark = averageMark / index);
    }
}
