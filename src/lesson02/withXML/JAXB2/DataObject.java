package lesson02.withXML.JAXB2;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "dataObj")
public class DataObject {

    public int getI() {
        return i;
    }

    @XmlElement
    private int i = 19;

    @XmlElement
    @XmlElementWrapper(name = "elems")
    List<CustomObject> custom;


}
