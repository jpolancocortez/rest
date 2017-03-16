package dao;

import java.util.List;
import model.Employee;

/**
 *
 * @author jpolanco
 */
public interface EmployeeDAO extends PersonDAO {

    Employee getByCode(String code);

    List<Employee> getEmployees();

}