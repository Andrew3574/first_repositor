package LibClass;

public class Student {
    private String name;

    public String GetName()
    {
        return name;
    }
    private FormOfEducation education;

    public FormOfEducation GetFormOfEducation()
    {
        return education;
    }
    private float mark;

    public float GetMark()
    {
        return mark;
    }

    public Student(){}
    public Student(String name, FormOfEducation education, float mark)
    {
        this.name = name;
        this.education = education;
        this.mark = mark;
    }
}

