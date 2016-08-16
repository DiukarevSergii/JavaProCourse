package lesson02.withXML.root;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {

    @XmlElement
    private String foo;

    @XmlElement(required = true)
    private int bar;

    @XmlElement(required = false)
    private String baz = "12";

}