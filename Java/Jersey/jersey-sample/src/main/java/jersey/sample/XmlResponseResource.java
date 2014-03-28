package jersey.sample;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Created by pmalczyk on 3/15/14.
 *
 * http://localhost:8080/rest/serialized/xml
 */
@Path("/responses/xml")
public class XmlResponseResource {

    @GET
    @Produces("application/xml")
    public Response getHello() {
        return Response.ok("<message>Hi</message>").build();
    }

}
