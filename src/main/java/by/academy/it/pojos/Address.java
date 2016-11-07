package by.academy.it.pojos;

import java.io.Serializable;

/**
 * Created by Dmitry on 11/4/2016.
 */
public class Address implements Serializable {
    private static final long serialVersinUID = 3L;
    private String street;
    private String city;
    private String zipCode;

    public Address() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
