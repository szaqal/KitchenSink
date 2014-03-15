package jersey.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by pmalczyk on 3/15/14.
 */
@Path("/serialized")
public class SerializationResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(SerializationResource.class);

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public MyResponse getResponse() {
        LOGGER.info("Serilization resource");
        MyResponse response = new MyResponse();
        return response;
    }







}
