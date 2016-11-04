package by.academy.it.pojos;

/**
 * Created by Dmitry on 11/4/2016.
 */
public class Student extends Person {
    private String faculty;
    private Double mark;

    public Student() {
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return super.toString() + " Faculty = " + getFaculty() + " Mark = " + getMark();
    }
}
