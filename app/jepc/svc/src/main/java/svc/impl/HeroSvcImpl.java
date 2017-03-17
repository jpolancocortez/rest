/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svc.impl;

import dao.HeroDAO;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import model.Hero;
import svc.HeroSvc;

/**
 *
 * @author jpolanco
 */
@Stateless
public class HeroSvcImpl implements HeroSvc {

    private @Inject HeroDAO dao;
    
    @Override
    public void save(Hero h) {
        dao.save(h);
    }

    @Override
    public void update(Hero h) throws IllegalAccessException, InvocationTargetException {
        dao.update(h);        
    }

    @Override
    public Hero findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public List<Hero> find() {
        return dao.find();
    }

}