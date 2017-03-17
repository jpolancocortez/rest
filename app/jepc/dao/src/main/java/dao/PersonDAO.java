package dao;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import model.Person;

/**
 * 
 * @author jpolanco
 */
public interface PersonDAO {

    /**
     * @param p instance of Person to persist
     * @throws NullEntityException if the instance of person is null
     */
    void save(Person p);
    
    /**
     * 
     * @param p instance of Person to update
     * @return the instance of Person updated
     */
    void update(Person person) throws IllegalAccessException, InvocationTargetException;
    
    /**
     * @param id the Primary Key of instance Person
     * @return the instance with the primary key was searched
     */
    Person findById(Integer id);
    
    /**
     * @param id the Primary Key of instance Person
     * @return the instance with the primary key that was searched
     */
    Person getPersonInformation(Integer id);   
    
    /**
     * @return all instances of Person
     */
    List<Person> getPeople();            

}