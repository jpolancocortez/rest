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
import model.State;
import svc.StateSvc;

/**
 *
 * @author jpolanco
 */
@ManagedBean
@Path("states")
public class StateResource {

    private @Inject StateSvc svc;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)    
    public String save(State state) {
        svc.save(state);
        return "success";
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)    
    public String update(State state) {
        svc.update(state);
        return "success";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<State> getAllStates() {        
        return svc.getAllStates();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public State getState(@PathParam("id") Integer id) {
        return svc.findById(id);
    }
    
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(State c) {
        svc.delete(c);
        return "success";
    }

}