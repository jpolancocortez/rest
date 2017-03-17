package dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.DepartmentDAO;
import model.Department;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author jpolanco
 */
@ApplicationScoped
public class DepartmentDAOImpl implements DepartmentDAO {

    @PersistenceContext(unitName = "project-PU")
    private EntityManager em;

    @Override
    public void save(Department department) {
        if (department.getId() == null) {
            department.setId(0);
        }

        try {
            em.persist(department);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void update(Department department) throws IllegalAccessException, InvocationTargetException {
        Department d;
        try {
            d = em.find(Department.class,department.getId());
            BeanUtils.copyProperties(d, department);
        } catch(Exception exception) {
            throw exception;
        }
    }

    @Override
    public Department findById(Integer id) {
        Department department = null;

        try {
            department = em.find(Department.class, id);
        } catch (Exception e)  {
            e.printStackTrace();
        }

        return department;
    }

    @Override
    public List<Department> getAllDepartments() {
        return em.createQuery("select d from Department d").getResultList();
    }

    @Override
    public void delete(Department department) {
        em.remove(department);
    }

}