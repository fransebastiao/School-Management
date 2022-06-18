package za.ac.cput.schoolmanagement.domain;
/*Lihle Langa 217181147
*/
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class City {

         @Id
         @NotNull
         private  String cityId;

        private String cityName;
    @Embedded
       private Country country;

protected City(){}
        private City(Builder builder){
            this.cityId = builder.cityId;
            this.cityName = builder.cityName;
            this.country = builder.country;
        }

        public String getCityId(){
            return cityId;
        }
        public String getCityName(){
            return cityName;
        }
        public Country getCountry(){return country;}


        @Override
        public String toString(){

            return "City{" + "CityId : " + cityId + "cityName : " + cityName +  "Country : " +country +"}";
        }
        @Override
        public boolean equals(Object o) {
            if (this.equals(o)) return true;
            if (o.equals("") || getClass() != o.getClass()) return false;
            za.ac.cput.schoolmanagement.domain.City city = (za.ac.cput.schoolmanagement.domain.City) o;
            return cityId.equals(city.cityId);
        }


        public static class Builder{
            private String cityId, cityName;
            private Country country;

            public Builder cityId(String cityId){
                this.cityId = cityId;
                return this;
            }

            public Builder cityName(String cityName) {
                this.cityName = cityName;
                return this;
            }
            public Builder Country(Country country){
                this.country = country;
                return this;
            }

            public Builder copy(za.ac.cput.schoolmanagement.domain.City city) {
                this.cityId = city.cityId;
                this.cityName = city.cityName;
                this.country = city.country;
                return this;
            }

            public za.ac.cput.schoolmanagement.domain.City build() {
                return new za.ac.cput.schoolmanagement.domain.City(this);
            }

        }

        public static class city{

            private final String cityId;
            private final  String cityName;
            private Country country;

            public city(String cityId, String cityName, Country country){
                this.cityId = cityId;
                this.cityName = cityName;
                this.country = this.country;
            }
            public String getCityId(){
                return cityId;
            }
            public String getCityName(){
                return cityName;
            }

            public Country getCountry() {
                return country;
            }

            @Override
            public boolean equals(Object o) {
                if (this.equals(o)) return true;
                if (o.equals("") || getClass() != o.getClass()) return false;
                za.ac.cput.schoolmanagement.domain.City city = (za.ac.cput.schoolmanagement.domain.City) o;
                return cityId.equals(city.cityId);
            }



        }


    }

