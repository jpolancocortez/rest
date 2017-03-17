package dao.impl;

import dao.CountryDAO;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Country;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author jpolanco
 */

@RequestScoped
public class CountryDAOImpl implements CountryDAO, Serializable {
    
    @PersistenceContext(unitName = "project-PU")
    protected EntityManager em;

    @Override
    public void save(Country country) {      
        try {
            em.persist(country);
        } catch (Exception e) {
            throw e;
        }        
    }
    
    @Override
    public void update(Country country) {
        Country c = null;        
        try {
            c = em.find(Country.class, country.getId());
            c.setName(country.getName());
            em.merge(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public Country findById(Integer id) {
        Country country = null;

        try {
            country = em.find(Country.class, id);
        } catch (Exception e)  {
            e.printStackTrace();
        }

        return country;
    }

    @Override
    public List<Country> getAllCountries() {
        List<Country> list = Collections.EMPTY_LIST;
        try {
            list = em.createQuery("SELECT c FROM Country c").getResultList();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public void delete(Country country) {
        em.remove(country);
    }

}