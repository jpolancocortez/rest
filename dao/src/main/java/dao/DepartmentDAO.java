package dao;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import model.Department;

/**
 *
 * @author jpolanco
 */
public interface DepartmentDAO {

    void save(Department department);
    
    void update(Department department) throws IllegalAccessException, InvocationTargetException;
    
    Department findById(Integer id);
    
    List<Department> getAllDepartments();
    
    void delete(Department department);

}