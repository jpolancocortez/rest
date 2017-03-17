package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.codehaus.jackson.annotate.JsonManagedReference;

/**
 *
 * @author jpolanco
 */
@Entity
@Table(name = "Country")
public class Country implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "name")
    private String name;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Country_dbid")
    @JsonManagedReference
    List<State> states;

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
    
    public List<State> getStates(){
        return states;
    }
    
    public void setStates(List<State> states) {
        this.states = states;
    }
    
    public boolean addState(State state) {
        if (states == null) {
            states = new ArrayList<>();
        }
        states.add(state);
        return true;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(3, 27).
                    append(name).
                    toHashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (!(obj instanceof Country)) {
            return result;
        }
        Country c = (Country) obj;
                
        return new EqualsBuilder().
                    append(name, c.getName()).
                    isEquals();
    }

    @Override
    public String toString() {
        return this.name + " - " + this.states;
    }

}