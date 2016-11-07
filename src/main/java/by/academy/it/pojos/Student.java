package by.academy.it.pojos;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

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
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(faculty, student.faculty)
                .append(mark, student.mark)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(faculty)
                .append(mark)
                .toHashCode();
    }

    @Override
    public String toString() {
        return super.toString() + " Faculty = " + getFaculty() + " Mark = " + getMark();
    }
}
