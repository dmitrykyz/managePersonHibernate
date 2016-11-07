package by.academy.it.pojos;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Created by Dmitry on 11/7/2016.
 */
public class RegularWorker extends Worker {
    private Double salary;
    private Integer bonus;

    public RegularWorker() {
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        RegularWorker that = (RegularWorker) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(salary, that.salary)
                .append(bonus, that.bonus)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(salary)
                .append(bonus)
                .toHashCode();
    }
}
