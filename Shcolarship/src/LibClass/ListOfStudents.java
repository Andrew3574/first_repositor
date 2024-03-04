package LibClass;

import java.util.ArrayList;

public class ListOfStudents extends Student
{
    private  final ArrayList<Student> studentsArrayList;

    public ListOfStudents(ArrayList<Student> StudentsArrayList)
    {
        studentsArrayList = new ArrayList<Student>();

        for(Student students : StudentsArrayList)
        {
            studentsArrayList.add(new Student(students.GetName(),
                    students.GetFormOfEducation(), students.GetMark()));
        }
    }
    public String GetStudentsList()
    {
        StringBuilder result = new StringBuilder("Список студентов:\n");
        for(Student student : studentsArrayList)
        {
            String format = String.format("%s %s %.1f\n", student.GetName(), student.GetFormOfEducation().toString(),
                    student.GetMark());

            result.append(format);
        }
        return result.toString();
    }
   public String GetInfoOfScholarship()
    {
        float scholarShip = 109.2F;
        StringBuilder result = new StringBuilder();
        for(Student students : studentsArrayList)
        {
            if(students.GetFormOfEducation() == FormOfEducation.Budget)
            {
                switch ((int) students.GetMark())
                {
                    case 1:
                    case 2:
                    case 3:
                        result.append(String.format("Студент %s не получает" +
                                " стипендию.\n", students.GetName()));
                        break;
                    case 4:
                    case 5:
                        result.append(String.format("Студент %s получает" +
                                " минимальную стипендию: %f\n", students.GetName(), scholarShip));
                        break;
                    case 6:
                    case 7:
                        scholarShip = scholarShip + scholarShip * 25 / 100;
                        result.append(String.format("Студент %s получает" +
                                " первую повышенную стипендию: %f\n", students.GetName(), scholarShip));
                        break;
                    case 8:
                    case 9:
                    case 10:
                        scholarShip = scholarShip + scholarShip * 50 / 100;
                        result.append(String.format("Студент %s получает" +
                                " вторую повышенную стипендию: %f\n", students.GetName(), scholarShip));
                        break;
                    default:
                        result.append(String.format("Студент %s не получает" +
                                " стипендию.\n", students.GetName()));
                        break;
                }
            }
            else
            {
                result.append(String.format("Студент %s не получает" +
                        " стипендию.\n", students.GetName()));
            }
        }
        return result.toString();
    }

    public String GetInfoPaidStudents()
    {
        StringBuilder result = new StringBuilder();
        for(Student students : studentsArrayList)
        {
            if(students.GetFormOfEducation() == FormOfEducation.Paid)
            {
                result.append(String.format("Студент %s обучается" +
                        " на платной основе\n", students.GetName()));
            }
        }
        return result.toString();
    }

    public String GetAverageSessionMark()
    {
        int index = 0;
        float averageMark = 0;
        for(Student students : studentsArrayList)
        {
            index++;
            averageMark += students.GetMark();
        }
        return String.format("Средняя оценка за сессию: %.1f \n", averageMark / index);

    }
}
