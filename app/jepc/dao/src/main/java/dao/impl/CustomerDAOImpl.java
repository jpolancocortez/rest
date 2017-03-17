package dao.impl;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NoResultException;
import dao.CustomerDAO;
import model.Customer;

/**
 *
 * @author jpolanco
 */
@   util.qualifier.Customer
@ApplicationScoped
public class CustomerDAOImpl extends PersonDAOImpl implements CustomerDAO {

    @Override
    public Customer findByNit(String nit) {
        Customer customer = null;
        try {
            customer = (Customer)em.createQuery("SELECT c FROM Customer c WHERE c.nit = :nit").
                                    setParameter("nit", nit).
                                    getSingleResult();
        } catch(NoResultException exception) {
            throw exception;
        } catch(Exception exception) {
            throw exception;
        }
        return customer;
    }
 
    @Override
    public List<Customer> getCustomers() {        
        return em.createQuery("SELECT p FROM Person p WHERE TYPE(p) = Customer").getResultList();
        
    }

}