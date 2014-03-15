package jersey.sample;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Created by pmalczyk on 3/15/14.
 */
@Path("/responses/json")
public class JsonResponseResource {

    @GET
    @Produces("application/json")
    public Response getHello() {
        return Response.ok("{message:Hi}").build();
    }

}
