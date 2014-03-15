package jersey.sample;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.ws.Response;

/**
 * Created by pmalczyk on 3/15/14.
 */
@Provider
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class ResponseResolver implements ContextResolver<JAXBContext> {
    private JAXBContext ctx;

    public ResponseResolver() {
        try {
            this.ctx = JAXBContext.newInstance(
                    MyResponse.class
            );
        } catch (JAXBException ex) {
            throw new RuntimeException(ex);
        }
    }

    public JAXBContext getContext(Class<?> type) {
        return (type.equals(Response.class) ? ctx : null);
    }
}
