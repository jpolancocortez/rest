/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svc;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import model.State;

/**
 *
 * @author jpolanco
 */
public interface StateSvc {

    void save(State state);

    void update(State state);

    State findById(Integer id);

    List<State> getAllStates();

    void delete(State state);

}