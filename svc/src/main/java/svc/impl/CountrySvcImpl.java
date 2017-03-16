package svc.impl;

import dao.CountryDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import model.Country;
import svc.CountrySvc;

/**
 *
 * @author jpolanco
 */
@Stateless
public class CountrySvcImpl implements CountrySvc {

    private @Inject CountryDAO dao;

    @Override
    public void save(Country country) {
        try {
            dao.save(country);
        } catch (Exception e) {
            throw e;
        }        
    }
    
    @Override
    public void update(Country country) {        
        try {
            dao.update(country);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    @Override
    public Country findById(Integer id) {
        Country country = null;
        try {
            country = dao.findById(id);
        } catch (Exception e)  {
            e.printStackTrace();
        }

        return country;
    }

    @Override
    public List<Country> getAllCountries() {        
        return dao.getAllCountries();
    }

    @Override
    public void delete(Country country) {
        dao.delete(country);        
    }
    
    
}