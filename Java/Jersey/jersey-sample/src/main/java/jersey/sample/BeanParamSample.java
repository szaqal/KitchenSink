package jersey.sample;

import javax.ws.rs.*;

/**
 * Created by pmalczyk on 3/15/14.
 */
@Path("/beanParam/{pathParam}")
public class BeanParamSample {


    @POST
    @Produces("text/plain")
    public String post(@BeanParam BeanParamContent beanParamContent) {
        return "Uploaded " + beanParamContent.toString();
    }


    public static class BeanParamContent {

        @PathParam("pathParam")
        public String pathParam;

        @HeaderParam("User-Agent")
        public String header;

        public String getHeader() {
            return header;
        }

        public void setHeader(String header) {
            this.header = header;
        }


        public String getPathParam() {
            return pathParam;
        }

        public void setPathParam(String pathParam) {
            this.pathParam = pathParam;
        }

        @Override
        public String toString() {
            return getPathParam() + " : " + getHeader();
        }
    }


}


