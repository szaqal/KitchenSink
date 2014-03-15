package jersey.sample;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by pmalczyk on 3/15/14.
 */
@JsonAutoDetect
@XmlRootElement(name = "myresponse")
public class MyResponse implements Serializable {

    @JsonProperty("myMessage")
    @XmlElement
    public String myMessage = "HELLO";

    public MyResponse() {
    }


}
