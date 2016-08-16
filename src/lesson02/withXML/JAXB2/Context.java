package lesson02.withXML.JAXB2;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Context {
    static final String PACKAGE = DataObject.class.getPackage().getName();

    public static void main(String[] args) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(PACKAGE);
        Marshaller m = jc.createMarshaller();
        Unmarshaller um = jc.createUnmarshaller();
        File file = new File("D:\\JAVA\\MainWorkspace\\PrerareForTheCourse\\src\\workwithXML\\file.xml");
        m.marshal(new DataObject(), file);
        DataObject obj = (DataObject) um.unmarshal(file);
        System.out.println(obj.getI());
    }
}
