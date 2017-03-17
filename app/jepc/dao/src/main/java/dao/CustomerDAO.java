package dao;

import java.util.List;
import model.Customer;

/**
 *
 * @author jpolanco
 */
public interface CustomerDAO extends PersonDAO {

    /**
     * @param nit the nit of instance Customer
     * @return the instance with the nit was searched
     */
    Customer findByNit(String nit);
    
        /**
     * @return all instances of Customer
     */
    List<Customer> getCustomers();

}