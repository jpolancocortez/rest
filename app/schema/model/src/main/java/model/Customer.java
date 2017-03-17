package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/** 
 * 
 * @author jpolanco
 */
@Entity
@Table(name = "Customer")
@DiscriminatorValue(value = "2")
public class Customer extends Person {

    @Column(name = "nit")
    private String nit;
    
    @Column(name = "membership")
    private String membership;
    
    public Customer() {
    }

    /**
     * @return the nit
     */
    public String getNit() {
        return nit;
    }

    /**
     * @param nit the nit to set
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * @return the membership
     */
    public String getMembership() {
        return membership;
    }

    /**
     * @param membership the membership to set
     */
    public void setMembership(String membership) {
        this.membership = membership;
    }
 
    /**
     * It implemented with apache commons lang
     * @return an integer generated
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder(5, 55).
                    appendSuper(super.hashCode()).
                    append(nit).
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
        if (!(obj instanceof Customer)) {
            return result;
        }
        Customer c = (Customer) obj;
                
        return new EqualsBuilder().
                    appendSuper(super.equals(obj)).
                    append(nit, c.getNit()).
                    isEquals();
    }
    
    /**
     * @return a representation of Customer
     */
    @Override
    public String toString() {
        return super.toString() + " " + nit;
    }

}