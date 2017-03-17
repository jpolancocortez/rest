/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svc;

import java.util.List;
import model.Department;

/**
 *
 * @author jpolanco
 */
public interface DepartmentSvc {

    void save(Department department);
    
    void update(Department department);
    
    Department findById(Integer id);
    
    List<Department> getAllDepartments();
    
    void delete(Department department);

}