package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 *
 * @author jpolanco
 */
@Entity
@Table(name = "Department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")    
    private Integer id;
    
    @Column(name = "name")
    private String name;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
       /**
     * It implemented with apache commons lang
     * @return an integer generated
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder(9, 117).
                    append(name).
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
        if (!(obj instanceof Department)) {
            return result;
        }
        Department d = (Department) obj;
                
        return new EqualsBuilder().
                    append(name, d.getName()).
                    isEquals();
    }
    
    /**
     * @return a representation of Person
     */
    @Override
    public String toString() {
        return name;
    }

}