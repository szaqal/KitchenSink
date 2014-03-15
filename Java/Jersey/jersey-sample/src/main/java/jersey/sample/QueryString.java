package jersey.sample;

import javax.ws.rs.*;

/**
 * Created by pmalczyk on 3/15/14.
 */
@Path("/querystring")
public class QueryString {


    @GET
    @Produces("text/plain")
    public String get(@QueryParam("querycontent") @DefaultValue("default") String content) {
        return "content " + content;

    }
}
