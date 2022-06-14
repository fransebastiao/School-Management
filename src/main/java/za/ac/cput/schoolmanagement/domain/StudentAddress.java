package za.ac.cput.schoolmanagement.domain;
/*
 School_Management
 Entity for the StudentAddress
 Author: Edvalter da Costa Jamba (220446571)
 Date: 11 June 2022
*/

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class StudentAddress {


    @Id @NotNull private String studentAddressid;
    @NotNull private String studentAddress;


    protected StudentAddress() {}

    public StudentAddress(Builder builder) {
        this.studentAddressid = builder.studentAddressid;
        this.studentAddress=builder.studentAddress;

    }


    public String getstudentAddressid() {
        return studentAddressid;
    }

    public String getstudentAddress() {
        return studentAddress;
    }

    @Override
    public String toString() {
        return "StudentAdress{" +
                "studentAdressid='" + studentAddressid + '\'' +
                ", studentAdress='" + studentAddress + '\'' +
                '}';
    }

    public static class Builder{

        private String studentAddressid;
        private String studentAddress;

        public Builder studentAddressid(String studentAdressid) {
            this.studentAddressid = studentAdressid;
            return this;
        }

        public Builder studentAddress(String studentAdress) {
            this.studentAddress = studentAdress;
            return this;
        }

        public Builder copy(StudentAddress student) {
            this.studentAddressid = student.studentAddressid;
            this.studentAddress=student.studentAddress;
            return this;
        }

        public StudentAddress build() {
            return new StudentAddress(this);
        }
    }

    @Override
    public boolean equals(Object s) {
        if(this==s )return true;
        if(s==null || getClass() != s.getClass())return false;
        StudentAddress that=(StudentAddress) s;
        return studentAddressid.equals(that.studentAddressid) && studentAddress.equals(that.studentAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentAddressid,studentAddress);
    }


    /* //my identifyer
    public static class StudentAddressIdentify
    {
        private String studentAddressid;
        private String studentAddress;

        public StudentAddressIdentify(String studentAddressid, String studentAddress) {
            this.studentAddressid = studentAddressid;
            this.studentAddress = studentAddress;
        }

        public String getStudentAddressid() {
            return studentAddressid;
        }

        public String getStudentAddress() {
            return studentAddress;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            StudentAddressIdentify that = (StudentAddressIdentify) o;
            return studentAddressid.equals(that.studentAddressid) && studentAddress.equals(that.studentAddress);
        }

        @Override
        public int hashCode() {
            return Objects.hash(studentAddressid, studentAddress);
        }
    }*/

}
