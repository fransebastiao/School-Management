package za.ac.cput.schoolmanagement.domain;
/*
 School_Management
 Entity for the Student
 Author: Edvalter da Costa Jamba (220446571)
 Date: 11 June 2022
*/

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Student
{

    //@Id
    //@Column(name = "Student" )
    // @OneToOne()

    @NotNull @Id private  String studentid;
    @NotNull private  String studentemail,studentname;

    protected Student(){}

    public Student(Builder builder)
    {
        this.studentid = builder.studentid;
        this.studentemail=builder.studentemail;
        this.studentname = builder.studentname;
    }

    public String getStudentid() {
        return studentid;
    }

    public String getStudentemail() {
        return studentemail;
    }

    public String getStudentname() {
        return studentname;
    }

    public static class Builder{

        private String studentid,studentemail;
        private String studentname;

        public Builder studentid(String studentid) {
            this.studentid = studentid;
            return this;
        }

        public Builder studentemail(String studentemail) {
            this.studentemail = studentemail;
            return this;
        }

        public Builder studentname(String studentname) {
            this.studentname = studentname;
            return this;
        }

        public Builder copy(Student student) {
            this.studentid = student.studentid;
            this.studentemail=student.studentemail;
            this.studentname = student.studentname;

            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentid='" + studentid + '\'' +
                ", studentemail='" + studentemail + '\'' +
                ", studentname='" + studentname + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object s) {
        if(this==s )return true;
        if(s==null || getClass() != s.getClass())return false;
        Student that=(Student) s;
        return studentid.equals(that.studentid) && studentemail.equals(that.studentemail)
                && studentname.equals(that.studentname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentid, studentemail, studentname);
    }


}

