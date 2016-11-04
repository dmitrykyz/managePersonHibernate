package by.academy.it.pojos;

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

    //        @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Emploeer)) return false;
//
//        Emploeer emploeer = (Emploeer) o;
//
//        if (company != null ? !company.equals(emploeer.company) : emploeer.company != null) return false;
//        if (salary != null ? !salary.equals(emploeer.salary) : emploeer.salary != null) return false;
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//
//        result = 31 * result + (age != null ? age.hashCode() : 0);
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        result = 31 * result + (surname != null ? surname.hashCode() : 0);
//        return result;
//    }
}
