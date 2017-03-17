/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 *
 * @author jpolanco
 */
@Entity(name = "Hero")
@XmlRootElement
public class Hero implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    public Hero() {
    }

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

    @Override
    public int hashCode() {
        return new HashCodeBuilder(11, 217).
                    append(name).
                    toHashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (!(obj instanceof Hero)) {
            return result;
        }
        if (this == obj) {
            result = true;
        }
        
        Hero hero = (Hero) obj;
        
        result = new EqualsBuilder().
                        append(this.name, hero.getName()).
                        isEquals();
        
        return result;
    }
    
    @Override
    public String toString() {
        return "id " + this.id + " name " + this.name;
    }
}