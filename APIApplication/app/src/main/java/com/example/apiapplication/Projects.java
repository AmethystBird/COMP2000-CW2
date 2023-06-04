package com.example.apiapplication;

public class Projects {
    private int studentID;
    private String title;
    private String description;
    private int year;
    private String nameFirst;
    private String nameLast;

    /*public static void main(String[] args)
    {

    }*/

    //Maps data to object structure
    public void MapData(int studentID, String title, String description, int year, String nameFirst, String nameLast)
    {
        this.studentID = studentID;
        this.title = title;
        this.description = description;
        this.year = year;
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
    }

    public String GetStudentIDAsStr()
    {
        return Integer.toString(studentID);
    }
    public void SetStudentIDFromStr(String studentIDNew) { studentID = Integer.parseInt(studentIDNew); }

    public String GetTitle()
    {
        return title;
    }
    public void SetTitle(String titleNew) { title = titleNew; }

    public String GetDescription()
    {
        return description;
    }
    public void SetDescription(String descriptionNew) { description = descriptionNew; }

    public String GetYearAsStr() { return Integer.toString(year); }
    public void SetYearFromStr(String yearNew)
    {
        year = Integer.parseInt(yearNew);
    }

    public String GetNameFirst()
    {
        return nameFirst;
    }
    public void SetNameFirst(String nameFirstNew)
    {
        nameFirst = nameFirstNew;
    }

    public String GetNameLast()
    {
        return nameLast;
    }
    public void SetNameLast(String nameLastNew)
    {
        nameLast = nameLastNew;
    }
}
