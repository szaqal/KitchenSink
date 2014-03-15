package jersey.sample;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by pmalczyk on 3/15/14.
 */
@Path("/sample")
public class SampleResrouce {

    @GET
    @Produces("text/plain")
    public String sayHello() {
        return "Resource sample";
    }
}
