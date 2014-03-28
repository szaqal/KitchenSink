package jersey.sample;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.Serializable;

/**
 * Created by pmalczyk on 3/15/14.
 */
@Path("/responses")
public class JsonResponseResource {

    @GET
    @Path("/json")
    @Produces("application/json")
    public Response getHelloResponse() {
        return Response.ok("{message:Hi}").build();
    }


    @GET
    @Path("/string")
    @Produces("application/json")
    public String getHelloString() {
        return "Hi";
    }

    @GET
    @Path("/string2")
    @Produces("application/json")
    public Response getHelloString2() {
        return Response.ok(new Object(){ public String getResult() { return "Hi"; } }).build();
    }

}
