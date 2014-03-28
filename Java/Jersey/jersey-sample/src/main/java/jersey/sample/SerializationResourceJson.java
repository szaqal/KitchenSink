package jersey.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by pmalczyk on 3/15/14.
 * http://localhost:8080/rest/serialized/json
 */
@Path("/serialized/json")
public class SerializationResourceJson {

    private static final Logger LOGGER = LoggerFactory.getLogger(SerializationResourceJson.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getResponse() {
        LOGGER.info("Serialization resource JSON");
        MyResponse response = new MyResponse();
        return response;
    }

}
