package jersey.sample;

import javax.ws.rs.*;

/**
 * Created by pmalczyk on 3/15/14.
 *
 * http://localhost:8080/rest/querystring?querycontent=ss
 */
@Path("/querystring")
public class QueryString {


    @GET
    @Produces("text/plain")
    public String get(@QueryParam("querycontent") @DefaultValue("default") String content) {
        return "content " + content;

    }
}
