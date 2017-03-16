/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svc.impl;

import dao.CustomerDAO;
import dao.EmployeeDAO;
import dao.PersonDAO;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import model.Customer;
import model.Employee;
import model.Person;
import svc.PersonSvc;

/**
 *
 * @author jpolanco
 */

@Stateless
public class PersonSvcImpl implements PersonSvc {

    @Inject PersonDAO personDAO;
    @Inject @util.qualifier.Customer CustomerDAO customerDAO;
    @Inject @util.qualifier.Employee EmployeeDAO employeeDAO;
    
    @Override
    public void save(Person person) {        
        try {
            personDAO.save(person);
        } catch(Exception e) {
            //TODO log the exception
            e.printStackTrace();
        }
    }

    @Override
    public void update(Person person) throws IllegalAccessException, InvocationTargetException {
        try {
            personDAO.update(person);
        } catch(IllegalAccessException exception) {
            exception.printStackTrace();
        } catch(InvocationTargetException exception) {
            exception.printStackTrace();
        }
    }        

    @Override
    public Person getPersonInformation(Integer id) {        
        return personDAO.findById(id);
    }

    @Override
    public Customer getCustomerInformation(String nit) {
        return customerDAO.findByNit(nit);
    }

    @Override
    public Employee getEmployeeInformation(String code) {
        return employeeDAO.getByCode(code);
    }

    @Override
    public List<Person> getPeople() {        
        return personDAO.getPeople();
    }

    @Override
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }    

    @Override
    public List<Employee> getEmployees() {
        return employeeDAO.getEmployees();
    }

}