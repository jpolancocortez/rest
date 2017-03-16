package dao.impl;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import dao.EmployeeDAO;
import model.Employee;

/**
 *
 * @author jpolanco
 */
@util.qualifier.Employee
@ApplicationScoped
public class EmployeeDAOImpl extends PersonDAOImpl implements EmployeeDAO {

    @Override
    public Employee getByCode(String code) {
        return (Employee)em.createQuery("select e from Employee e where e.code = :code").
                            setParameter("code", code).
                            getSingleResult();
    }

    @Override
    public List<Employee> getEmployees() {
        return em.createQuery("SELECT p FROM Person p WHERE TYPE(p) = Employee").getResultList();
    }

}