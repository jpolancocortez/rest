package web;

import java.util.List;
import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.Customer;
import model.Employee;
import model.Person;
import svc.PersonSvc;

/**
 *
 * @author jpolanco
 */
@ManagedBean
@Path("")
public class PersonResource {

    private @Inject PersonSvc service;

    @POST
    @Path("people")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String savePerson(Person person) {
        service.save(person);
        return "success";
    }

    @POST
    @Path("customers")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String saveCustomer(Customer customer) {
        service.save(customer);
        return "success";
    }

    @POST
    @Path("employees")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String saveEmployee(Employee employee) {
        service.save(employee);
        return "success";
    }
    
    @GET
    @Path("people/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonInformation(@PathParam("id") Integer id) {
        Person person = null;
        try {
            person = service.getPersonInformation(id);
        } catch(Exception exception) {
            exception.getMessage();
        }
        return person;
    }

    @GET
    @Path("customers/{nit}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getCustomerInformation(@PathParam("nit") String nit) {
        Person person = null;
        try {
            service.getCustomerInformation(nit);
        } catch(Exception exception) {
            exception.getMessage();
        }
        return person;
    }
    
    @GET
    @Path("employees/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getEmployeeInformation(@PathParam("code") String code) {
        Person person = null;
        try {
            service.getEmployeeInformation(code);
        } catch(Exception exception) {
            exception.getMessage();
        }
        return person;
    }

    @GET
    @Path("customers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getCustomers() {       
        return service.getCustomers();
    }
    
    @GET
    @Path("employees")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getEmployees() {        
        return service.getEmployees();
    }

}