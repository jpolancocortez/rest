/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.util.List;
import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.Hero;
import svc.HeroSvc;

/**
 *
 * @author jpolanco
 */
@ManagedBean
@Path("heroes")
public class HeroResource {
    
    private @Inject HeroSvc svc;
        
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)    
    public Hero getHero(@PathParam("id") Integer id){
        return svc.findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hero> getAllHeroes() {
        return svc.find();
    }

}