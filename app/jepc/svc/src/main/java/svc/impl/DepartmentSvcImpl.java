package svc.impl;

import dao.DepartmentDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import model.Department;
import svc.DepartmentSvc;

/**
 *
 * @author jpolanco
 */
@Stateless
public class DepartmentSvcImpl implements DepartmentSvc {

    private @Inject DepartmentDAO departmentDAO;

    @Override
    public void save(Department department) {
        try {
            departmentDAO.save(department);
        } catch(Exception exception) {
            exception.printStackTrace();
            throw exception;
        }
    }

    @Override
    public void update(Department department) {
        try {
            departmentDAO.update(department);
        } catch(IllegalAccessException exception){
            exception.printStackTrace();            
        } catch(Exception exception){
            exception.printStackTrace();
        }
    }

    @Override
    public Department findById(Integer id) {
        return departmentDAO.findById(id);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentDAO.getAllDepartments();
    }

    @Override
    public void delete(Department department) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}