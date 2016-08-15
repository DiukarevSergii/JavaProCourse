package lesson02.examples.required;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Required {

    @XmlElement(required = false)
    private String s = "13";

    @XmlElement
    private int a;

    public String getS() {
        return s;
    }
}
