package jersey.sample;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by pmalczyk on 3/15/14.
 */
@XmlRootElement(name = "myresponse")
public class MyResponse implements Serializable {

    @XmlElement
    public String myMessage = "HELLO";

    public MyResponse() {
    }


}
