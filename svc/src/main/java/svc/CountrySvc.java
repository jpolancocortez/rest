/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svc;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import model.Country;

/**
 *
 * @author jpolanco
 */
public interface CountrySvc {

    void save(Country country);
    
    void update(Country country);
    
    Country findById(Integer id);
    
    List<Country> getAllCountries();
    
    void delete(Country country);

}