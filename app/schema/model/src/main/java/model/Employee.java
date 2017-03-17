package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 *
 * @author jpolanco
 */
@Entity
@Table(name = "Employee")
@DiscriminatorValue(value = "3")
public class Employee extends Person {
    
    @Temporal(TemporalType.DATE)
    @Column(name = "hireDate")
    private Date hireDate;
    
    @Column(name = "code")
    private String code;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "departmentId")
    private Department department;

    /**
     * @return the hireDate
     */
    public Date getHireDate() {
        return hireDate;
    }

    /**
     * @param hireDate the hireDate to set
     */
    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the department
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * It implemented with apache commons lang
     * @return an integer generated
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder(7, 161).
                    appendSuper(super.hashCode()).
                    append(code).
                    toHashCode();
    }
    
    /**
     * It implemented with apache commons lang
     * @param obj is the object to equals with this
     * @return if the obj is equals with this
     */
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (!(obj instanceof Employee)) {
            return result;
        }
        Employee e = (Employee) obj;
                
        return new EqualsBuilder().
                    appendSuper(super.equals(obj)).
                    append(code, e.getCode()).
                    isEquals();
    }
    
    /**
     * @return a representation of Employee
     */
    @Override
    public String toString() {
        return super.toString() + " " + code + " " + department.toString();
    }

}