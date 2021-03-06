package by.academy.it.pojos;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Created by Dmitry on 11/4/2016.
 */
public class Emploeer extends Person {
    private String company;
    private Double salary;

    public Emploeer() {
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + " Company =" + getCompany() + " Salary = " + getSalary();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Emploeer emploeer = (Emploeer) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(company, emploeer.company)
                .append(salary, emploeer.salary)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(company)
                .append(salary)
                .toHashCode();
    }
}
