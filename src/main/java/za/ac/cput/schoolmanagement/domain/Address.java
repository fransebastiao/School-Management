package za.ac.cput.schoolmanagement.domain;

/* Project: School Management
 * Entity: Address
 * Author: Franciel Sebastiao 219466912
 * Date: 14/06/2022
 */

import java.util.Objects;

public class Address {
    private String unitNumber, complexName, streetNumber, streetName;
    private int postalCode;
    private City city;

    private Address(Builder builder) {
        this.unitNumber = builder.unitNumber;
        this.complexName = builder.complexName;
        this.streetNumber = builder.streetNumber;
        this.streetName = builder.streetName;
        this.postalCode = builder.postalCode;
        this.city = builder.city;
    }

    public String getUnitNumber() {return unitNumber;}

    public String getComplexName() {return complexName;}

    public String getStreetNumber() {return streetNumber;}

    public String getStreetName() {return streetName;}

    public int getPostalCode() {return postalCode;}

    public City getCity() {return city;}

    public static class Builder {
        private String unitNumber, complexName, streetNumber, streetName;
        private int postalCode;
        private City city;

        public Builder unitNumber(String unitNumber) {
            this.unitNumber = unitNumber;
            return this;
        }

        public Builder complexName(String complexName) {
            this.complexName = complexName;
            return this;
        }

        public Builder streetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public Builder streetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder postalCode(int postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder city(City city) {
            this.city = city;
            return this;
        }

        public Builder copy(Address address) {
            this.unitNumber = unitNumber;
            this.complexName = complexName;
            this.streetNumber = streetNumber;
            this.streetName = streetName;
            this.postalCode = postalCode;
            this.city = city;
            return this;
        }

        public Address build(){return new Address(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return postalCode == address.postalCode && Objects.equals(unitNumber, address.unitNumber)
                && Objects.equals(complexName, address.complexName) &&
                Objects.equals(streetNumber, address.streetNumber)
                && Objects.equals(streetName, address.streetName)
                && Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unitNumber, complexName, streetNumber, streetName, postalCode, city);
    }

    @Override
    public String toString() {
        return "Address{" +
                "unitNumber='" + unitNumber + '\'' +
                ", complexName='" + complexName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", postalCode=" + postalCode + '\'' +
                ", city=" + city +
                '}';
    }
}
