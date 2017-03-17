package model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.codehaus.jackson.annotate.JsonBackReference;

/**
 *
 * @author jpolanco
 */
@Entity
@Table(name = "State")
public class State implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "name")
    private String name;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Country_dbid")
    @JsonBackReference
    private Country country;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
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
     * @return the country
     */
    public Country getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(Country country) {
        this.country = country;
    }
    
        @Override
    public int hashCode() {
        return new HashCodeBuilder(103, 105).
                    append(name).
                    toHashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (!(obj instanceof State)) {
            return result;
        }
        State s = (State) obj;
                
        return new EqualsBuilder().
                    append(name, s.getName()).
                    isEquals();
    }
    
    @Override
    public String toString() {
        return this.country.getName() + " - " + name;
    }
}