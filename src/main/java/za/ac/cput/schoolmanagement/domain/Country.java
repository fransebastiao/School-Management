package za.ac.cput.schoolmanagement.domain;
/*
Country.java
This class implement builder pattern for Country
Siphelele Nyathi 218334028
10.06.2022
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Country {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull @Id private String countryId;
    @NotNull private String countryName;

    protected Country() {
    }

    public Country(Builder builder) {
        this.countryId = builder.countryId;
        this.countryName = builder.countryName;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return "Country{" +
                " ID ='" + countryId + '\'' +
                ", Name ='" + countryName + '\'' +
                '}';
    }

    public static class Builder{

        private String countryId;
        private String countryName;


        public Builder setCountryId(String countryId) {
            this.countryId = countryId;
            return this;
        }

        public Builder setCountryName(String countryName) {
            this.countryName = countryName;
            return this;
        }

        public Builder copy(Country country){
            this.countryId = country.countryId;
            this.countryName = country.countryName;
            return this;
        }

        public Country build(){
            return new Country(this);
        }
    }
}

