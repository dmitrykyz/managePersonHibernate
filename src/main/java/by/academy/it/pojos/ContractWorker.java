package by.academy.it.pojos;


/**
 * Created by Dmitry on 11/7/2016.
 */
public class ContractWorker extends Worker{
    private Double ratePerHour;
    private String contractDuration;

    public ContractWorker() {
    }

    public Double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(Double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    public String getContractDuration() {
        return contractDuration;
    }

    public void setContractDuration(String contractDuration) {
        this.contractDuration = contractDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ContractWorker that = (ContractWorker) o;

        return new org.apache.commons.lang.builder.EqualsBuilder()
                .append(ratePerHour, that.ratePerHour)
                .append(contractDuration, that.contractDuration)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang.builder.HashCodeBuilder(17, 37)
                .append(ratePerHour)
                .append(contractDuration)
                .toHashCode();
    }
}
