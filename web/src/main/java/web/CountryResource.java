package web;

import java.util.List;
import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.Country;
import svc.CountrySvc;

/**
 *
 * @author jpolanco
 */
@ManagedBean
@Path("countries")
public class CountryResource {

    private @Inject CountrySvc svc;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)    
    public String save(Country country) {
        svc.save(country);
        return "success";
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)    
    public String update(Country country) {
        svc.update(country);
        return "success";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Country> getAllCountries() {        
        return svc.getAllCountries();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Country getCountry(@PathParam("id") Integer id) {
        return svc.findById(id);
    }
    
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(Country c) {
        svc.delete(c);
        return "success";
    }

}