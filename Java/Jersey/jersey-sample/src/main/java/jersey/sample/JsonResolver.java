package jersey.sample;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 * Created by pmalczyk on 3/15/14.
 */
@Provider
@Produces({ MediaType.APPLICATION_JSON })
public class JsonResolver implements ContextResolver<ObjectMapper> {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonResolver.class);

    final ObjectMapper defaultObjectMapper;

    public JsonResolver() {
        LOGGER.info("########");
        defaultObjectMapper = createDefaultMapper();
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return defaultObjectMapper;
    }

    private static ObjectMapper createDefaultMapper() {
        final ObjectMapper result = new ObjectMapper();
        result.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
        result.configure(SerializationConfig.Feature.USE_ANNOTATIONS, true);

        return result;
    }

}
