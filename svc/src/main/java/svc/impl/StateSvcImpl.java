package svc.impl;

import dao.StateDAO;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import model.State;
import svc.StateSvc;

/**
 *
 * @author jpolanco
 */
@Stateless
public class StateSvcImpl implements StateSvc {

    private @Inject StateDAO dao;

    @Override
    public void save(State state) {
        try {
            dao.save(state);
        } catch (Exception e) {
            throw e;
        }        
    }
    
    @Override
    public void update(State state) {
        try {
            state = dao.findById(state.getId());
        } catch (Exception e) {
            throw e;
        }

    }
    
    @Override
    public State findById(Integer id) {
        State state = null;
        try {
            state = dao.findById(id);
        } catch (Exception e)  {
            e.printStackTrace();
        }

        return state;
    }

    @Override
    public List<State> getAllStates() {        
        return dao.getAllStates();
    }

    @Override
    public void delete(State state) {
        dao.delete(state);
    }
    
    
}