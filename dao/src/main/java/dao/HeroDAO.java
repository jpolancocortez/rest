/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import model.Hero;

/**
 *
 * @author jpolanco
 */
public interface HeroDAO {

    void save(Hero h);

    void update(Hero h) throws IllegalAccessException, InvocationTargetException;

    Hero findById(Integer id);
    
    List<Hero> find();

}