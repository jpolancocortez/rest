package web;

import java.util.List;
import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.Department;
import svc.DepartmentSvc;

/**
 *
 * @author jpolanco
 */
@ManagedBean
@Path("departments")
public class DepartmentResource {

    private @Inject DepartmentSvc service;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String save(Department department) {
        service.save(department);
        return "success";
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Department update(Department department) {
        try {
            service.update(department);
        } catch(Exception exception) {
            exception.printStackTrace();
        }
        return department;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Department getDepartment(@PathParam("id") Integer id) {
        return service.findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Department> getDepartments() {
        return service.getAllDepartments();
    }

}