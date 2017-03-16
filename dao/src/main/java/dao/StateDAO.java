package dao;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import model.State;

/**
 *
 * @author jpolanco
 */
public interface StateDAO {

    void save(State state);
    
    void update(State state);
    
    State findById(Integer id);
    
    List<State> getAllStates();
    
    void delete(State state);

}