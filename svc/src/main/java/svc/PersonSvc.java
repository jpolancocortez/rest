/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svc;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import model.Customer;
import model.Employee;
import model.Person;


/**
 *
 * @author jpolanco
 */
public interface PersonSvc {
 
    void save(Person person);
    
    void update(Person person) throws IllegalAccessException, InvocationTargetException;
    
    Person getPersonInformation(Integer id);    
    
    Customer getCustomerInformation(String nit);
    
    Employee getEmployeeInformation(String code);
    
    List<Person> getPeople();
    
    List<Customer> getCustomers();
    
    List<Employee> getEmployees();

}