package jersey.sample;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Created by pmalczyk on 3/15/14.
 *
 * http://localhost:8080/rest/query/sdd
 */
@Path("/query/{querycontent}")
public class QueryParamResources {

    @GET
    @Produces("text/plain")
    public String get(@PathParam("querycontent") String content) {
        return "content " + content;

    }
}
