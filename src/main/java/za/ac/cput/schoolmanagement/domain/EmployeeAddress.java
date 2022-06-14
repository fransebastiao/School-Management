/* Entity: EMPLOYEEADDRESS
*  DDD Pattern
* SCHOOL-MANAGEMENT
*Author: TSHEPANG MOLEFE 216217717
*  Date: 12-06-2022
*/

package za.ac.cput.schoolmanagement.domain;

import java.util.Objects;

public class EmployeeAddress
{
    private final String staffId;
    private  final Address address;

    private EmployeeAddress(Builder builder)
    {
        this.staffId = builder.staffId;
        this.address = builder.address;

    }

    public String getStaffId()
    {
        return staffId;
    }

    public Address getAddress()
    {
        return address;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeAddress that = (EmployeeAddress)o;
        return staffId.equals(that.staffId);
    }
    @Override
    public int hashCode() {
        return Objects.hash(staffId);
    }

    @Override
    public String toString() {
        return "Builder{" +
                "staffId='" + staffId + '\'' +
                ", address=" + address +
                '}';
    }

    public static class Builder {
        private String staffId;
        private Address address;

        public Builder staffId(String staffId) {
            this.staffId = staffId;
            return this;
        }

        public Builder address(Address address) {
            this.address = address;
            return this;
        }


        public Builder copy(EmployeeAddress employeeAddress) {
            this.staffId = employeeAddress.staffId;
            this.address = employeeAddress.address;
            return this;
        }

        public EmployeeAddress build()
        {
            return new EmployeeAddress(this);
        }

    }
}

