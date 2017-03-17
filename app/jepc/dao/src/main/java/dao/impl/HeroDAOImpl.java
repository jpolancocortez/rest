/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.HeroDAO;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Hero;

/**
 *
 * @author jpolanco
 */
@RequestScoped
public class HeroDAOImpl implements HeroDAO {

    @PersistenceContext(unitName = "project-PU")
    EntityManager em;
    
    @Override
    public void save(Hero h) {
        em.persist(h);
    }

    @Override
    public void update(Hero h) throws IllegalAccessException, InvocationTargetException {
        
    }

    @Override
    public Hero findById(Integer id) {
        Hero hero = null;
        
        try {
            System.out.println("find");
            hero = em.find(Hero.class, id);
            System.out.println("result " + hero);
        } catch(Exception ex){
            System.out.println("ex");
            ex.printStackTrace();
        }
        return hero;
    }

    @Override
    public List<Hero> find() {
        return em.createQuery("SELECT h FROM Hero h").getResultList();
    }

}