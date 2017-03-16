package dao.impl;

import dao.StateDAO;
import java.util.Collections;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.State;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author jpolanco
 */
@RequestScoped
public class StateDAOImpl implements StateDAO {

    @PersistenceContext(unitName = "project-PU")
    protected EntityManager em;
    
    @Override
    public void save(State state) {
        try {
            em.persist(state);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void update(State state) {
        State s = null;        
        try {
            s = em.find(State.class, state.getId());
            s.setName(state.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public State findById(Integer id) {
        State state = null;

        try {
            state = em.find(State.class, id);
        } catch (Exception e)  {
            e.printStackTrace();
        }
        
        return state;
    }

    @Override
    public List<State> getAllStates() {
        List<State> list = Collections.EMPTY_LIST;
        try {
            list = em.createQuery("SELECT s FROM State s").getResultList();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public void delete(State state) {
        em.remove(state);
    }

}