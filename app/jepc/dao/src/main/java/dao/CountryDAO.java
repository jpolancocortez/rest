package dao;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import model.Country;

/**
 *
 * @author jpolanco
 */
public interface CountryDAO {

    void save(Country country);
    
    void update(Country country);
    
    Country findById(Integer id);
    
    List<Country> getAllCountries();
    
    void delete(Country country);

}