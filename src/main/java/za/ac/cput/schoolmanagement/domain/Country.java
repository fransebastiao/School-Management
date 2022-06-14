package za.ac.cput.schoolmanagement.domain;
/*
Country.java
This class implement builder pattern for Country
Siphelele Nyathi 218334028
10.06.2022
 */

public class Country {

    private String countryId;
    private String countryName;

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
                "countryId='" + countryId + '\'' +
                ", countryName='" + countryName + '\'' +
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

        public Country build(){
            return new Country(this);
        }
    }
}

