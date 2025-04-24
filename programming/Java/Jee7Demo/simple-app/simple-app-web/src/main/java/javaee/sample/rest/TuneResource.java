package javaee.sample.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javaee.sample.model.Tune;
import javaee.sample.service.TuneService;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
@Path("/tunes")
@RequestScoped
public class TuneResource {
	
    @Inject
    TuneService tuneService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tune> listAllMembers() {
        return tuneService.getAll();
    }
}
