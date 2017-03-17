package dao.impl;

import dao.PersonDAO;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Person;
import org.apache.commons.beanutils.BeanUtils;

/**
 * 
 * @author jpolanco
 */

@Default
@RequestScoped
public class PersonDAOImpl implements PersonDAO, Serializable {

    @PersistenceContext(unitName = "project-PU")
    protected EntityManager em;

    @Override
    public void save(Person person) {       
        if (person.getId() == null) {
            person.setId(0);
        }
        
        try {
            em.persist(person);
        } catch (Exception e) {
            throw e;
        }        
    }
    
    @Override
    public void update(Person person) throws IllegalAccessException, InvocationTargetException {
        Person p = null;        
        try {
            p = em.find(Person.class, person.getId());
            BeanUtils.copyProperties(p, person);
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public Person findById(Integer id) {
        Person person = null;

        try {
            person = em.find(Person.class, id);
        } catch (Exception e)  {
            e.printStackTrace();
        }

        return person;
    }            

    @Override
    public Person getPersonInformation(Integer id) {        
        return findById(id);
    }    

    @Override
    public List<Person> getPeople() {        
        return em.createQuery("select p from Person p").getResultList();
    }        

}