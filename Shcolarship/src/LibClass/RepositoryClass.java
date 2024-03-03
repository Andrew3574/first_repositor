package LibClass;

import java.util.ArrayList;

public class RepositoryClass {
    public RepositoryClass() { }
    public void AddNewStudent(ArrayList<Student> studentsArrayList,String name, FormOfEducation education, float mark)
    {
        studentsArrayList.add(new Student(name,education,mark));
    }

    public void DeleteStudent(ArrayList<Student> studentsArrayList,int num)
    {
        studentsArrayList.remove(num - 1);
    }

    public void EditStudent(ArrayList<Student> studentsArrayList,int num,String name, FormOfEducation education, float mark)
    {
        studentsArrayList.set(num - 1, new Student(name,education,mark));
    }


}
