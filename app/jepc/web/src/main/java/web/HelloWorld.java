/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import javax.annotation.ManagedBean;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.Person;
import svc.PersonSvc;

/**
 *
 * @author jpolanco
 */

@ManagedBean
@Path("helloworld")
public class HelloWorld {        
    
    @Resource
    ServletContext context;   
    
    private @Inject PersonSvc service;
    
    @GET
    @Path("hello")
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        return "Hello World!";
    }
    
    @GET
    @Path("transaction/persist")
    @Produces(MediaType.APPLICATION_JSON)
    public String save() {                
        
        Person p = new Person();
        p.setId(0);
        p.setName("Michael");
        p.setLastname("Jordan");
        
        service.save(p);

        return "success";
    }

}