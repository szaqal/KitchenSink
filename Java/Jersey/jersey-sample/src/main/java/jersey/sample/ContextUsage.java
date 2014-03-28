package jersey.sample;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

/**
 * Created by pmalczyk on 3/15/14.
 *
 * http://localhost:8080/rest/contextusage
 */
@Path("/contextusage")
public class ContextUsage {

    @GET
    @Produces("text/plain")
    public String get(@Context HttpHeaders hh) {
        return hh.getRequestHeaders().toString();
    }
}
